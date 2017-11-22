package com.firstCapacity.business.user.mapper;

import java.util.List;

import com.firstCapacity.business.user.entity.Roles;


public interface RolesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Thu Sep 14 09:23:31 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Thu Sep 14 09:23:31 CST 2017
     */
    int insert(Roles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Thu Sep 14 09:23:31 CST 2017
     */
    int insertSelective(Roles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Thu Sep 14 09:23:31 CST 2017
     */
    Roles selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Thu Sep 14 09:23:31 CST 2017
     */
    int updateByPrimaryKeySelective(Roles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Thu Sep 14 09:23:31 CST 2017
     */
    int updateByPrimaryKey(Roles record);
    
    
    //根据用户ID查询用户的所有权限
    public List<Roles> selectRoleByUserId(String userId);
}