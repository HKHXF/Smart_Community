package com.firstCapacity.business.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.user.entity.Role;
import com.firstCapacity.business.user.mapper.roleMapper;


@Transactional
@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	private roleMapper rolesMapper;

	@Override
	public List<Role> selectRoleByUserId(String userId) {
		
		List<Role> selectRoleByUserName = rolesMapper.selectRoleByUserId(userId);
		
		return selectRoleByUserName;
		
	}

	@Override
	public void deleteUserRoles(String userId) {
		// TODO Auto-generated method stub
		
	}
	
	
	





}
