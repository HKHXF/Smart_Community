package com.firstCapacity.business.equipmentIedger.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.firstCapacity.business.equipmentIedger.entity.EquipmentIedger;
import com.firstCapacity.business.equipmentIedger.service.EquipmentIedgerExcelService;
import com.firstCapacity.business.equipmentIedger.service.EquipmentIedgerService;
import com.firstCapacity.business.equipmentType.entity.EquipmentType;
import com.firstCapacity.business.equipmentType.service.EquipmentTypeService;
import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.business.powerProject.entity.usepublic;
import com.firstCapacity.business.powerProject.service.powerProjectService;
import com.firstCapacity.util.PageHelper;
import com.firstCapacity.util.Pager;
import com.firstCapacity.util.json.ApiController;
import com.firstCapacity.util.json.SpringMVCUtil;

@Controller
@RequestMapping("/equipmentIedgerJson")
public class EquipmentIedgerJsonController extends ApiController{

	 private final static Logger logger = LoggerFactory.getLogger(EquipmentIedgerJsonController.class); 
	
	 @Resource
	 private EquipmentIedgerService EquipmentIedgerService;
	 
	 @Resource
	 private EquipmentTypeService equipmentTypeService;
	 
	 @Resource
	 private powerProjectService powerProjectService;
	 
	 @Resource
	 private EquipmentIedgerExcelService equipmentIedgerExcelService;
	 
	 
	 
	 
	 /**
	  * 新增设备信息
	  * @param equipmentIedger
	  */
	 @RequestMapping(value="/insert", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void insert(EquipmentIedger equipmentIedger) {
		 
		 try {
			 List<EquipmentIedger> chickName = EquipmentIedgerService.chickName(equipmentIedger.getEquipmentName());
			 if(chickName.size() > 0) {
				 this.printFailure(1,"设备信息已存在,请检查!!!");
				 logger.debug("设备信息已存在");
			 }else {
				 EquipmentIedgerService.insert(equipmentIedger);
				 this.printSuccess(0,"成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
	 /**
	  * 修改设备信息
	  * @param equipmentIedger
	  */
	 @RequestMapping(value="/update", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void update(EquipmentIedger equipmentIedger) {
		 
		 try {
			EquipmentIedgerService.update(equipmentIedger);
			 this.printSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 /**
	  *  删除设备信息
	  */
	 @RequestMapping(value="/delete", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void delete(String equipmentIedgerId) {
		 try {
			EquipmentIedgerService.delete(equipmentIedgerId);
			 this.printSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
	 }
	 
	 
	 
	 /**
	  * 模糊查询设备列表
	  * @param equipmentIedger
	  */
	 @RequestMapping(value="/querylist", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void querylist(EquipmentIedger equipmentIedger,@RequestParam(required=true,defaultValue="1") Integer page) {
		 
		 try {
			PageHelper.startPager(page);
			 List<EquipmentIedger> selectLsit = EquipmentIedgerService.selectLsit(equipmentIedger);
			 Pager<EquipmentIedger> p = new Pager<EquipmentIedger>(selectLsit);
			 List<EquipmentType> selectAll = equipmentTypeService.selectAll();
			 List<powerProject> qyuryQuyu = powerProjectService.qyuryQuyu();
			 usepublic usepublic = new usepublic();
			 usepublic.setEquipmentIedgerList(p);
			 usepublic.setShebeiType(selectAll);
			 usepublic.setQuyu(qyuryQuyu);
			 this.printSuccess(usepublic, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
	 }
	 
	 
	 
	 
	 
	 /**
	  * 批量导入查询区域和项目名称
	  * @param equipmentIedger
	  */
	 @RequestMapping(value="/queryQuyuName", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void queryQuyuType() {
		 
		 try {
			usepublic quyuProbject = powerProjectService.quyuProbject();
			 this.printSuccess(quyuProbject, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
	 }
	 
	 
	 
	 
	 /**
	  * 查询项目详情
	  * @param equipmentIedgerId
	  */
	 @RequestMapping(value="/selectOne", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectOne(String equipmentIedgerId) {
		 
		 try {
			EquipmentIedger selectOne = EquipmentIedgerService.selectOne(equipmentIedgerId);
			 this.printSuccess(selectOne, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 /**
	  *  设备列表导入数据库
	  * @param equipmentIedger
	  */
	 @RequestMapping(value="/daoruExcel", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void daoruExcel(EquipmentIedger equipmentIedger) {
		 
		 try {
			MultipartFile upFiles = equipmentIedger.getUpFiles();
			 String originalFilename = upFiles.getOriginalFilename();
				if (!originalFilename.endsWith(".xls") && !originalFilename.endsWith(".xlsx")) {
					this.printFailure(1, "文件不是excel类型");
				}
				String uploadPath = "upload/EquipmentIedgerExcel";
				String rootPath = SpringMVCUtil.getRequest().getSession().getServletContext().getRealPath("/");
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				String imagePath = uploadPath + "/" + uuid + originalFilename;
				String destFileName = rootPath+imagePath;
				File file = new File(destFileName);
				//判断目标文件所在的目录是否存在  
			    if(!file.getParentFile().exists()) {  
			        //如果目标文件所在的目录不存在，则创建父目录  
			        System.out.println("目标文件所在目录不存在，准备创建它！"); 
			        file.mkdirs();
			        logger.debug("新建文件成功");
			    }  
			    try {
					file.createNewFile();// 创建文件函数
					upFiles.transferTo(file); 
				} catch (Exception e) {
					e.printStackTrace();
					logger.debug("Excel存储阶段失败");
					this.printFailure(1, "服务异常,请稍后再试!");
				}
			    String regionId = equipmentIedger.getRegionId();
			    String projectId = equipmentIedger.getProjectId();
			    Integer duquExcel = equipmentIedgerExcelService.duquExcel(destFileName, regionId, projectId);
			    if(duquExcel == 2) {
			    	this.printFailure(1, "获取Excel失败");
			    }else if(duquExcel == 3) {
			    	this.printFailure(1, "获取Excel失败-表头列数与要导入的数据库不对应");
			    }else if(duquExcel == 4){
			    	this.printFailure(1, "表头不合规范，请修改后重新导入");
			    }else if(duquExcel == 5) {
			    	this.printFailure(1, "Excel内没有数据!");
			    }else if(duquExcel == 6) {
			    	this.printFailure(1, "获取单元格错误");
			    }else if(duquExcel == 7) {
			    	this.printFailure(1, "数据不全是数字或全部是文字!");
			    }else if(duquExcel == 8) {
			    	this.printFailure(1, "导入数据数据库中有存在的值,请检查!");
			    }else {
			    	this.printSuccess();
			    }
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
	        
		 
	 }
	 
	 
	 
	 
}
