package com.zjrc.sxzz.entity;

public class Syn {
    private Integer id;

    private String businessId;

    private String businessName;

    private String businessType;

    private String createDate;

    private String synType;

    private String synState;

    private String synResult;

    private Integer synNums;

    private String synResponse;

    private String synDesc;

    private String remarks;

    private String synDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getSynType() {
        return synType;
    }

    public void setSynType(String synType) {
        this.synType = synType == null ? null : synType.trim();
    }

    public String getSynState() {
        return synState;
    }

    public void setSynState(String synState) {
        this.synState = synState == null ? null : synState.trim();
    }

    public String getSynResult() {
        return synResult;
    }

    public void setSynResult(String synResult) {
        this.synResult = synResult == null ? null : synResult.trim();
    }

    public Integer getSynNums() {
        return synNums;
    }

    public void setSynNums(Integer synNums) {
        this.synNums = synNums;
    }

    public String getSynResponse() {
        return synResponse;
    }

    public void setSynResponse(String synResponse) {
        this.synResponse = synResponse == null ? null : synResponse.trim();
    }

    public String getSynDesc() {
        return synDesc;
    }

    public void setSynDesc(String synDesc) {
        this.synDesc = synDesc == null ? null : synDesc.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getSynDate() {
        return synDate;
    }

    public void setSynDate(String synDate) {
        this.synDate = synDate == null ? null : synDate.trim();
    }

	@Override
	public String toString() {
		return "Syn [id=" + id + ", businessId=" + businessId + ", businessName=" + businessName + ", businessType="
				+ businessType + ", createDate=" + createDate + ", synNums=" + synNums + "]";
	}
    
    
}