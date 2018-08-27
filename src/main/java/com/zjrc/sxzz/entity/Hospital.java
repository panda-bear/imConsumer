package com.zjrc.sxzz.entity;

public class Hospital {
    private String hospitalId;

    private String parentHospitalId;

    private String name;

    private String abbreviation;

    private String aliases;

    private String description;

    private String areaId;

    private String address;

    private String zip;

    private String longitude;

    private String latitude;

    private String level;

    private String nature;

    private String category;

    private String picture;

    private String phone;

    private String fax;

    private String mobile;

    private String email;

    private String qq;

    private String wx;

    private String webUrl;

    private String remark;

    private String openState;

    private String openDate;

    private String clinicState;

    private String inspectionState;

    private String hospitalizeState;

    private String emergencyState;

    private String operationState;

    private String operationPlatformId;

    private String operationHospitalId;

    private String operationContactName;

    private String operationContactMobile;

    private String operationContactPhone;

    private String patientInfoState;

    private String hospitalizeInRecordState;

    private String hospitalizeOutRecordState;

    private String inspectionExamReportState;

    private String inspectionLisReportState;

    private Integer sortIndex;

    private String createTime;

    private String createUserId;

    private String modifyTime;

    private String modifyUserId;

    private String status;

    private String clinicThirdPartState;

    private String inspectionThirdPartState;

    private String hospitalizeThirdPartState;

    private String emergencyThirdPartState;

    private String operationThirdPartState;

    private String emergencyPlatformId;

    private String emergencyHospitalId;

    private String emergencyContactName;

    private String emergencyContactMobile;

    private String emergencyContactPhone;

    private String hospitalizePlatformId;

    private String hospitalizeHospitalId;

    private String hospitalizeContactType;

    private String hospitalizeContactName;

    private String hospitalizeContactMobile;

    private String hospitalizeContactPhone;

    private String inspectionPlatformId;

    private String inspectionHospitalId;

    private String inspectionContactName;

    private String inspectionContactMobile;

    private String inspectionContactPhone;

    private String clinicPlatformId;

    private String clinicInnerHispitalId;

    private String clinicContactName;

    private String clinicContactMobile;

    private String clinicContactPhone;

    private String isSynCreated;

    private String isSynUpdated;

    private String isSynDeleated;
    
