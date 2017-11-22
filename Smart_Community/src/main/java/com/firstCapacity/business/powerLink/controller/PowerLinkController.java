package com.firstCapacity.business.powerLink.controller;



import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.firstCapacity.business.powerLink.service.PowerLinkExcelService;
import com.firstCapacity.util.json.ApiController;
import com.firstCapacity.util.json.SpringMVCUtil;

@Controller
@RequestMapping("/powerLink")
public class PowerLinkController extends ApiController{

	
	@Resource
	private PowerLinkExcelService powerLinkExcelService;
	

	/**
	 * 跳转导入页面
	 * @return
	 */
	@RequestMapping("/toPowerLink")
	public String toHefei() {
		
		return "/view/hefeiLink";
		
	}
	
	
	 
	 /**
	  *  合肥纽带数据导入数据库
	  * @param equipmentIedger
	  */
	 @RequestMapping(value="/daoruExcel", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void daoruExcel(MultipartFile upFiles) {
		 
		 try {
			 String originalFilename = upFiles.getOriginalFilename();
				if (!originalFilename.endsWith(".xls") && !originalFilename.endsWith(".xlsx")) {
					this.printFailure(1, "文件不是excel类型");
				}
				String uploadPath = "upload/HefeiLinkExcel";
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
			    Integer duquExcel = powerLinkExcelService.duquExcel(destFileName);
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
