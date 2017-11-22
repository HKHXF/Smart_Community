package com.firstCapacity.business.powerType.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstCapacity.business.powerType.entity.powerType;
import com.firstCapacity.business.powerType.service.powerTypeService;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/powerTypeJson")
public class powerTypeJsonController extends ApiController{
	 private final static Logger logger = LoggerFactory.getLogger(powerTypeJsonController.class); 
	
	 
	 @Resource
	 private powerTypeService powerTypeService;
	 
	 
	 /**
	  * 新增类别
	  */
	 @RequestMapping(value="/insert", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void insert(powerType powerType) {
		 
		 try {
			List<powerType> chickOne = powerTypeService.chickOne(powerType.getTypeName());
			 if(chickOne.size() > 0) {
				 this.printFailure(1, "该类别已存在,请检查!!!");
				 logger.debug("类别名称已存在");
			 }else {
				 powerTypeService.insertSelective(powerType);
				 this.printSuccess(null, "成功");
			 }
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1,"系统异常，请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
	 
	 /**
	  * 修改类别
	  */
	 @RequestMapping(value="/update", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void update(powerType powerType) {
		 
		 try {
			 powerTypeService.updateByPrimaryKeySelective(powerType);
			 this.printSuccess(null, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1,"系统异常，请稍后再试!!!");
		}
		 
	 }
	 
	 
	 /**
	  * 查询列表
	  */
	 @RequestMapping(value="/selectLsit", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectLsit() {
		 try {
			List<powerType> selectList = powerTypeService.selectList();
			this.printSuccess(selectList);
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍后再试!!!");
		}
		 
	 }
	 
	 /**
	  * 删除类别
	  * @param typeId
	  */
	 @RequestMapping(value="/deleteOne", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void deleteOne(String typeId) {
		 
		 try {
			powerTypeService.deleteByPrimaryKey(typeId);
			this.printSuccess(null, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍后再试!!!");
		}
		 
	 }
	 

}
