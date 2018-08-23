package com.zjrc.sxzz.pattern.factory;


import com.zjrc.sxzz.cache.EhcacheTokenCache;
import com.zjrc.sxzz.cache.ITokenCache;
import com.zjrc.sxzz.util.HttpClientUtil;

public class DingImClientProduct extends ImClientProduct{
	
	private ITokenCache tokenCache = new EhcacheTokenCache();
	
	
	public DingImClientProduct(String urlPrefix) {
		super(urlPrefix);
	}
	
	@Override
	public String getUserIdByCode(String code) {
		return HttpClientUtil.doGet(urlPrefix+"/user/getuserinfo?access_token="+tokenCache.getToken()+"&code="+code);
	}
	
	@Override
	public String createDept(String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/department/create?access_token=" + tokenCache.getToken(), jsonStr);
	}

	@Override
	public String updateDept(String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/department/update?access_token=" + tokenCache.getToken(), jsonStr);
	}

	@Override
	public String deleteDept( String id) {
		return HttpClientUtil.doGet(urlPrefix+"/department/delete?access_token="+tokenCache.getToken()+"&id="+id);
	}

	@Override
	public String createDoctor(String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/user/create?access_token=" + tokenCache.getToken(), jsonStr);
	}

	@Override
	public String updateDoctor(String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/user/update?access_token=" + tokenCache.getToken(), jsonStr);
	}

	@Override
	public String deleteDoctors(String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/user/batchdelete?access_token=" + tokenCache.getToken(), jsonStr);
	}

	@Override
	public String deleteDoctor(String id) {
		return HttpClientUtil.doGet(urlPrefix+"/user/delete?access_token="+tokenCache.getToken()+"&userid="+id);
	}

}
