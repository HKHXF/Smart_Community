package com.firstCapacity.business.StaffInformation.service;


import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.StaffInformation.entity.StaffInformation;
import com.firstCapacity.business.StaffInformation.mapper.StaffInformationMapper;

@Transactional
@Service
public class StaffInformationExcelServiceImpl implements StaffInformationExcelService{
	
	
	private final static Logger logger = LoggerFactory.getLogger(StaffInformationExcelServiceImpl.class);

	@Resource
	private StaffInformationMapper staffInformationMapper;
	
	/** 
	 * 导出Excel
	 */
	@Override
	public HSSFWorkbook createExcel(StaffInformation staffInformation) {

		List<StaffInformation> queryList = staffInformationMapper.queryList(staffInformation);
		
		// 创建一个webbook，对应一个excel文件  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		// 在webbook中添加一个sheet,对应excel文件中的sheet  
		HSSFSheet sheet = workbook.createSheet("职员信息");  
		// 设置列宽  
		sheet.setColumnWidth(0, 70 * 100);  
		sheet.setColumnWidth(1, 70 * 100);  
		sheet.setColumnWidth(2, 50 * 100);  
		sheet.setColumnWidth(3, 50 * 100);  
		sheet.setColumnWidth(4, 70 * 100);  
		sheet.setColumnWidth(5, 70 * 100);  
		sheet.setColumnWidth(6, 50 * 100);
		
		// 在sheet中添加表头第0行  
		HSSFRow row = sheet.createRow(0);  
		// 创建单元格，并设置表头，设置表头居中  
		HSSFCellStyle style = workbook.createCellStyle();  
		// 创建一个居中格式  
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 居中  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		// 带边框  
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
		// 生成一个字体  
		HSSFFont font = workbook.createFont();  
		// 字体增粗  
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
		// 字体大小  
		font.setFontHeightInPoints((short) 12);  
		// 把字体应用到当前的样式  
		style.setFont(font);  
		// 单独设置整列居中或居左  
		HSSFCellStyle style1 = workbook.createCellStyle();  
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
		HSSFCellStyle style2 = workbook.createCellStyle();  
		style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);  
		HSSFCellStyle style3 = workbook.createCellStyle();  
		style3.setAlignment(HSSFCellStyle.ALIGN_LEFT);  
		HSSFFont hssfFont = workbook.createFont();  
		hssfFont.setColor(HSSFFont.COLOR_RED);  
		hssfFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
		style3.setFont(hssfFont);  
		HSSFCellStyle style4 = workbook.createCellStyle();  
		style4.setAlignment(HSSFCellStyle.ALIGN_LEFT);  
		HSSFFont hssfFont1 = workbook.createFont();  
		hssfFont1.setColor(HSSFFont.COLOR_NORMAL);  
		hssfFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style4.setFont(hssfFont1);  
		HSSFCell cell;
		cell = row.createCell(0);  
		cell.setCellValue("职员姓名");  
		cell.setCellStyle(style);  
		cell = row.createCell(1);  
		cell.setCellValue("项目名称");  
		cell.setCellStyle(style);  
		cell = row.createCell(2);  
		cell.setCellValue("区域名称");  
		cell.setCellStyle(style);
		cell = row.createCell(3);  
		cell.setCellValue("年龄");  
		cell.setCellStyle(style);
		cell = row.createCell(4);  
		cell.setCellValue("职位");  
		cell.setCellStyle(style);
		cell = row.createCell(5);  
		cell.setCellValue("联系方式");  
		cell.setCellStyle(style);
		
		for (int i = 0; i < queryList.size(); i++) {
			row = sheet.createRow(i + 1);  
			StaffInformation StaffInformation = queryList.get(i);
			// 创建单元格，并设置值  
			// 编号列居左  
			HSSFCell c1 = row.createCell(0);  
			c1.setCellStyle(style1);  
			String staffName = StaffInformation.getStaffName();
			if(staffName != "" || staffName != null) {
				c1.setCellValue(staffName);  //职员姓名
			}else {
				c1.setCellValue("");  //职员姓名
			}
			
			HSSFCell c2 = row.createCell(1);  
			c2.setCellStyle(style1);
			String projectName = StaffInformation.getProjectName();
			if(projectName != "" || projectName != null) {
				c2.setCellValue(projectName);  //项目名称
			}else {
				c2.setCellValue("");  //项目名称
			}
			
			HSSFCell c3 = row.createCell(2);  
			c3.setCellStyle(style1);
			String regionName = StaffInformation.getRegionName();
			if(regionName != "" || regionName != null) {
				c3.setCellValue(regionName);  //区域名称
			}else {
				c3.setCellValue("");  //区域名称
			}
			
			HSSFCell c4 = row.createCell(3);  
			c4.setCellStyle(style1);
			String age = StaffInformation.getAge();
			if(age != "" || age != null) {
				c4.setCellValue(age);  //年龄
			}else {
				c4.setCellValue("");  //年龄
			}
			
			HSSFCell c5 = row.createCell(4);  
			c5.setCellStyle(style1);
			String position = StaffInformation.getPosition();
			if(position != "" || position != null) {
				c5.setCellValue(position);  //职位
			}else {
				c5.setCellValue("");  //职位
			}
			
			HSSFCell c6 = row.createCell(5);  
			c6.setCellStyle(style1);
			String contactInformation = StaffInformation.getContactInformation();
			if(contactInformation != "" || contactInformation != null) {
				c6.setCellValue(contactInformation);  //联系方式
			}else {
				c6.setCellValue("");  //联系方式
			}
			
		}  
		return workbook;  
		
	}
	
	
}
