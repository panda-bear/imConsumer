package com.zjrc.sxzz.dao;

import com.zjrc.sxzz.entity.Hospital;

public interface HospitalMapper {
    int deleteByPrimaryKey(String hospitalId);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    Hospital selectByPrimaryKey(String hospitalId);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);
}