package com.firstCapacity.business.powerType.service;


import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.powerProject.mapper.powerProjectMapper;
import com.firstCapacity.business.powerType.entity.powerType;
import com.firstCapacity.business.powerType.mapper.powerTypeMapper;


@Transactional
@Service
public class powerTypeServiceImpl implements powerTypeService{
	private final static Logger logger = LoggerFactory.getLogger(powerTypeServiceImpl.class); 
	
	@Resource
	private powerTypeMapper powerTypeMapper;
	
	@Resource
	private powerProjectMapper powerProjectMapper;

	
	/**
	 * 新增类别
	 */
	@Override
	public void insertSelective(powerType record) {
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		record.setTypeId(uuid);
		powerTypeMapper.insertSelective(record);
		
	}


	/**
	 * 校验是否已存在
	 */
	@Override
	public List<powerType> chickOne(String typeName) {
		List<powerType> chickOne = powerTypeMapper.chickOne(typeName);
		return chickOne;
	}


	/**
	 *  修改类别
	 */
	@Override
	public void updateByPrimaryKeySelective(powerType record) {

		powerTypeMapper.updateByPrimaryKeySelective(record);
		
	}


	/**
	 * 查询列表
	 */
	@Override
	public List<powerType> selectList() {
		List<powerType> selectList = powerTypeMapper.selectList();
//		logger.debug("查询失败");
		return selectList;
	}


	/**
	 * 删除
	 */
	@Override
	public void deleteByPrimaryKey(String typeId) {
		powerProjectMapper.deleteFoProjectType(typeId);
		powerTypeMapper.deleteByPrimaryKey(typeId);
	}
	
	

}
