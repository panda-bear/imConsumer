package com.zjrc.sxzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zjrc.sxzz.entity.Doctor;

public interface DoctorMapper {
    int deleteByPrimaryKey(String doctorId);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(String doctorId);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);
    
}