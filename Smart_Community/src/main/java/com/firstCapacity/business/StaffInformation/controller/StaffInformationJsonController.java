package com.firstCapacity.business.StaffInformation.controller;

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
import com.firstCapacity.business.StaffInformation.service.StaffInformationService;
import com.firstCapacity.business.powerProject.entity.usepublic;
import com.firstCapacity.business.powerProject.service.powerProjectService;
import com.firstCapacity.util.PageHelper;
import com.firstCapacity.util.Pager;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/StaffInformationJson")
public class StaffInformationJsonController extends ApiController{

	 private final static Logger logger = LoggerFactory.getLogger(StaffInformationJsonController.class); 
	
	 
	 @Resource
	 private StaffInformationService staffInformationService;
	 @Resource
	 private powerProjectService powerProjectService;
	 
	 
	 
	 /**
	  * 新增职员信息
	  */
	 @RequestMapping(value="/insert", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void insert(StaffInformation staffInformation) {
		 
		 try {
			 List<StaffInformation> chickName = staffInformationService.chickName(staffInformation.getStaffName());
			 if(chickName.size() > 0) {
				 this.printFailure(1, "职员信息已存在,请检查");
			 }else {
				 staffInformationService.insert(staffInformation);
				 this.printSuccess();
			 }
 		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
	 /**
	  * 修改职员信息
	  * @param staffInformation
	  */
	 @RequestMapping(value="/update", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void update(StaffInformation staffInformation) {
		 
		 try {
			staffInformationService.update(staffInformation);
			 this.printSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试");
		}
		 
	 }
	 
	 
	 /**
	  *  删除职员信息
	  * @param staffId
	  */
	 @RequestMapping(value="/delete", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void delete(String staffId) {
		 
		 try {
			staffInformationService.delete(staffId);
			 this.printSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试");
		}
		 
	 }
	 
	 
	 
	 /**
	  * 查询详情
	  * @param staffId
	  */
	 @RequestMapping(value="/selectOne", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectOne(String staffId) {
		 
		 try {
			StaffInformation selectOne = staffInformationService.selectOne(staffId);
			 this.printSuccess(selectOne, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试");
		}
		 
	 }
	 
	 
	 
	 /**
	  *  查询列表-搜索
	  * @param staffInformation
	  * @param page
	  */
	 @RequestMapping(value="/queryList", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void queryList(StaffInformation staffInformation,@RequestParam(required=true,defaultValue="1") Integer page) {
		 
		 try {
			PageHelper.startPager(page);
			 List<StaffInformation> selectList = staffInformationService.selectList(staffInformation);
			 Pager<StaffInformation> p = new Pager<StaffInformation>(selectList);
			 usepublic selectQuyuAndProbject = powerProjectService.quyuProbject();
			 selectQuyuAndProbject.setStaffInformationList(p);
			 this.printSuccess(selectQuyuAndProbject, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍后再试");
		}
		 
	 }
	 
	 
	 
	 
	 /**
	  *  查询区域和项目
	  * @param staffInformation
	  * @param page
	  */
	 @RequestMapping(value="/toquyuandxiangmu", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void toquyuandxiangmu() {
		 
		 try {
			 usepublic selectQuyuAndProbject = powerProjectService.selectQuyuAndProbject();
			 this.printSuccess(selectQuyuAndProbject, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍后再试");
		}
		 
	 }
	 
	 
	 
	 
	 
	 
}
