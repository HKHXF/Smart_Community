package com.firstCapacity.business.powerNengHao.mapper;

import com.firstCapacity.business.powerNengHao.entity.powerHistory;

public interface powerHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_history
     *
     * @mbg.generated Wed Nov 15 14:49:44 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_history
     *
     * @mbg.generated Wed Nov 15 14:49:44 CST 2017
     */
    int insert(powerHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_history
     *
     * @mbg.generated Wed Nov 15 14:49:44 CST 2017
     */
    int insertSelective(powerHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_history
     *
     * @mbg.generated Wed Nov 15 14:49:44 CST 2017
     */
    powerHistory selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_history
     *
     * @mbg.generated Wed Nov 15 14:49:44 CST 2017
     */
    int updateByPrimaryKeySelective(powerHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_history
     *
     * @mbg.generated Wed Nov 15 14:49:44 CST 2017
     */
    int updateByPrimaryKey(powerHistory record);
}