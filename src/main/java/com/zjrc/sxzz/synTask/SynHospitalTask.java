package com.zjrc.sxzz.synTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import com.zjrc.sxzz.dao.HospitalMapper;
import com.zjrc.sxzz.entity.Hospital;
import com.zjrc.sxzz.entity.Syn;
import com.zjrc.sxzz.synTask.enumType.SynType;

/**同步医院业务数据
 * @author Administrator
 *
 */
@Component
public class SynHospitalTask extends SynTask {
	
	@Autowired
	private HospitalMapper hosMapper;
	
	@Override
	protected String synBusinessData(Syn syn) {
		String res = null;
		Hospital hos = hosMapper.selectByPrimaryKey(syn.getBusinessId());
		JSONObject obj = new JSONObject();
		switch(transferStr(syn.getSynType())) {
		case CREATE:
			log.info("同步线程{}：开始进行同步创建医院{}{}----------" ,Thread.currentThread().getName(), syn.getBusinessId() , syn.getBusinessName());
			obj.put("name", hos.getName());
			obj.put("parentid", "1");
			obj.put("createDeptGroup", true);  
			res = imClient.createDept(obj.toJSONString());
			obj = JSON.parseObject(res);
			if ("0".equals(obj.getString("errcode"))) {
				hos.setHospitalIdDing(obj.getString("id"));
				hosMapper.updateByPrimaryKeySelective(hos);
			}
			break;
		case UPDATE:
			log.info("同步线程{}: 开始同步更新医院{}{}------------" ,Thread.currentThread().getName(), syn.getBusinessId() , syn.getBusinessName());
			obj.put("id", hos.getHospitalIdDing());
			obj.put("name", hos.getName());
			obj.put("autoAddUser", true);
			res = imClient.updateDept(obj.toJSONString());
			break;
		case DELETE:
			log.info("同步线程{}： 开始同步删除医院{}{}----------" , Thread.currentThread().getName() , syn.getBusinessId() , syn.getBusinessName());
			res = imClient.deleteDept(hos.getHospitalIdDing());
			break;
		}
		return res;
	}

	@Override
	protected void decideSynType(Syn syn) {
		//判断是否是同步创建
		Hospital hos = hosMapper.selectByPrimaryKey(syn.getBusinessId());
		if (StringUtils.isNullOrEmpty(hos.getHospitalIdDing())) {//同步创建
			syn.setSynType(SynType.CREATE.getType());
			return;
		}
		//判断是同步更新 还是 同步删除
		String res = imClient.selectDeptById(hos.getHospitalIdDing().trim());
		JSONObject obj = JSON.parseObject(res);
		if ("0".equals(obj.getString("errcode"))) {
			//根据业务数据status决定是同步创建还是删除
			if ("0".equals(hos.getStatus().trim())) {
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

	

}
