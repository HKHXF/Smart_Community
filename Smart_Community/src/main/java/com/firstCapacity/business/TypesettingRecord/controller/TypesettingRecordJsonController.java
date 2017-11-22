package com.firstCapacity.business.TypesettingRecord.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstCapacity.business.StaffInformation.entity.StaffInformation;
import com.firstCapacity.business.TypesettingRecord.entity.TypesettingRecord;
import com.firstCapacity.business.TypesettingRecord.service.TypesettingRecordService;
import com.firstCapacity.business.powerProject.entity.usepublic;
import com.firstCapacity.business.powerProject.service.powerProjectService;
import com.firstCapacity.util.PageHelper;
import com.firstCapacity.util.Pager;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/TypesettingRecordJsonController")
public class TypesettingRecordJsonController extends ApiController{

	 private final static Logger logger = LoggerFactory.getLogger(TypesettingRecordJsonController.class); 
	
	 
	 @Resource
	 private TypesettingRecordService typesettingRecordService;
	 
	 @Resource
	 private powerProjectService powerProjectService;
	 
	 
	 
	 
	 
	 /**
	  *  查询列表-搜索
	  * @param staffInformation
	  * @param page
	  */
	 @RequestMapping(value="/queryList", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void queryList(TypesettingRecord typesettingRecord,@RequestParam(required=true,defaultValue="1") Integer page) {
		 
		 try {
			PageHelper.startPager(page);
			List<TypesettingRecord> selectList = typesettingRecordService.selectList(typesettingRecord);
			 Pager<TypesettingRecord> p = new Pager<TypesettingRecord>(selectList);
			 usepublic selectQuyuAndProbject = powerProjectService.quyuProbject();
			 selectQuyuAndProbject.setTypesettingRecordList(p);
			 this.printSuccess(selectQuyuAndProbject, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍后再试");
		}
		 
	 }
	 
	 
	 /**
	  * 新增上传排班记录
	  */
	 @RequestMapping(value="/insert", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void insert(TypesettingRecord typesettingRecord) {
		 
		 try {
			 String trim = typesettingRecord.getFileName().trim();
			List<TypesettingRecord> chickNme = typesettingRecordService.chickNme(trim);
			 if(chickNme.size() > 0) {
				 this.printFailure(1, "该名称已存在,请检查!");
			 }else {
				 typesettingRecordService.insert(typesettingRecord);
				 this.printSuccess();
			 }
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!");
		}
		 
	 }
	 
	 
	 
	 /**
	  * 根据id查询详情
	  * @param typesettingId
	  */
	 @RequestMapping(value="/selectOne", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectOne(String typesettingId) {
		 
		 try {
			TypesettingRecord selectOne = typesettingRecordService.selectOne(typesettingId);
			 this.printSuccess(selectOne, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
	 }
	 
	 
	 
	 /**
	  * 删除排班信息
	  */
	 @RequestMapping(value="/delete", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void delete(String typesettingId) {
		 
		 try {
			typesettingRecordService.delete(typesettingId);
			 this.printSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
	 }
	 
	 
	 
}
