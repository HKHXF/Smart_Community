package com.firstCapacity.business.StaffInformation.controller;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.firstCapacity.business.StaffInformation.entity.StaffInformation;
import com.firstCapacity.business.StaffInformation.service.StaffInformationExcelService;
import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/StaffInformationController")
public class StaffInformationController extends ApiController{

	@Resource
	private StaffInformationExcelService staffInformationExcelService;
	
	
	
	    /**
	     * 通往排班记录
	     * @return
	     */
	    @RequestMapping("/panban")  
		public String panban() {
			
			return "/html/power/pb-jl";
			
			
		}
	 
	
	    
	    
	    
	    
	    

		/**
		 * 导出
		 * 使用方法生成excle模板样式  
		 */
		@RequestMapping(value="/export", method=RequestMethod.GET)
		public void aud007Export(HttpServletRequest request,HttpServletResponse response,StaffInformation staffInformation,Integer page){
			try {
				HSSFWorkbook workbook = staffInformationExcelService.createExcel(staffInformation);  
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); // 定义文件名格式  
				String name = "职员信息"+format.format(new Date()) + ".xls";
				String codedFilename = "";
		           String agent = request.getHeader("USER-AGENT");
		           if (null != agent && -1 != agent.indexOf("MSIE") || null != agent  
		                   && -1 != agent.indexOf("Trident") || null != agent && -1 != agent.indexOf("Edge")) {// ie浏览器及Edge浏览器  
		               String namea = java.net.URLEncoder.encode(name, "UTF-8");  
		               codedFilename = namea;  
		           } else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,Chrome等浏览器  
		               codedFilename = new String(name.getBytes("UTF-8"), "iso-8859-1");  
		           }
				
				response.setContentType("application/vnd.ms-excel");  
				response.addHeader("Content-Disposition", "attachment;filename=" + codedFilename);  
				workbook.write(response.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    
	    
	    
	    
	    
	    
}
