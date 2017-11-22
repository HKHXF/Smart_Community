package com.firstCapacity.business.powerLink.service;

import java.util.List;

import com.firstCapacity.business.HeFeiPower.entity.HF_hy_01;
import com.firstCapacity.business.powerLink.entity.PowerLink;

public interface PowerLinkService {
 
	
	//根据项目id查询连接+模糊性查询
	public List<Object> selectLinkByProjectId(String path,PowerLink powerLink);
	
	
	public HF_hy_01 test();
    
}
