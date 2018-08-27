package com.zjrc.sxzz.synTask;

/**同步状态
 * @author Administrator
 *
 */
public enum SynStatus {
	WAIT("0"),SUCCESS("1") , FAIL_ONE("2-1") , FAIL_TWO("2-2") , FAIL_THREE("2-3");
	private String status;
	private SynStatus (String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}

