package com.firstCapacity.business.powerProject.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.business.powerProject.service.powerProjectExcelService;
import com.firstCapacity.business.powerProject.service.powerProjectService;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/powerProject")
public class powerProjectController extends ApiController{

	
	@Resource
	private powerProjectService powerProjectService;
	
	@Resource
	private powerProjectExcelService powerProjectExcelService;

	 
	 
	 /**
		 *  新增能源项目
		 * @return
		 */
		@RequestMapping("/insert")  
		public String insert() {
			
			return "/html/power/xm-xinzeng";
			
		}
		
		
		/**
		 *  修改能源项目
		 * @return
		 */
		@RequestMapping("/update")  
		public String update() {
			
			return "/html/power/xm-xiugai";
			
		}
		
		
		/**
		 * 项目详情
		 * @return
		 */
		@RequestMapping("/xiangqing")
		public String xiangqing() {
			
			return "/html/power/xm-xiangqing";
		}
		
		
		
		/**
		 * 职员信息列表
		 * @return
		 */
		@RequestMapping("/zhiyuanxinxi")
	    public String zhiyuanxinxi() {
	    	
	    	return "/html/power/zy-xx";
	    }
		
		
		
		/**
		 * 维保记录列表
		 * @return
		 */
		@RequestMapping("/weibao")
		public String weibo() {
			
			return "/html/power/wb-jl";
			
		}
		
		
		
		/**
		 * 运行参数
		 * @return
		 */
		@RequestMapping("/yunxin-canshu")
		public String yunxinCanshu() {
			
			return "/html/power/yx-cs";
			
		}
		
		
		
		/**
		 * 运行参数
		 * @return
		 */
		@RequestMapping("/yunxinJilu")
		public String yunxinJilu() {
			
			return "/html/power/kq-zl";
			
		}
		
		
		
		/**
		 * 项目概况-世界地图
		 * @return
		 */
		@RequestMapping("/mapWord")
		public String mapWord() {
			
			return "/html/power/map-word";
			
		}
		
		
		
		/**
		 * 导出
		 * 使用方法生成excle模板样式  
		 */
		@RequestMapping(value="/export", method=RequestMethod.GET)
		public void aud007Export(HttpServletRequest request,HttpServletResponse response,powerProject powerProject,Integer page){
			try {
				HSSFWorkbook workbook = powerProjectExcelService.createExcel(powerProject,page);  
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); // 定义文件名格式  
				String name = "能源项目信息"+format.format(new Date()) + ".xls";
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
