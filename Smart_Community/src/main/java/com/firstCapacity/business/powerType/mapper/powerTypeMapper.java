package com.firstCapacity.business.powerType.mapper;

import java.util.List;

import com.firstCapacity.business.powerType.entity.powerType;

public interface powerTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project_type
     *
     * @mbg.generated Thu Oct 19 22:39:08 CST 2017
     */
    int deleteByPrimaryKey(String typeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project_type
     *
     * @mbg.generated Thu Oct 19 22:39:08 CST 2017
     */
    int insert(powerType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project_type
     *
     * @mbg.generated Thu Oct 19 22:39:08 CST 2017
     */
    int insertSelective(powerType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project_type
     *
     * @mbg.generated Thu Oct 19 22:39:08 CST 2017
     */
    powerType selectByPrimaryKey(String typeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project_type
     *
     * @mbg.generated Thu Oct 19 22:39:08 CST 2017
     */
    int updateByPrimaryKeySelective(powerType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project_type
     *
     * @mbg.generated Thu Oct 19 22:39:08 CST 2017
     */
    int updateByPrimaryKey(powerType record);
    
    
    //校验是否已存在
    public List<powerType> chickOne(String typeName);
    
    //查询列表
    public List<powerType> selectList();
    
    
 
    
}