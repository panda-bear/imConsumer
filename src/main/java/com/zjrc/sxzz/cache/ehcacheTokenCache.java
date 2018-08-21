package com.zjrc.sxzz.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.util.ConfigUtil;
import com.zjrc.sxzz.util.HttpClientUtil;

@CacheConfig(cacheNames = {"tokenCache"})
@Component
public class ehcacheTokenCache implements ITokenCache {
	
	private static Logger log = LoggerFactory.getLogger(ehcacheTokenCache.class);
	
	@Cacheable(key="#root.targetClass")
	@Override
	public String getToken() {
		String corpId = ConfigUtil.getInstance().getString("ding_corpId");
		String corpSecret = ConfigUtil.getInstance().getString("ding_corpSecret");
		log.info("-------------------------->corpId={} , corpSecret={} " , corpId , corpSecret);
		String res = HttpClientUtil.doGet("https://oapi.dingtalk.com/gettoken?corpid="+corpId+"&corpsecret="+corpSecret);
		JSONObject object = JSON.parseObject(res);
		String token = (String)object. get("access_token");
		log.info("<--------------------------token={}" , token);
		return token;
	}
	
	@CacheEvict(key="#root.targetClass")
	@Override
	public void deleteToken() {
		
	}

}
