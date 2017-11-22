package com.firstCapacity.business.equipmentType.service;

import java.util.List;



import com.firstCapacity.business.equipmentType.entity.EquipmentType;

public interface EquipmentTypeService {

    //查询所有项目类型
    public List<EquipmentType> selectAll();
    
    //添加设备类型
    public void insert(EquipmentType equipmentType);
    
    //修改设备类型
    public void update(EquipmentType equipmentType);
    
    //删除设备类型
    public void delete(String equipmentTypeId);
    
    //校验名称是否存在
    public List<EquipmentType> chickName(String equipmentTypeName);
	
}
