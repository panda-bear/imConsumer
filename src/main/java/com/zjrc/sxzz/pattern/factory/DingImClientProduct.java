package com.zjrc.sxzz.pattern.factory;


import com.zjrc.sxzz.util.HttpClientUtil;

public class DingImClientProduct extends ImClientProduct{
	

	public DingImClientProduct(String urlPrefix) {
		super(urlPrefix);
	}

	@Override
	public String createDept(String token, String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/department/create?access_token=" + token, jsonStr);
	}

	@Override
	public String updateDept(String token, String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/department/update?access_token=" + token, jsonStr);
	}

	@Override
	public String deleteDept(String token , String id) {
		return HttpClientUtil.doGet(urlPrefix+"/department/delete?access_token="+token+"&id="+id);
	}

	@Override
	public String createDoctor(String token, String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/user/create?access_token=" + token, jsonStr);
	}

	@Override
	public String updateDoctor(String token, String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/user/update?access_token=" + token, jsonStr);
	}

	@Override
	public String deleteDoctors(String token, String jsonStr) {
		return HttpClientUtil.doPost(urlPrefix + "/user/batchdelete?access_token=" + token, jsonStr);
	}

	@Override
	public String deleteDoctor(String token , String id) {
		return HttpClientUtil.doGet(urlPrefix+"/user/delete?access_token="+token+"&userid="+id);
	}

}
