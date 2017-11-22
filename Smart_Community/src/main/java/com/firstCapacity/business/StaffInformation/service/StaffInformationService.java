package com.firstCapacity.business.StaffInformation.service;

import java.util.List;

import com.firstCapacity.business.StaffInformation.entity.StaffInformation;

public interface StaffInformationService {

	//新增职员信息
	public void insert(StaffInformation staffInformation);
	
	//修改职员信息
	public void update(StaffInformation staffInformation);
	
	//修改职员信息
	public void delete(String staffId);
	
	//查询职员信息列表
	public List<StaffInformation> selectList(StaffInformation staffInformation);
	
    //校验是否名称存在    
    public List<StaffInformation> chickName(String staffName);
    
    //查询详情
    public StaffInformation selectOne(String staffId);
	
	
}
