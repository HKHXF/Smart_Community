package com.firstCapacity.business.equipmentType.controller;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstCapacity.business.powerProject.service.powerProjectExcelService;
import com.firstCapacity.business.powerProject.service.powerProjectService;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/equipmentType")
public class EquipmentTypeController extends ApiController{

	
	@Resource
	private powerProjectService powerProjectService;
	
	@Resource
	private powerProjectExcelService powerProjectExcelService;

	 
	
	
}
