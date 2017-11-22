package com.firstCapacity.business.equipmentIedger.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.firstCapacity.business.equipmentIedger.entity.EquipmentIedger;
import com.firstCapacity.business.equipmentIedger.service.EquipmentIedgerExcelService;
import com.firstCapacity.util.ExcelAndCsvDownload;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/equipmentIedger")
public class EquipmentIedgerController extends ApiController{

	
	@Resource
	private EquipmentIedgerExcelService equipmentIedgerExcelService;
	

	 
	 
	 /**
		 *  新增设备
		 * @return
		 */
		@RequestMapping("/insert")  
		public String insert() {
			
			return "/html/power/shebei-xinxi";
			
		}
		
		
		/**
		 *  修改设备信息
		 * @return
		 */
		@RequestMapping("/update")  
		public String update() {
			
			return "/html/power/shebei-xiugai";
			
		}
		
		
		
		/**
		 *  设备详情
		 * @return
		 */
		@RequestMapping("/selectOne")  
		public String selectOne() {
			
			return "/html/power/shebei-xiangqing";
			
		}
		
		
		
		/**
		 * 导出
		 * 使用方法生成excle模板样式  
		 */
		@RequestMapping(value="/export", method=RequestMethod.GET)
		public void aud007Export(HttpServletRequest request,HttpServletResponse response,EquipmentIedger equipmentIedger){
			try {
				HSSFWorkbook workbook = equipmentIedgerExcelService.createExcel(equipmentIedger);  
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); // 定义文件名格式  
				String name = "设备台账信息"+format.format(new Date()) + ".xls";
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
	 
		
		
		
		
		
		
		/**
		 * 导出Excel模板
		 * 
		 */
		@RequestMapping(value="/getExcel", method=RequestMethod.GET)
		public void getExcel(HttpServletRequest request,HttpServletResponse response){
//			try {
				
				
				String Excelname ="设备台账导入信息(模板).xlsx";
				String type="xlsx";
				
				String download = request.getSession().getServletContext().getRealPath("/Excel/"); //获取下载路劲
		        try {
					ExcelAndCsvDownload.downLoadFile(Excelname,type,download, response);//依次传入需要下载的文件名，文件格式，路径，response参数
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		
		
		
	
}
