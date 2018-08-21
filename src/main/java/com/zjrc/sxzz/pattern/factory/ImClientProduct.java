package com.zjrc.sxzz.pattern.factory;

public abstract class ImClientProduct {
	
	/**
	 * Im 暴露域名 ，如钉钉是https://oapi.dingtalk.com
	 */
	protected String urlPrefix ; 
	
	public ImClientProduct(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}
	
	/**创建医院或科室
	 * @param token
	 * @param jsonStr
	 * @return
	 */
	public abstract String createDept(String token , String jsonStr);
	
	/**更新医院或科室
	 * @param token
	 * @param jsonStr
	 * @return
	 */
	public abstract String updateDept(String token , String jsonStr);
	
	
	/**删除医院或科室
	 * @param token
	 * @return
	 */
	public abstract String deleteDept(String token , String id);
	
	
	/**创建医生
	 * @param token
	 * @param jsonStr
	 * @return
	 */
	public abstract String createDoctor(String token , String jsonStr);
	
	
	/**更新医生信息
	 * @param token
	 * @param jsonStr
	 * @return
	 */
	public abstract String updateDoctor(String token , String jsonStr);
	
	
	/**批量删除医生
	 * @param token
	 * @param jsonStr
	 * @return
	 */
	public abstract String deleteDoctors(String token , String jsonStr);
	
	/**删除医生
	 * @param token
	 * @return
	 */
	public abstract String deleteDoctor(String token , String id);

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}
	
	
}
