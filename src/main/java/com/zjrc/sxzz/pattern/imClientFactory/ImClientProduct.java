package com.zjrc.sxzz.pattern.imClientFactory;

public abstract class ImClientProduct {
	
	/**
	 * Im 暴露域名 ，如钉钉是https://oapi.dingtalk.com
	 */
	protected String urlPrefix ; 
	
	public ImClientProduct(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}
	
	/**免登授权 
	 * @param code
	 * @return 用户id
	 */
	public abstract String getUserIdByCode(String code);
	
	/**创建医院或科室
	 * @param token
	 * @param jsonStr
	 * @return
	 */
	public abstract String createDept(String jsonStr);
	
	/**获取部门详情
	 * @param deptIdDing
	 * @return
	 */
	public abstract String selectDeptById(String deptIdDing);
	
	/**更新医院或科室
	 * @param token
	 * @param jsonStr
	 * @return
	 */
	public abstract String updateDept(String jsonStr);
	
	
	/**删除医院或科室
	 * @param token
	 * @return
	 */
	public abstract String deleteDept(String id);
	
	
	/**创建医生
	 * @param token
	 * @param jsonStr
	 * @return
	 */
	public abstract String createAccount( String jsonStr);
	
	
	/**获取成员详情
	 * @param AccountId
	 * @return
	 */
	public abstract String selectAccountById(String accountId);
	
	/**更新医生信息
	 * @param token
	 * @param jsonStr
	 * @return
	 */
	public abstract String updateAccount(String jsonStr);
	
	
	/**批量删除医生
	 * @param token
	 * @param jsonStr
	 * @return
	 */
	public abstract String deleteAccounts( String jsonStr);
	
	/**删除医生
	 * @param token
	 * @return
	 */
	public abstract String deleteAccount( String id);

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}
	
	
}
