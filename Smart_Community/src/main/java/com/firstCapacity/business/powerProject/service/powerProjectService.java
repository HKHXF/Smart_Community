package com.firstCapacity.business.powerProject.service;

import java.util.List;

import com.firstCapacity.business.HeFeiPower.entity.HF_hy_31;
import com.firstCapacity.business.powerProject.entity.HFHySQL;
import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.business.powerProject.entity.usepublic;

public interface powerProjectService {

	//新增项目
	public void imsert(powerProject powerProject);
	
	//新增校验是否存在
	public List<powerProject> chickOne(String projectName);
	
	//修改项目
	public void update(powerProject powerProject);
	
	//删除项目
	public void delete(String projectId);
	
	//项目详情
	public powerProject selectOne(String projectId);
	
	//查询组织结构树
	public usepublic queryListAll();

	
	//查询所有区域和类别
	public usepublic selectQuyu();
	
	//查询所有区域
	public List<powerProject> qyuryQuyu();
	
	//模糊查询项目列表
    public List<powerProject> selectqueryList(powerProject recor);
    

    //查询区域和项目
    public usepublic selectQuyuAndProbject();
    
    
    //按照区域ID查询项目列表
    public List<powerProject> selectProbjectByQuyu(String projectId);
    
    //按照项目ID查询区域
    public powerProject selectQuyuByProject(String projectId);

    //查询区域和项目
    public usepublic quyuProbject();
    
    //系统运行
    public powerProject xitong(String projectId);
    
    //系统运行（大接口全部）
    public Object xitongyinxingAll(String path,String tableName,String projectId);
    
    //查询一个时间段内的数据
    public List<Object> selectListTime();
    
    //查询3天设备调节记录
    public List<HF_hy_31> selectListShebeiDate();
    
	//各个项目的运行参数
    public Object yunxingCanshu(String projectId);
    
    
    //初始化表名称
    public List<HFHySQL> inintTableName();
    
    //根据表名称查询字段名
    public List<HFHySQL> selectByTableName(String table);
    
    
}
