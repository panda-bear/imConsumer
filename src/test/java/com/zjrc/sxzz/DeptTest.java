package com.zjrc.sxzz;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class DeptTest extends DingTest {
	
	
	@Test
	public void createDept() {
		JSONObject obj = new JSONObject();
		obj.put("name", "医院D");
		obj.put("parentid", "1");
		String res = imclient.createDept(obj.toJSONString());
		log.info("创建部门------------------{}" , res);
		
		JSONObject o = JSON.parseObject(res);
		String id  = o.getString("id");
		res = imclient.deleteDept(id);
		log.info("删除部门------------------{}" , res);
	}
	
}
