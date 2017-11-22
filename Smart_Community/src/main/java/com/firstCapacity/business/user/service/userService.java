package com.firstCapacity.business.user.service;


import java.util.List;

import com.firstCapacity.business.user.entity.User;


public interface userService {

	//按照名称查询
	public User getByUsername(String userName);
	
	
	//添加注册用户
	public int insert(User record);
	
	//用户列表
	public List<User> SelectMohu(User user);
	
	//删除用户
	public void deleteUser(List<String> userId);
	
	
	//用户详情
	public User selectByPrimaryKey(String userId);
	
	//修改用户
	public void updateByPrimaryKeySelective(User record);
	
	
}
