package com.firstCapacity.business.equipmentIedger.service;

import java.util.List;

import com.firstCapacity.business.equipmentIedger.entity.EquipmentIedger;

public interface EquipmentIedgerService {

	
	//新增设备信息
    public void insert(EquipmentIedger equipmentIedger);
	
    //修改设备信息
    public void update(EquipmentIedger equipmentIedger);
    
    //删除设备信息
    public void delete(String equipmentIedgerId);
    
    //校验名称是否存在
    public List<EquipmentIedger> chickName(String equipmentName);
    
    //查询列表(模糊查询)
    public List<EquipmentIedger> selectLsit(EquipmentIedger equipmentIedger);
    
    //设备详情
    public EquipmentIedger selectOne(String equipmentIedgerId);
    
}
