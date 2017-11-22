package com.firstCapacity.business.user.mapper;

import java.util.List;

import com.firstCapacity.business.user.entity.User;



public interface userDao {

	
	public User selectOne(Integer id);
	
	
	//模糊搜索
	public List<User> SelectMohu(User user);
	
	//根据名称查询
	public User getByUsername(String userName);
		
	//注册用户
	public void insertUser(User user);
	
	//删除用户
	public void deleteUser(String id);
	
	
	//查询一个
	public User selectOnemy(String id);
	
}
