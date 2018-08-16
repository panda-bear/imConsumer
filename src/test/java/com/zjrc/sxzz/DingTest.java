package com.zjrc.sxzz;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.config.DingYmlConfig;
import com.zjrc.sxzz.util.HttpClientUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DingTest {
	protected Logger log = LoggerFactory.getLogger(DeptTests.class);
	
	@Autowired
	protected DingYmlConfig ymlConfig;
	
	protected String token;
	
	/**
	 * 获取token
	 */
	@Before
	public void init() {
		String corpId = ymlConfig.getCorpId();
		String corpSecret = ymlConfig.getCorpSecret();
		String res = HttpClientUtil.doGet("https://oapi.dingtalk.com/gettoken?corpid="+corpId+"&corpsecret="+corpSecret);
		log.info("钉钉响应----->{}",res);
		JSONObject object = JSON.parseObject(res);
		token = object.getString("access_token");
		log.info("获取到token------>{}" , token);
	}	
}
