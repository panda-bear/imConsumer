package com.zjrc.sxzz;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.util.HttpClientUtil;

public class TestFeature {
	
	private static Logger log = LoggerFactory.getLogger(TestFeature.class);
	
	@Test
	public void testGetToken() {
		JSONObject o = new JSONObject();
		o.put("account", "13906811024");
		o.put("password", "2b4e1560bed87dd2630570e5f196945d");
		
		String res = HttpClientUtil.doPost("http://20.21.1.146:8098/sxzzapi/api/account/login", o.toJSONString());
		log.info(res);
	}
}
