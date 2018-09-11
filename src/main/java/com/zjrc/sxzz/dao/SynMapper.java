package com.zjrc.sxzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zjrc.sxzz.entity.Syn;

public interface SynMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Syn record);

    int insertSelective(Syn record);

    Syn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Syn record);

    int updateByPrimaryKey(Syn record);
    
    /**查出指定量的待同步数据
     * @param delNums
     * @return
     */
    List<Syn> getWaitBusinessDatas(@Param("startIndex")int startIndex , @Param("delNums")int delNums);
}