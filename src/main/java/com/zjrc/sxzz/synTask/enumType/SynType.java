package com.zjrc.sxzz.synTask.enumType;

/**同步类型（1-创建， 2,-更新 ， 3-删除）
 * @author Administrator
 *
 */
public enum SynType {
	CREATE("1") , UPDATE("2") , DELETE("3");
	
	private String synType;
	private SynType(String synType) {
		this.synType = synType;
	}
	
	public String getType() {
		return this.synType;
	}
}
