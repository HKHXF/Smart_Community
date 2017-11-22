package com.firstCapacity.business.TypesettingRecord.service;

import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.firstCapacity.business.TypesettingRecord.entity.TypesettingRecord;
import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.business.powerProject.entity.usepublic;

public interface TypesettingRecordService {

	//模糊查询列表
	public List<TypesettingRecord> selectList(TypesettingRecord typesettingRecord);
	
	//新增排班记录
	public void insert(TypesettingRecord typesettingRecord);
	
    //新增时检查名称是否存在
    public List<TypesettingRecord> chickNme(String fileName);
    
    //根据ID查询详情
    public TypesettingRecord selectOne(String typesettingId);
    
    //根据ID删除盘版信息
    public void delete(String typesettingId);
}