    private String hospitalIdDing;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId == null ? null : hospitalId.trim();
    }

    public String getParentHospitalId() {
        return parentHospitalId;
    }

    public void setParentHospitalId(String parentHospitalId) {
        this.parentHospitalId = parentHospitalId == null ? null : parentHospitalId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation == null ? null : abbreviation.trim();
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases == null ? null : aliases.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature == null ? null : nature.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx == null ? null : wx.trim();
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl == null ? null : webUrl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOpenState() {
        return openState;
    }

    public void setOpenState(String openState) {
        this.openState = openState == null ? null : openState.trim();
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate == null ? null : openDate.trim();
    }

    public String getClinicState() {
        return clinicState;
    }

    public void setClinicState(String clinicState) {
        this.clinicState = clinicState == null ? null : clinicState.trim();
    }

    public String getInspectionState() {
        return inspectionState;
    }

    public void setInspectionState(String inspectionState) {
        this.inspectionState = inspectionState == null ? null : inspectionState.trim();
    }

    public String getHospitalizeState() {
        return hospitalizeState;
    }

    public void setHospitalizeState(String hospitalizeState) {
        this.hospitalizeState = hospitalizeState == null ? null : hospitalizeState.trim();
    }

    public String getEmergencyState() {
        return emergencyState;
    }

    public void setEmergencyState(String emergencyState) {
        this.emergencyState = emergencyState == null ? null : emergencyState.trim();
    }

    public String getOperationState() {
        return operationState;
    }

    public void setOperationState(String operationState) {
        this.operationState = operationState == null ? null : operationState.trim();
    }

    public String getOperationPlatformId() {
        return operationPlatformId;
    }

    public void setOperationPlatformId(String operationPlatformId) {
        this.operationPlatformId = operationPlatformId == null ? null : operationPlatformId.trim();
    }

    public String getOperationHospitalId() {
        return operationHospitalId;
    }

    public void setOperationHospitalId(String operationHospitalId) {
        this.operationHospitalId = operationHospitalId == null ? null : operationHospitalId.trim();
    }

    public String getOperationContactName() {
        return operationContactName;
    }

    public void setOperationContactName(String operationContactName) {
        this.operationContactName = operationContactName == null ? null : operationContactName.trim();
    }

    public String getOperationContactMobile() {
        return operationContactMobile;
    }

    public void setOperationContactMobile(String operationContactMobile) {
        this.operationContactMobile = operationContactMobile == null ? null : operationContactMobile.trim();
    }

    public String getOperationContactPhone() {
        return operationContactPhone;
    }

    public void setOperationContactPhone(String operationContactPhone) {
        this.operationContactPhone = operationContactPhone == null ? null : operationContactPhone.trim();
    }

    public String getPatientInfoState() {
        return patientInfoState;
    }

    public void setPatientInfoState(String patientInfoState) {
        this.patientInfoState = patientInfoState == null ? null : patientInfoState.trim();
    }

    public String getHospitalizeInRecordState() {
        return hospitalizeInRecordState;
    }

    public void setHospitalizeInRecordState(String hospitalizeInRecordState) {
        this.hospitalizeInRecordState = hospitalizeInRecordState == null ? null : hospitalizeInRecordState.trim();
    }

    public String getHospitalizeOutRecordState() {
        return hospitalizeOutRecordState;
    }

    public void setHospitalizeOutRecordState(String hospitalizeOutRecordState) {
        this.hospitalizeOutRecordState = hospitalizeOutRecordState == null ? null : hospitalizeOutRecordState.trim();
    }

    public String getInspectionExamReportState() {
        return inspectionExamReportState;
    }

    public void setInspectionExamReportState(String inspectionExamReportState) {
        this.inspectionExamReportState = inspectionExamReportState == null ? null : inspectionExamReportState.trim();
    }

    public String getInspectionLisReportState() {
        return inspectionLisReportState;
    }

    public void setInspectionLisReportState(String inspectionLisReportState) {
        this.inspectionLisReportState = inspectionLisReportState == null ? null : inspectionLisReportState.trim();
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

    public String getClinicThirdPartState() {
        return clinicThirdPartState;
    }

    public void setClinicThirdPartState(String clinicThirdPartState) {
        this.clinicThirdPartState = clinicThirdPartState == null ? null : clinicThirdPartState.trim();
    }

    public String getInspectionThirdPartState() {
        return inspectionThirdPartState;
    }

    public void setInspectionThirdPartState(String inspectionThirdPartState) {
        this.inspectionThirdPartState = inspectionThirdPartState == null ? null : inspectionThirdPartState.trim();
    }

    public String getHospitalizeThirdPartState() {
        return hospitalizeThirdPartState;
    }

    public void setHospitalizeThirdPartState(String hospitalizeThirdPartState) {
        this.hospitalizeThirdPartState = hospitalizeThirdPartState == null ? null : hospitalizeThirdPartState.trim();
    }

    public String getEmergencyThirdPartState() {
        return emergencyThirdPartState;
    }

    public void setEmergencyThirdPartState(String emergencyThirdPartState) {
        this.emergencyThirdPartState = emergencyThirdPartState == null ? null : emergencyThirdPartState.trim();
    }

    public String getOperationThirdPartState() {
        return operationThirdPartState;
    }

    public void setOperationThirdPartState(String operationThirdPartState) {
        this.operationThirdPartState = operationThirdPartState == null ? null : operationThirdPartState.trim();
    }

    public String getEmergencyPlatformId() {
        return emergencyPlatformId;
    }

    public void setEmergencyPlatformId(String emergencyPlatformId) {
        this.emergencyPlatformId = emergencyPlatformId == null ? null : emergencyPlatformId.trim();
    }

    public String getEmergencyHospitalId() {
        return emergencyHospitalId;
    }

    public void setEmergencyHospitalId(String emergencyHospitalId) {
        this.emergencyHospitalId = emergencyHospitalId == null ? null : emergencyHospitalId.trim();
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName == null ? null : emergencyContactName.trim();
    }

    public String getEmergencyContactMobile() {
        return emergencyContactMobile;
    }

    public void setEmergencyContactMobile(String emergencyContactMobile) {
        this.emergencyContactMobile = emergencyContactMobile == null ? null : emergencyContactMobile.trim();
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone == null ? null : emergencyContactPhone.trim();
    }

    public String getHospitalizePlatformId() {
        return hospitalizePlatformId;
    }

    public void setHospitalizePlatformId(String hospitalizePlatformId) {
        this.hospitalizePlatformId = hospitalizePlatformId == null ? null : hospitalizePlatformId.trim();
    }

    public String getHospitalizeHospitalId() {
        return hospitalizeHospitalId;
    }

    public void setHospitalizeHospitalId(String hospitalizeHospitalId) {
        this.hospitalizeHospitalId = hospitalizeHospitalId == null ? null : hospitalizeHospitalId.trim();
    }

    public String getHospitalizeContactType() {
        return hospitalizeContactType;
    }

    public void setHospitalizeContactType(String hospitalizeContactType) {
        this.hospitalizeContactType = hospitalizeContactType == null ? null : hospitalizeContactType.trim();
    }

    public String getHospitalizeContactName() {
        return hospitalizeContactName;
    }

    public void setHospitalizeContactName(String hospitalizeContactName) {
        this.hospitalizeContactName = hospitalizeContactName == null ? null : hospitalizeContactName.trim();
    }

    public String getHospitalizeContactMobile() {
        return hospitalizeContactMobile;
    }

    public void setHospitalizeContactMobile(String hospitalizeContactMobile) {
        this.hospitalizeContactMobile = hospitalizeContactMobile == null ? null : hospitalizeContactMobile.trim();
    }

    public String getHospitalizeContactPhone() {
        return hospitalizeContactPhone;
    }

    public void setHospitalizeContactPhone(String hospitalizeContactPhone) {
        this.hospitalizeContactPhone = hospitalizeContactPhone == null ? null : hospitalizeContactPhone.trim();
    }

    public String getInspectionPlatformId() {
        return inspectionPlatformId;
    }

    public void setInspectionPlatformId(String inspectionPlatformId) {
        this.inspectionPlatformId = inspectionPlatformId == null ? null : inspectionPlatformId.trim();
    }

    public String getInspectionHospitalId() {
        return inspectionHospitalId;
    }

    public void setInspectionHospitalId(String inspectionHospitalId) {
        this.inspectionHospitalId = inspectionHospitalId == null ? null : inspectionHospitalId.trim();
    }

    public String getInspectionContactName() {
        return inspectionContactName;
    }

    public void setInspectionContactName(String inspectionContactName) {
        this.inspectionContactName = inspectionContactName == null ? null : inspectionContactName.trim();
    }

    public String getInspectionContactMobile() {
        return inspectionContactMobile;
    }

    public void setInspectionContactMobile(String inspectionContactMobile) {
        this.inspectionContactMobile = inspectionContactMobile == null ? null : inspectionContactMobile.trim();
    }

    public String getInspectionContactPhone() {
        return inspectionContactPhone;
    }

    public void setInspectionContactPhone(String inspectionContactPhone) {
        this.inspectionContactPhone = inspectionContactPhone == null ? null : inspectionContactPhone.trim();
    }

    public String getClinicPlatformId() {
        return clinicPlatformId;
    }

    public void setClinicPlatformId(String clinicPlatformId) {
        this.clinicPlatformId = clinicPlatformId == null ? null : clinicPlatformId.trim();
    }

    public String getClinicInnerHispitalId() {
        return clinicInnerHispitalId;
    }

    public void setClinicInnerHispitalId(String clinicInnerHispitalId) {
        this.clinicInnerHispitalId = clinicInnerHispitalId == null ? null : clinicInnerHispitalId.trim();
    }

    public String getClinicContactName() {
        return clinicContactName;
    }

    public void setClinicContactName(String clinicContactName) {
        this.clinicContactName = clinicContactName == null ? null : clinicContactName.trim();
    }

    public String getClinicContactMobile() {
        return clinicContactMobile;
    }

    public void setClinicContactMobile(String clinicContactMobile) {
        this.clinicContactMobile = clinicContactMobile == null ? null : clinicContactMobile.trim();
    }

    public String getClinicContactPhone() {
        return clinicContactPhone;
    }

    public void setClinicContactPhone(String clinicContactPhone) {
        this.clinicContactPhone = clinicContactPhone == null ? null : clinicContactPhone.trim();
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

	public String getHospitalIdDing() {
		return hospitalIdDing;
	}

	public void setHospitalIdDing(String hospitalIdDing) {
		this.hospitalIdDing = hospitalIdDing;
	}
    
}