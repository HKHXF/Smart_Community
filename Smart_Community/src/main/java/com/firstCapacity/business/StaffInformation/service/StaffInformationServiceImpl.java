package com.firstCapacity.business.StaffInformation.service;


import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.StaffInformation.entity.StaffInformation;
import com.firstCapacity.business.StaffInformation.mapper.StaffInformationMapper;

@Transactional
@Service
public class StaffInformationServiceImpl implements StaffInformationService{
	
	
	private final static Logger logger = LoggerFactory.getLogger(StaffInformationServiceImpl.class);

	@Resource
	private StaffInformationMapper staffInformationMapper;
	
	
	/**
	 * 新增职员
	 */
	@Override
	public void insert(StaffInformation staffInformation) {

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		staffInformation.setStaffId(uuid);
		staffInformationMapper.insertSelective(staffInformation);
	}

	
	/**
	 *  修改职员
	 */
	@Override
	public void update(StaffInformation staffInformation) {

		staffInformationMapper.updateByPrimaryKeySelective(staffInformation);
		
	}

	
	/**
	 * 删除职员
	 */
	@Override
	public void delete(String staffId) {

		staffInformationMapper.deleteByPrimaryKey(staffId);
		
	}

	
	/**
	 * 查询职员列表
	 */
	@Override
	public List<StaffInformation> selectList(StaffInformation staffInformation) {

		List<StaffInformation> queryList = staffInformationMapper.queryList(staffInformation);
		
		return queryList;
	}

	

	/**
	 * 检查名称是否存在
	 */
	@Override
	public List<StaffInformation> chickName(String staffName) {

		List<StaffInformation> chickName = staffInformationMapper.chickName(staffName);
		return chickName;
	}


	
	/**
	 * 查询一个详情
	 */
	@Override
	public StaffInformation selectOne(String staffId) {

		StaffInformation selectByPrimaryKey = staffInformationMapper.selectByPrimaryKey(staffId);
		return selectByPrimaryKey;
	} 

	
	
}
