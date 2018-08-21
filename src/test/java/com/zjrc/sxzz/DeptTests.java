package com.zjrc.sxzz;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.pattern.factory.ImClientFactory;
import com.zjrc.sxzz.util.ConfigUtil;
import com.zjrc.sxzz.util.HttpClientUtil;


public class DeptTests extends DingTest{
	
	
	/**获取token授权范围
	 * 
	 */
	@Test
	public void getScope() {
		String res = HttpClientUtil.doGet("https://oapi.dingtalk.com/auth/scopes?access_token="+token);
		log.info("token授权范围------>{}" , res);
	}
	
	/**获取子部门ID列表
	 * id =1 ，获取根部门即企业的子部门id集
	 * 74902069   74762382
	 */
	@Test
	public void getSubDeptIds() {
		String res = HttpClientUtil.doGet("https://oapi.dingtalk.com/department/list_ids?access_token="+token+"&id=74902069");
		log.info("获取子部门ID列表------>{}" , res);
	}
	
	/**获取部门详情
	 * 
	 */
	@Test
	public void getDeptInfo() {
		String res = HttpClientUtil.doGet("https://oapi.dingtalk.com/department/get?access_token="+token+"&id=74902069");
		log.info("获取部门详情------>{}" , res);
	}
	
	/**创建部门
	 * 可获取部门id
	 */
	@Test
	public void createDept() throws Exception {
		JSONObject hospital = new JSONObject();
		hospital.put("name", "科室BB");
		hospital.put("parentid", "74762382");
		hospital.put("order", "2");
		hospital.put("createDeptGroup", true);
		hospital.put("deptHiding", false);
		
		ImClientFactory imFactory = (ImClientFactory)Class.forName(ConfigUtil.getInstance().getString("concreteFactory")).newInstance();
		String res = imFactory.createImClientProduct().createDept(token, hospital.toJSONString());
		log.info("创建部门------>{}" , res);
	}
	
	
	/**更新部门
	 * 
	 */
	@Test
	public void updateDept() {
		JSONObject hospital = new JSONObject();
		hospital.put("name", "医院A");
		hospital.put("id", "74902069");
		
		String res = HttpClientUtil.doPost("https://oapi.dingtalk.com/department/update?access_token="+token, hospital.toJSONString());
		log.info("更新部门------>{}" , res);
	}
	

}
