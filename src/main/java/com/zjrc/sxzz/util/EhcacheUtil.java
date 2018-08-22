package com.zjrc.sxzz.util;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheUtil {  
	  
    private static final String DEFAULT_PATH = "/ehcache_default.xml";  
  
    private URL url;  
    
    private static String DEFAULT_CACHE_NAME = "defaultCache";
  
    private CacheManager manager;  
  
    private static EhcacheUtil ehCacheUtil;  
  
    private EhcacheUtil(String path) {  
        url = getClass().getResource(path);  
        manager = CacheManager.create(url);  
    }  
  
    /**默认基于ehcache_default.xml 配置
     * @return
     */
    public static EhcacheUtil getInstance() {  
        if (ehCacheUtil== null) {  
        	ehCacheUtil= new EhcacheUtil(DEFAULT_PATH);  
        }  
        return ehCacheUtil;  
    }  
  
    public void put(String cacheName, String key, Object value) {  
    	cacheName =  (null == cacheName || "" == cacheName.trim()) ? DEFAULT_CACHE_NAME : cacheName;
        Cache cache = manager.getCache(cacheName);  
        Element element = new Element(key, value);  
        cache.put(element);  
    }  
  
    public Object get(String cacheName, String key) {  
    	cacheName =  (null == cacheName || "" == cacheName.trim()) ? DEFAULT_CACHE_NAME : cacheName;
        Cache cache = manager.getCache(cacheName);  
        Element element = cache.get(key);  
        return element == null ? null : element.getObjectValue();  
    }  
  
    public Cache get(String cacheName) {  
    	cacheName =  (null == cacheName || "" == cacheName.trim()) ? DEFAULT_CACHE_NAME : cacheName;
        return manager.getCache(cacheName);  
    }  
  
    public void remove(String cacheName, String key) {  
    	cacheName =  (null == cacheName || "" == cacheName.trim()) ? DEFAULT_CACHE_NAME : cacheName;
        Cache cache = manager.getCache(cacheName);  
        cache.remove(key);  
    }  
  
}
