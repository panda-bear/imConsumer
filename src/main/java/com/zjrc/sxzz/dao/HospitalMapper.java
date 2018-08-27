package com.zjrc.sxzz.dao;

import java.util.List;

import com.zjrc.sxzz.entity.Hospital;

public interface HospitalMapper {
    int deleteByPrimaryKey(String hospitalId);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    Hospital selectByPrimaryKey(String hospitalId);

    int updateByPrimaryKeySelective(Hospital record);
    
    /**获取待同步医院集
     * @return
     */
    List<Hospital> getWaitSynHospitals();
}