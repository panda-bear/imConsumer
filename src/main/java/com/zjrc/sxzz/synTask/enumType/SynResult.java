package com.zjrc.sxzz.synTask.enumType;

/**同步状态(0-同步成功 ， 1-同步失败)
 * @author Administrator
 *
 */
public enum SynResult {
	SUCCESS("0") , FAIL("1");
	
	private String result;
	
	private SynResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return this.result;
	}
}
