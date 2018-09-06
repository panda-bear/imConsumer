package com.zjrc.sxzz;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.util.HttpClientUtil;

public class DoctorTest extends DingTest {
	
	
	@Test
	public void getDeptLists() {
		//获取一级部门列表
		//https://oapi.dingtalk.com/department/list?access_token=ACCESS_TOKEN
		String res = HttpClientUtil.doGet("https://oapi.dingtalk.com/department/list?fetch_child=true&access_token="+token);
		log.info("获取部门列表结果------{}", res);
	}
	
	@Test
	public void createDoctor() {
		//创建医生用户
		JSONObject o = new JSONObject();
		o.put("userid", "9947");
		o.put("name", "张迎霞");
		o.put("department", new String[] {"74846442"});
		o.put("mobile", "13906811024");
		String res = imclient.createDoctor(o.toJSONString());
		log.info("创建医生结果------{}", res);
	}
	
	@Test
	public void selectDoctor() {
		String res = HttpClientUtil.doGet("https://oapi.dingtalk.com/user/get?userid=123&access_token="+token);
		log.info(res);
	}	
}
