package com.firstCapacity.business.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.user.entity.Role;
import com.firstCapacity.business.user.mapper.roleMapper;


@Transactional
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private roleMapper roleMapper;

	/**
	 * 查询用户所拥有的角色
	 */
	@Override
	public List<Role> selectRoleByUserId(String userId) {
		List<Role> selectRoleByUserId = roleMapper.selectRoleByUserId(userId);
		
		return selectRoleByUserId;
	}
	
	
	





}
