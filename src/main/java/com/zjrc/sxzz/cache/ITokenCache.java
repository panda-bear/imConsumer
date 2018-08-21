package com.zjrc.sxzz.cache;

public interface ITokenCache {
	
	/**从开放平台或缓存中获取token
	 * @return
	 */
	String getToken();
	
	/**清楚缓存
	 * 
	 */
	void deleteToken();
}
