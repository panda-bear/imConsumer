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
	public String createAccount(String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/user/create?access_token=" + tokenCache.getToken(), jsonStr);
	}

	@Override
	public String updateAccount(String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/user/update?access_token=" + tokenCache.getToken(), jsonStr);
	}

	@Override
	public String deleteAccounts(String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/user/batchdelete?access_token=" + tokenCache.getToken(), jsonStr);
	}

	@Override
	public String deleteAccount(String id) {
		return HttpClientUtil.doGet(urlPrefix+"/user/delete?access_token="+tokenCache.getToken()+"&userid="+id);
	}

	@Override
	public String selectDeptById(String deptIdDing) {
		return HttpClientUtil.doGet(urlPrefix+"/department/get?access_token="+tokenCache.getToken()+"&id="+deptIdDing);
	}

	@Override
	public String selectAccountById(String accountId) {
		return HttpClientUtil.doGet(urlPrefix+"/user/get?access_token="+tokenCache.getToken()+"&userid="+accountId);
	}

}
