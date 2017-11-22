package com.firstCapacity.business.powerProject.service;

import java.util.List;


public interface HFHySQLService {

	
	public List<Object> SelectListOn(String table,String startTime,String endTime);
	
}
