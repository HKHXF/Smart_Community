package com.firstCapacity.business.user.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.user.entity.User;
import com.firstCapacity.business.user.mapper.userMapper;
import com.firstCapacity.business.user.mapper.userRoleMapper;
import com.firstCapacity.util.MD5Util;


@Transactional
@Service
public class userServiceImpl implements userService{
	
	@Autowired
	private userMapper userMapper;
	
	@Autowired
	private userRoleMapper userRoleMapper;

	@Override
	/**
	 * 按照名称查询
	 */
	public User getByUsername(String userName) {
//		DataSourceContextHolder.setDbType("ds1");
		User byUsername = userMapper.getByUsername(userName);
		return byUsername;
	}

	
	/**
	 * 添加注册用户
	 */
	@Override
	public int insert(User record) {
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String password = record.getPassword();
		String md5 = MD5Util.md5(password, "hexiangfeng");
		record.setPassword(md5);
		record.setUserId(uuid);
		record.setUserType(0);
		int insert = userMapper.insert(record);
		
		return insert;
	}


	/**
	 *  列表模糊搜索
	 */
	@Override
	public List<User> SelectMohu(User user) {
		
		List<User> selectMohu = userMapper.SelectMohu(user);
		
		return selectMohu;
	}


	/**
	 *  删除用户
	 */
	@Override
	public void deleteUser(List<String> userId) {
		
		for (String string : userId) {
			userMapper.deleteByPrimaryKey(string);
			userRoleMapper.deleteUserRoles(string);
		}
	
		
	}


	/**
	 * 用户详情
	 */
	@Override
	public User selectByPrimaryKey(String userId) {
		User selectByPrimaryKey = userMapper.selectByPrimaryKey(userId);
		return selectByPrimaryKey;
	}


	
	/**
	 * 修改用户
	 */
	@Override
	public void updateByPrimaryKeySelective(User record) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String format = sf.format(date);
		record.setUpdateTime(format);

		userMapper.updateByPrimaryKeySelective(record);
	}
	
	
	



}
