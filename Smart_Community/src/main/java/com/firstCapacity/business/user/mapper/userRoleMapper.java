package com.firstCapacity.business.user.mapper;

import com.firstCapacity.business.user.entity.UserRole;

public interface userRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Tue Sep 26 11:28:20 CST 2017
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Tue Sep 26 11:28:20 CST 2017
     */
    int insertSelective(UserRole record);
    
    
    //删除用户所拥有的权限
    public void deleteUserRoles(String userId);
}