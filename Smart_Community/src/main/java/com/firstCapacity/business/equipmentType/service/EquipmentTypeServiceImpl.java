package com.firstCapacity.business.equipmentType.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.equipmentIedger.mapper.EquipmentIedgerMapper;
import com.firstCapacity.business.equipmentType.entity.EquipmentType;
import com.firstCapacity.business.equipmentType.mapper.EquipmentTypeMapper;
import com.firstCapacity.business.powerProject.controller.powerProjectJsonController;

@Transactional
@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService{
	
	
	private final static Logger logger = LoggerFactory.getLogger(powerProjectJsonController.class); 

	@Resource
	private EquipmentTypeMapper equipmentTypeMapper;
	@Resource
	private EquipmentIedgerMapper equipmentIedgerMapper;
	
	
	/**
	 * 查询所有设备类型
	 */
	@Override
	public List<EquipmentType> selectAll() {

		List<EquipmentType> selectAll = equipmentTypeMapper.selectAll();
		return selectAll;
	}



	/**
	 *  新增设备类型
	 */
	@Override
	public void insert(EquipmentType equipmentType) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		equipmentType.setEquipmentTypeId(uuid);
		equipmentTypeMapper.insertSelective(equipmentType);
		
	}



	/**
	 * 修改设备类型
	 */
	@Override
	public void update(EquipmentType equipmentType) {

		equipmentTypeMapper.updateByPrimaryKeySelective(equipmentType);
		
	}



	/**
	 * 删除设备类型
	 */
	@Override
	public void delete(String equipmentTypeId) {
		equipmentIedgerMapper.deleteFoType(equipmentTypeId);
		equipmentTypeMapper.deleteByPrimaryKey(equipmentTypeId);
		
	}



	/**
	 * 校验名称是否已存在
	 */
	@Override
	public List<EquipmentType> chickName(String equipmentTypeName) {

		List<EquipmentType> chickName = equipmentTypeMapper.chickName(equipmentTypeName);
		return chickName;
	}
	
	
	
	
	
}
