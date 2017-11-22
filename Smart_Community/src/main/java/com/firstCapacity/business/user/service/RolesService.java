package com.firstCapacity.business.user.service;


import java.util.List;

import com.firstCapacity.business.user.entity.Role;



public interface RolesService {

	 //根据用户ID查询用户的所有权限
    public List<Role> selectRoleByUserId(String userId);
    
    //删除用户所拥有的权限
    public void deleteUserRoles(String userId);
	
}
