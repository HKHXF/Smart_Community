package com.firstCapacity.business.powerType.service;

import java.util.List;

import com.firstCapacity.business.powerType.entity.powerType;




public interface powerTypeService {

	//新增类别
	public void insertSelective(powerType record);
	
	
    //校验是否已存在
    public List<powerType> chickOne(String typeName);
    
    
    //修改类别
    public void updateByPrimaryKeySelective(powerType record);
    
    //查询列表
    public List<powerType> selectList();
    
    //删除
    public void deleteByPrimaryKey(String typeId);
	
}
