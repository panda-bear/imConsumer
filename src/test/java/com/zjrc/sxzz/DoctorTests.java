package com.zjrc.sxzz;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.util.HttpClientUtil;

public class DoctorTests extends DingTest {
	
	/**
	 * 创建医生
	 */
	@Test
	public void createDoctor() {
		JSONObject object = new JSONObject();
		object.put("userid", "2");
		object.put("name", "赵云");
		object.put("department", new String[] {"74846442"});
		object.put("mobile", "18258491309");
		String res = HttpClientUtil.doPost("https://oapi.dingtalk.com/user/create?access_token="+token, object.toJSONString());
		log.info("创建医生响应----->{}" ,res );
	}
	
	/**
	 * 删除医生
	 */
	@Test
	public void deleteDoctor() {
		String res = HttpClientUtil.doGet("https://oapi.dingtalk.com/user/delete?access_token="+ token +"&userid=1");
		log.info("删除医生响应----->{}" ,res );
	}	
}
