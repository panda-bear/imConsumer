package com.zjrc.sxzz.dao;


import java.util.List;

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
    
    /**根据用户id，获取其所属科室钉钉id集
     * @param accountId
     * @return
     */
    List<String> getDeptIdDingsByAccountId(@Param("accountId") int accountId);
    
}