package com.zjrc.sxzz.synTask;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import com.zjrc.sxzz.dao.DeptMapper;
import com.zjrc.sxzz.dao.HospitalMapper;
import com.zjrc.sxzz.entity.Dept;
import com.zjrc.sxzz.entity.Hospital;
import com.zjrc.sxzz.entity.Syn;
import com.zjrc.sxzz.synTask.enumType.SynType;
import com.zjrc.sxzz.util.ConfigUtil;
import com.zjrc.sxzz.util.UUIDUtil;

/**同步科室业务数据
 * @author Administrator
 *
 */
@Component
public class SynDeptTask extends SynTask {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private HospitalMapper hosMapper;
	
	@Override
	protected String synBusinessData(Syn syn) {
		String res = null;
		Dept dept = deptMapper.selectByPrimaryKey(syn.getBusinessId());
		Hospital hos = hosMapper.selectByPrimaryKey(dept.getHospitalId());
		JSONObject obj = new JSONObject();
		switch(transferStr(syn.getSynType())) {
		case CREATE:
			log.info("开始同步创建{}级科室{}{} ,其上级科室id为{}-----------" ,dept.getLevel() , dept.getDeptId() , dept.getName() , dept.getParentDeptId());
			//二级科室数据存在无上级科室id,统一解决方案：每个医院创建一级科室 医院科室 ,将这些特殊的二级科室挂在该科室下
			if (dept.getLevel()==2 && StringUtils.isNullOrEmpty(dept.getParentDeptId())) {//特殊二级科室数据
				//先创建特殊一级医院科室
				String abnormalDeptName = ConfigUtil.getInstance().getString("oneLevelDeptName");
				Dept abnormalDept = null;
				synchronized(this) { //并发访问安全
					abnormalDept = deptMapper.getAbnormalOneDept(abnormalDeptName, dept.getHospitalId());
					if (abnormalDept == null) {
						abnormalDept = generateDept(abnormalDeptName , dept.getHospitalId());
						synCreateDept(hos.getHospitalIdDing() , abnormalDept);
					}
				}
				//再同步创建该特殊二级科室
				res = synCreateDept(abnormalDept.getDeptIdDing() , dept);
				return res;
			} 
			//正常科室数据
			if (dept.getLevel()==1 ||(dept.getLevel()==2 && !StringUtils.isNullOrEmpty(dept.getParentDeptId().trim()))) {
				Dept oneDept = deptMapper.selectByPrimaryKey(dept.getParentDeptId());
				res = synCreateDept(dept.getLevel()==1?hos.getHospitalIdDing() : oneDept.getDeptIdDing() , dept);
				return res;
			}
			break;
		case UPDATE:
			log.info("开始同步更新{}级科室{}{} ,其上级科室id为{}-----------" ,dept.getLevel() , dept.getDeptId() , dept.getName() , dept.getParentDeptId());
			obj.put("id", dept.getDeptIdDing());
			obj.put("name", dept.getName());
			res = imClient.updateDept(obj.toJSONString());
			break;
		case DELETE:
			log.info("开始同步删除{}级科室{}{} ,其上级科室id为{}-----------" ,dept.getLevel() , dept.getDeptId() , dept.getName() , dept.getParentDeptId());
			res = imClient.deleteDept(dept.getDeptIdDing());
			break;
		}
		return res;
	}

	@Override
	protected void decideSynType(Syn syn) {
		//判断是否是同步创建
		Dept dept = deptMapper.selectByPrimaryKey(syn.getBusinessId());
		if (StringUtils.isNullOrEmpty(dept.getDeptIdDing())) {//同步创建
			syn.setSynType(SynType.CREATE.getType());
			return;
		}
		//判断是同步更新 还是 同步删除
		String res = imClient.selectDeptById(dept.getDeptIdDing().trim());
		JSONObject obj = JSON.parseObject(res);
		if ("0".equals(obj.getString("errcode"))) {
			//根据业务数据status决定是同步创建还是删除
			if ("0".equals(dept.getStatus().trim())) {
				syn.setSynType(SynType.UPDATE.getType());
				return;
			} else {
				syn.setSynType(SynType.DELETE.getType());
				return;
			}
		} else {//同步创建
			syn.setSynType(SynType.CREATE.getType());
			return;
		}
	}
	
	
	/**插入生成特殊一级科室
	 * @param name
	 * @param hospitalId
	 * @return
	 */
	private Dept generateDept(String name , String hospitalId) {
		Dept dept = new Dept();
		dept.setDeptId(UUIDUtil.getUUID());
		dept.setHospitalId(hospitalId);
		dept.setName(name);
		dept.setLevel(1);
		dept.setBusinessType("-1");//特殊业务类型
		dept.setInnerDeptId("-1");
		dept.setStatus("0");
		deptMapper.insertSelective(dept);
		return dept;
	}
	
	
	/**同步创建科室
	 * @param name
	 * @param parentId 医院dingId 或 上级科室ding id
	 * @return
	 */
	private String synCreateDept(String parentId , Dept dept) {
		JSONObject obj = new JSONObject();
		obj.put("name", dept.getName());
		obj.put("parentid", parentId);
		String res = imClient.createDept(obj.toJSONString());
		log.info("同步创建{}医院 ,{}级科室{}{}响应结果------------------->{}" , dept.getHospitalId() ,dept.getLevel() , dept.getDeptId()
				,dept.getName() ,res);
		obj = JSON.parseObject(res);
		if ("0".equals(obj.getString("errcode"))) {
			dept.setDeptIdDing(obj.getString("id"));
			deptMapper.updateByPrimaryKeySelective(dept);
		}
		return res;
	}
	

}
