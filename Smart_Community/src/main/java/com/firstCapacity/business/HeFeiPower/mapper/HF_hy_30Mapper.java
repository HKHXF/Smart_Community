package com.firstCapacity.business.HeFeiPower.mapper;

import java.util.List;

import com.firstCapacity.business.HeFeiPower.entity.HF_hy_30;
import com.firstCapacity.util.aop.DataSource;

public interface HF_hy_30Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HF_hy_30
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    int insert(HF_hy_30 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HF_hy_30
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    int insertSelective(HF_hy_30 record);
    
    //查询所有
    @DataSource("B")
    public HF_hy_30 selectOne();
    
    //查询3天系统总能耗记录
    @DataSource("B")
    public List<HF_hy_30> selectListZong(HF_hy_30 record);
}