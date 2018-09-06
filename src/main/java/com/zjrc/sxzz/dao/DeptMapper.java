package com.zjrc.sxzz.dao;

import org.apache.ibatis.annotations.Param;

import com.zjrc.sxzz.entity.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(String deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    
    /**获取指定医院是否已创建特殊一级科室
     * @param deptName
     * @param hospitalId
     * @return
     */
    Dept getAbnormalOneDept(@Param("deptName")String deptName , @Param("hospitalId")String hospitalId);
}