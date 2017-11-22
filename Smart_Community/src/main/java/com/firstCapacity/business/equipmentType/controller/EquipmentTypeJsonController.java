package com.firstCapacity.business.equipmentType.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstCapacity.business.equipmentType.entity.EquipmentType;
import com.firstCapacity.business.equipmentType.service.EquipmentTypeService;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/equipmentTypeJson")
public class EquipmentTypeJsonController extends ApiController{

	 private final static Logger logger = LoggerFactory.getLogger(EquipmentTypeJsonController.class); 
	
	 @Resource
	 private EquipmentTypeService equipmentTypeService;
	 
	 
	 /**
	  *  查询所有设备类型
	  * @param powerProject
	  */
	 @RequestMapping(value="/selectAll", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectAll() {
		 
		 try {
			List<EquipmentType> selectAll = equipmentTypeService.selectAll();
			 this.printSuccess(selectAll, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 /**
	  *  新增设备类型
	  * @param equipmentType
	  */
	 @RequestMapping(value="/insert", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void insert(EquipmentType equipmentType) {
		 
		 try {
			List<EquipmentType> chickName = equipmentTypeService.chickName(equipmentType.getEquipmentTypeName());
			if(chickName.size() > 0) {
				this.printFailure(1, "设备名类型称已存在,请检查!!!");
			}else {
				equipmentTypeService.insert(equipmentType);
				this.printSuccess();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍后再试!!!");
		}
	 }
	 
	 
	 /**
	  * 修改项目类型
	  * @param equipmentType
	  */
	 @RequestMapping(value="/update", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void update(EquipmentType equipmentType) {
		 
		 try {
			equipmentTypeService.update(equipmentType);
			 this.printSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 /**
	  *  删除项目类型
	  * @param equipmentTypeId
	  */
	 @RequestMapping(value="/delete", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void delete(String equipmentTypeId) {
		 
		 try {
			equipmentTypeService.delete(equipmentTypeId);
			 this.printSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "删除项目类型,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
	 
}
