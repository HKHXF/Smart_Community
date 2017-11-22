package com.firstCapacity.business.powerLink.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.HeFeiPower.entity.HF_hy_01;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_02;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_01Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_02Mapper;
import com.firstCapacity.business.powerLink.entity.PowerLink;
import com.firstCapacity.business.powerLink.entity.suoyouAll;
import com.firstCapacity.business.powerLink.mapper.PowerLinkMapper;

//@Transactional
@Service
public class PowerLinkServiceImpl implements PowerLinkService{

	private final static Logger logger = LoggerFactory.getLogger(PowerLinkServiceImpl.class); 
	
	@Resource
	private PowerLinkMapper powerLinkMapper;
	
	@Resource
	private HF_hy_01Mapper HF_hy_01Mapper;
	@Resource
	private HF_hy_02Mapper HF_hy_02Mapper;
	
	
	

	
	/**
	 * 根据项目id查询连接+模糊性查询
	 */
	@Override
	public List<Object> selectLinkByProjectId(String path,PowerLink powerLink) {
		List<Object> list = new ArrayList<Object>();
		
		List<PowerLink> selectLinkByProjectId = powerLinkMapper.selectLinkByProjectId(powerLink);
		for (PowerLink powerLink2 : selectLinkByProjectId) {
			
			String tableName = powerLink2.getTableName();
			File f = new File(path);
	        if (!f.exists()) {
	            System.out.println(path + " not exists");
//	            return;
	        }

	        File fa[] = f.listFiles();
	        for (int i = 0; i < fa.length; i++) {
	            File fs = fa[i];
	            if (fs.isDirectory()) {
//	                System.out.println(fs.getName() + " [目录]");
	                logger.debug(fs.getName() + " [目录]");
	            } else {
//	                System.out.println(fs.getName());
	                
	                String mapper = StringUtils.substringBefore(fs.getName(), "Mapper");
	                if(tableName.equals(mapper) && tableName.equals("HF_hy_01")) {
	                	HF_hy_01 selectOne = HF_hy_01Mapper.SelectOne();
	                	list.add(selectOne);
	                }
	                if(tableName.equals(mapper) && tableName.equals("HF_hy_02")) {
	                	HF_hy_02 selectOne = HF_hy_02Mapper.SelectOne();
	                	list.add(selectOne);
	                }
	                
	                
	            }
	        }
			
		}
		return list;
		
	}


	@Override
	public HF_hy_01 test() {
		HF_hy_01 test = HF_hy_01Mapper.SelectOne();
		return test;
	}
	
	
	

	 
	 
	 
	
		 
		 
	
}
