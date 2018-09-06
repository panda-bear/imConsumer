package com.zjrc.sxzz.synTask.enumType;

/**业务类型(1-医院 ，2-科室 ， 3-医生)
 * @author Administrator
 *
 */
public enum BusinessType {
	HOSPITAL("1") , DEPT("2") , DOCTOR("3");
	
	private String businessType;
	private BusinessType(String businessType) {
		this.businessType = businessType;
	}
	
	public String getType() {
		return this.businessType;
	}
	
}
