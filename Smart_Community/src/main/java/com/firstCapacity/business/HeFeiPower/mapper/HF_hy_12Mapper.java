package com.firstCapacity.business.HeFeiPower.mapper;

import java.util.List;

import com.firstCapacity.business.HeFeiPower.entity.HF_hy_12;
import com.firstCapacity.util.aop.DataSource;

public interface HF_hy_12Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HF_hy_12
     *
     * @mbg.generated Wed Oct 11 14:19:20 CST 2017
     */
    int insert(HF_hy_12 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HF_hy_12
     *
     * @mbg.generated Wed Oct 11 14:19:20 CST 2017
     */
    int insertSelective(HF_hy_12 record);
    
    
    //运行参数按时间段查询
    @DataSource("B")
    public List<Object> SelectListOn(HF_hy_12 record);
}