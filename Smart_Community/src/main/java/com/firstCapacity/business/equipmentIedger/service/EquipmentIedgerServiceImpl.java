package com.firstCapacity.business.equipmentIedger.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.equipmentIedger.entity.EquipmentIedger;
import com.firstCapacity.business.equipmentIedger.mapper.EquipmentIedgerMapper;
import com.firstCapacity.business.powerProject.controller.powerProjectJsonController;

@Transactional
@Service
public class EquipmentIedgerServiceImpl implements EquipmentIedgerService{
	
	
	private final static Logger logger = LoggerFactory.getLogger(powerProjectJsonController.class); 

	@Resource
	private EquipmentIedgerMapper equipmentIedgerMapper;
	
	
	
	
	/**
	 *  新增设备信息
	 */
	@Override
	public void insert(EquipmentIedger equipmentIedger) {
		
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			equipmentIedger.setEquipmentIedgerId(uuid);
			equipmentIedgerMapper.insertSelective(equipmentIedger);
		
	}
	
	
	
	/**
	 *  修改设备信息
	 */
	@Override
	public void update(EquipmentIedger equipmentIedger) {
		
		try {
			equipmentIedgerMapper.updateByPrimaryKeySelective(equipmentIedger);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("设备修改失败");
		}
		
	}



	/**
	 * 删除设备信息
	 */
	@Override
	public void delete(String equipmentIedgerId) {

		try {
			equipmentIedgerMapper.deleteByPrimaryKey(equipmentIedgerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	/**
	 * 校验名称是否存在
	 */
	@Override
	public List<EquipmentIedger> chickName(String equipmentName) {
		List<EquipmentIedger> chickName = equipmentIedgerMapper.chickName(equipmentName);
		return chickName;
	}



	/**
	 *  查询列表(模糊查询)
	 */
	@Override
	public List<EquipmentIedger> selectLsit(EquipmentIedger equipmentIedger) {

		List<EquipmentIedger> selectList = equipmentIedgerMapper.selectList(equipmentIedger);
		
		return selectList;
	}



	/**
	 * 查询设备详情
	 */
	@Override
	public EquipmentIedger selectOne(String equipmentIedgerId) {
		EquipmentIedger selectByPrimaryKey = equipmentIedgerMapper.selectOne(equipmentIedgerId);
		return selectByPrimaryKey;
	}



	
	
	
	
	
}
