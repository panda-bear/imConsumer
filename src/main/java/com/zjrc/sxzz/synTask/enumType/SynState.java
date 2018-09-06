package com.zjrc.sxzz.synTask.enumType;

/**同步状态  0-待同步  ， 1-已同步
 * @author Administrator
 *
 */
public enum SynState {
	WAIT("0"),HAS("1");
	
	private String state;
	private SynState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
}
