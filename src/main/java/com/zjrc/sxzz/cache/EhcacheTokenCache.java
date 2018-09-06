package com.zjrc.sxzz.cache;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.util.ConfigUtil;
import com.zjrc.sxzz.util.HttpClientUtil;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Component
public class EhcacheTokenCache implements ITokenCache {
	
	private static Logger log = LoggerFactory.getLogger(EhcacheTokenCache.class);
	
	private CacheManager cacheManager;
	
	private Cache cache;
	
	private static String KEY = "token";
	
	public EhcacheTokenCache() {
		 URL url = getClass().getResource("/ehcache.xml");  
		 cacheManager = CacheManager.create(url);
		 cache = cacheManager.getCache("tokenCache"); 
	}
	
	@Override
	public synchronized String getToken() {
		Element ele = cache.get(KEY);
		if (ele == null) {
			ele = new Element(KEY , fetchToken());
			cache.put(ele);
		} 
		return (String)ele.getObjectValue();
	}
	
	/**调用钉钉开放平台获取token
	 * @return
	 */
	private String fetchToken() {
		String corpId = ConfigUtil.getInstance().getString("ding_corpId");
		String corpSecret = ConfigUtil.getInstance().getString("ding_corpSecret");
		log.info("-------------------------->corpId={} , corpSecret={} " , corpId , corpSecret);
		String res = HttpClientUtil.doGet("https://oapi.dingtalk.com/gettoken?corpid="+corpId+"&corpsecret="+corpSecret);
		JSONObject object = JSON.parseObject(res);
		String token = (String)object. get("access_token");
		log.info("<--------------------------token={}" , token);
		return token;
	}
	
	@Override
	public void deleteToken() {
		if (cache != null) {
			cache.remove(KEY);
			log.info("缓存删除了key为{}的元素对象" , KEY);
		}
	}

}
