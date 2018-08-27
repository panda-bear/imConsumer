package com.zjrc.sxzz.entity;

public class Doctor {
    private String doctorId;

    private Integer accountId;

    private String hospitalId;

    private String loginName;

    private String code;

    private String name;

    private String password;

    private String roleType;

    private String mobile;

    private String phone;

    private String sex;

    private Integer technical;

    private Integer sortIndex;

    private String createTime;

    private String createUserId;

    private String modifyTime;

    private String modifyUserId;

    private String status;

    private String innerDoctId;

    private String description;

    private String goodat;

    private String isSynCreated;

    private String isSynUpdated;

    private String isSynDeleated;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId == null ? null : hospitalId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getTechnical() {
        return technical;
    }

    public void setTechnical(Integer technical) {
        this.technical = technical;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getInnerDoctId() {
        return innerDoctId;
    }

    public void setInnerDoctId(String innerDoctId) {
        this.innerDoctId = innerDoctId == null ? null : innerDoctId.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat == null ? null : goodat.trim();
    }

    public String getIsSynCreated() {
        return isSynCreated;
    }

    public void setIsSynCreated(String isSynCreated) {
        this.isSynCreated = isSynCreated == null ? null : isSynCreated.trim();
    }

    public String getIsSynUpdated() {
        return isSynUpdated;
    }

    public void setIsSynUpdated(String isSynUpdated) {
        this.isSynUpdated = isSynUpdated == null ? null : isSynUpdated.trim();
    }

    public String getIsSynDeleated() {
        return isSynDeleated;
    }

    public void setIsSynDeleated(String isSynDeleated) {
        this.isSynDeleated = isSynDeleated == null ? null : isSynDeleated.trim();
    }
}