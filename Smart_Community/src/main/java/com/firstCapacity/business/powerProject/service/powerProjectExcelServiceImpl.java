package com.firstCapacity.business.powerProject.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.util.PageHelper;
import com.firstCapacity.util.Pager;

@Transactional
@Service
public class powerProjectExcelServiceImpl implements powerProjectExcelService{

	@Resource
	private powerProjectService powerProjectService;
	
	
	
	/**
	  *   能源项目 Excel 导出信息
	  * @param powerProject
	  * @return
	  */
	public HSSFWorkbook createExcel(powerProject powerProject,Integer page) {  
//		PageHelper.startPager(page);
		List<powerProject> selectqueryList = powerProjectService.selectqueryList(powerProject);
		
		// 创建一个webbook，对应一个excel文件  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		// 在webbook中添加一个sheet,对应excel文件中的sheet  
		HSSFSheet sheet = workbook.createSheet("能源项目信息");  
		// 设置列宽  
		sheet.setColumnWidth(0, 70 * 100);  
		sheet.setColumnWidth(1, 70 * 100);  
		sheet.setColumnWidth(2, 50 * 100);  
		sheet.setColumnWidth(3, 50 * 100);  
		sheet.setColumnWidth(4, 70 * 100);  
		sheet.setColumnWidth(5, 70 * 100);  
		sheet.setColumnWidth(6, 50 * 100);
		sheet.setColumnWidth(7, 50 * 100);
		sheet.setColumnWidth(8, 50 * 100);
		sheet.setColumnWidth(9, 50 * 100);
		sheet.setColumnWidth(10, 60 * 100);
		sheet.setColumnWidth(11, 100 * 100);
		sheet.setColumnWidth(12, 50 * 100);
		sheet.setColumnWidth(13, 50 * 100);
		sheet.setColumnWidth(14, 50 * 100);
		sheet.setColumnWidth(15, 70 * 100);
		sheet.setColumnWidth(16, 70 * 100);
		sheet.setColumnWidth(17, 50 * 100);
		sheet.setColumnWidth(18, 50 * 100);
		sheet.setColumnWidth(19, 50 * 100);
		
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
		cell.setCellValue("项目名称");  
		cell.setCellStyle(style);  
		cell = row.createCell(1);  
		cell.setCellValue("项目区域");  
		cell.setCellStyle(style);  
		cell = row.createCell(2);  
		cell.setCellValue("项目面积(万平米)");  
		cell.setCellStyle(style);
		cell = row.createCell(3);  
		cell.setCellValue("项目类型");  
		cell.setCellStyle(style);
		cell = row.createCell(4);  
		cell.setCellValue("托管日期");  
		cell.setCellStyle(style);
		cell = row.createCell(5);  
		cell.setCellValue("合同到期");  
		cell.setCellStyle(style);
		cell = row.createCell(6);  
		cell.setCellValue("合同期限");  
		cell.setCellStyle(style);
		cell = row.createCell(7);  
		cell.setCellValue("物业平米收费(元/㎡)");  
		cell.setCellStyle(style);
		cell = row.createCell(8);  
		cell.setCellValue("收费面积(㎡)");  
		cell.setCellStyle(style);
		
		cell = row.createCell(9);  
		cell.setCellValue("项目地址");  
		cell.setCellStyle(style);
		cell = row.createCell(10);  
		cell.setCellValue("签约客户");  
		cell.setCellStyle(style);
		cell = row.createCell(11);  
		cell.setCellValue("项目简介");  
		cell.setCellStyle(style);
//		cell = row.createCell(12);  
//		cell.setCellValue("能源费定价(元/㎡)");  
//		cell.setCellStyle(style);
		cell = row.createCell(12);  
		cell.setCellValue("设计热负荷(kW)");  
		cell.setCellStyle(style);
		cell = row.createCell(13);  
		cell.setCellValue("设计冷负荷(kW)");  
		cell.setCellStyle(style);
		cell = row.createCell(14);  
		cell.setCellValue("主机形式");  
		cell.setCellStyle(style);
		cell = row.createCell(15);  
		cell.setCellValue("设计单位热负荷(kW/m2)");  
		cell.setCellStyle(style);
		cell = row.createCell(16);  
		cell.setCellValue("设计单位冷负荷(kW/m2)");  
		cell.setCellStyle(style);
		cell = row.createCell(17);  
		cell.setCellValue("电价(元/kW·h)");  
		cell.setCellStyle(style);
		cell = row.createCell(18);  
		cell.setCellValue("水价(元/吨)");  
		cell.setCellStyle(style);
		cell = row.createCell(19);  
		cell.setCellValue("气价(元/Nm³)");  
		cell.setCellStyle(style);
		
		
		for (int i = 0; i < selectqueryList.size(); i++) {
			row = sheet.createRow(i + 1);  
			powerProject powerproject = selectqueryList.get(i);
			// 创建单元格，并设置值  
			// 编号列居左  
			HSSFCell c1 = row.createCell(0);  
			c1.setCellStyle(style1);  
			String projectName = powerproject.getProjectName();
			if(projectName != "" || projectName != null) {
				c1.setCellValue(projectName);  //项目名称
			}else {
				c1.setCellValue("");  //项目名称
			}
			
			HSSFCell c2 = row.createCell(1);  
			c2.setCellStyle(style1);
			String proName = powerproject.getProName();
			if(proName != "" || proName != null) {
				c2.setCellValue(proName);  //项目区域
			}else {
				c2.setCellValue("");  //项目区域
			}
			
			HSSFCell c3 = row.createCell(2);  
			c3.setCellStyle(style1);
			Double projectArea = powerproject.getProjectArea();
			if(projectArea != 0 || projectArea != null) {
				c3.setCellValue(projectArea);  //项目面积(万平米)
			}else {
				c3.setCellValue("");  //项目面积(万平米)
			}
			
			HSSFCell c4 = row.createCell(3);  
			c4.setCellStyle(style1);
			String conditionerArea = powerproject.getConditionerArea();
			if(conditionerArea != "" || conditionerArea != null) {
				c4.setCellValue(conditionerArea);  //项目类型
			}else {
				c4.setCellValue("");  //项目类型
			}
			
			HSSFCell c5 = row.createCell(4);  
			c5.setCellStyle(style1);
			String trusteeshipTime = powerproject.getTrusteeshipTime();
			if(trusteeshipTime != "" || trusteeshipTime != null) {
				c5.setCellValue(trusteeshipTime);  //托管日期
			}else {
				c5.setCellValue("");  //托管日期
			}
			
			HSSFCell c6 = row.createCell(5);  
			c6.setCellStyle(style1);
			String expireTime = powerproject.getExpireTime();
			if(expireTime != "" || expireTime != null) {
				c6.setCellValue(expireTime);  //合同到期
			}else {
				c6.setCellValue("");  //合同到期
			}
			
			HSSFCell c7 = row.createCell(6);  
			c7.setCellStyle(style1);
			String contractLife = powerproject.getContractLife();
			if(contractLife != "" || contractLife != null) {
				c7.setCellValue(contractLife);  //合同期限
			}else {
				c7.setCellValue("");  //合同期限
			}
			
			HSSFCell c8 = row.createCell(7);  
			c8.setCellStyle(style1);
			Double energyPrice = powerproject.getEnergyPrice();
			if(energyPrice != 0 || energyPrice != null) {
				c8.setCellValue(energyPrice);  //物业平米收费(元/㎡)
			}else {
				c8.setCellValue("");  //物业平米收费(元/㎡)
			}
			
			HSSFCell c9 = row.createCell(8);  
			c9.setCellStyle(style1);
			Double chargingArea = powerproject.getChargingArea();
			if(chargingArea != 0 || chargingArea != null) {
				c9.setCellValue(chargingArea);  //收费面积(㎡)
			}else {
				c9.setCellValue("");  //收费面积(㎡)
			}
			
			HSSFCell c10 = row.createCell(9);  
			c10.setCellStyle(style1);
			String projectAddress = powerproject.getProjectAddress();
			if(projectAddress != "" || projectAddress != null) {
				c10.setCellValue(projectAddress);  //项目地址
			}else {
				c10.setCellValue("");  //项目地址
			}
			
			HSSFCell c11 = row.createCell(10);  
			c11.setCellStyle(style1);
			String contractCustomer = powerproject.getContractCustomer();
			if(contractCustomer != "" || contractCustomer != null) {
				c11.setCellValue(contractCustomer);  //签约客户
			}else {
				c11.setCellValue("");  //签约客户
			}
			
			HSSFCell c12 = row.createCell(11);  
			c12.setCellStyle(style1);
			String projectIntroduce = powerproject.getProjectIntroduce();
			if(projectIntroduce != "" || projectIntroduce != null) {
				c12.setCellValue(projectIntroduce);  //项目简介
			}else {
				c12.setCellValue("");  //项目简介
			}
			
			HSSFCell c13 = row.createCell(12);  
			c13.setCellStyle(style1);
			Double designHeatingLoad = powerproject.getDesignHeatingLoad();
			if(designHeatingLoad != 0 || designHeatingLoad != null) {
				c13.setCellValue(designHeatingLoad);  //设计热负荷(kW)
			}else {
				c13.setCellValue("");  //设计热负荷(kW)
			}
			
			HSSFCell c14 = row.createCell(13);  
			c14.setCellStyle(style1);
			Double designCoolingLoad = powerproject.getDesignCoolingLoad();
			if(designCoolingLoad != 0 || designCoolingLoad != null) {
				c14.setCellValue(designCoolingLoad);  //设计冷负荷(kW)
			}else {
				c14.setCellValue("");  //设计冷负荷(kW)
			}
			
			HSSFCell c15 = row.createCell(14);  
			c15.setCellStyle(style1);
			String hostOnly = powerproject.getHostOnly();
			if(hostOnly != "" || hostOnly != null) {
				c15.setCellValue(hostOnly);  //主机形式
			}else {
				c15.setCellValue("");  //主机形式
			}
			
			HSSFCell c16 = row.createCell(15);  
			c16.setCellStyle(style1);
			Double companyHeatingLoad = powerproject.getCompanyHeatingLoad();
			if(companyHeatingLoad != 0 || companyHeatingLoad != null) {
				c16.setCellValue(companyHeatingLoad);  //设计单位热负荷(kW/m2)
			}else {
				c16.setCellValue("");  //设计单位热负荷(kW/m2)
			}
			
			HSSFCell c17 = row.createCell(16);  
			c17.setCellStyle(style1);
			Double companyCoolingLoad = powerproject.getCompanyCoolingLoad();
			if(companyCoolingLoad != 0 || companyCoolingLoad != null) {
				c17.setCellValue(companyCoolingLoad);  //设计单位冷负荷(kW/m2)
			}else {
				c17.setCellValue("");  //设计单位冷负荷(kW/m2)
			}
			
			HSSFCell c18 = row.createCell(17);  
			c18.setCellStyle(style1);
			Double electricPrice = powerproject.getElectricPrice();
			if(electricPrice != 0 || electricPrice != null) {
				c18.setCellValue(electricPrice);  //电价(元/kW·h)
			}else {
				c18.setCellValue("");  //电价(元/kW·h)
			}
			
			HSSFCell c19 = row.createCell(18);  
			c19.setCellStyle(style1);
			Double waterPrice = powerproject.getWaterPrice();	
			if(waterPrice != 0 || waterPrice != null) {
				c19.setCellValue(waterPrice);  //水价(元/吨)
			}else {
				c19.setCellValue("");  //水价(元/吨)
			}
			
			HSSFCell c20 = row.createCell(19);  
			c20.setCellStyle(style1);
			Double gasPrice = powerproject.getGasPrice();
			if(gasPrice != 0 || gasPrice != null) {
				c20.setCellValue(gasPrice);  //气价(元/Nm3)
			}else {
				c20.setCellValue("");  //气价(元/Nm3)
			}
			
		}  
		return workbook;  
	}



	
	
	
	
}
