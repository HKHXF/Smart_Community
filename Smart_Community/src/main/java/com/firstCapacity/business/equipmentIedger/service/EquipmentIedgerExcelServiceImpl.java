package com.firstCapacity.business.equipmentIedger.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.firstCapacity.business.equipmentIedger.entity.EquipmentIedger;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Transactional
@Service
public class EquipmentIedgerExcelServiceImpl implements EquipmentIedgerExcelService{

	private final static Logger logger = LoggerFactory.getLogger(EquipmentIedgerExcelServiceImpl.class); 
	
	@Resource
	private EquipmentIedgerService equipmentIedgerService;
	
	
	
	/**
	  *   能源项目 Excel 导出信息
	  * @param powerProject
	  * @return
	  */
	public HSSFWorkbook createExcel(EquipmentIedger equipmentIedger) {  
//		PageHelper.startPager(page);
		List<EquipmentIedger> selectLsit = equipmentIedgerService.selectLsit(equipmentIedger);
		
		// 创建一个webbook，对应一个excel文件  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		// 在webbook中添加一个sheet,对应excel文件中的sheet  
		HSSFSheet sheet = workbook.createSheet("设备台账信息");  
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
		sheet.setColumnWidth(20, 50 * 100);
		sheet.setColumnWidth(21, 50 * 100);
		sheet.setColumnWidth(22, 50 * 100);
		sheet.setColumnWidth(23, 50 * 100);
		sheet.setColumnWidth(24, 50 * 100);
		sheet.setColumnWidth(25, 50 * 100);
		sheet.setColumnWidth(26, 50 * 100);
		sheet.setColumnWidth(27, 50 * 100);
		sheet.setColumnWidth(28, 50 * 100);
		sheet.setColumnWidth(29, 50 * 100);
		sheet.setColumnWidth(30, 80 * 100);
		
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
		cell.setCellValue("设备名称");  
		cell.setCellStyle(style);  
		cell = row.createCell(1);  
		cell.setCellValue("区域名称");  
		cell.setCellStyle(style);  
		cell = row.createCell(2);  
		cell.setCellValue("项目名称");  
		cell.setCellStyle(style);
		cell = row.createCell(3);  
		cell.setCellValue("设备类型");  
		cell.setCellStyle(style);
		cell = row.createCell(4);  
		cell.setCellValue("安装地址");  
		cell.setCellStyle(style);
		cell = row.createCell(5);  
		cell.setCellValue("生产厂家");  
		cell.setCellStyle(style);
		cell = row.createCell(6);  
		cell.setCellValue("生产厂家地址");  
		cell.setCellStyle(style);
		cell = row.createCell(7);  
		cell.setCellValue("联系电话");  
		cell.setCellStyle(style);
		cell = row.createCell(8);  
		cell.setCellValue("机组型号");  
		cell.setCellStyle(style);
		
		cell = row.createCell(9);  
		cell.setCellValue("出厂编号");  
		cell.setCellStyle(style);
		cell = row.createCell(10);  
		cell.setCellValue("功率kW");  
		cell.setCellStyle(style);
		cell = row.createCell(11);  
		cell.setCellValue("电压V");  
		cell.setCellStyle(style);
//		cell = row.createCell(12);  
//		cell.setCellValue("能源费定价(元/㎡)");  
//		cell.setCellStyle(style);
		cell = row.createCell(12);  
		cell.setCellValue("重量kg");  
		cell.setCellStyle(style);
		cell = row.createCell(13);  
		cell.setCellValue("扬程m");  
		cell.setCellStyle(style);
		cell = row.createCell(14);  
		cell.setCellValue("转速r/min");  
		cell.setCellStyle(style);
		cell = row.createCell(15);  
		cell.setCellValue("流量m3/h");  
		cell.setCellStyle(style);
		cell = row.createCell(16);  
		cell.setCellValue("回路数");  
		cell.setCellStyle(style);
		cell = row.createCell(17);  
		cell.setCellValue("温度限制℃");  
		cell.setCellStyle(style);
		cell = row.createCell(18);  
		cell.setCellValue("容量m3");  
		cell.setCellStyle(style);
		cell = row.createCell(19);  
		cell.setCellValue("电流A");  
		cell.setCellStyle(style);
		
		cell = row.createCell(20);  
		cell.setCellValue("备注");  
		cell.setCellStyle(style);
		cell = row.createCell(21);  
		cell.setCellValue("是否使用");  
		cell.setCellStyle(style);
		cell = row.createCell(22);  
		cell.setCellValue("是否完好");  
		cell.setCellStyle(style);
		cell = row.createCell(23);  
		cell.setCellValue("设备使用状态");  
		cell.setCellStyle(style);
		cell = row.createCell(24);  
		cell.setCellValue("设备完好状态");  
		cell.setCellStyle(style);
		cell = row.createCell(25);  
		cell.setCellValue("安装单位");  
		cell.setCellStyle(style);
		cell = row.createCell(26);  
		cell.setCellValue("安装联系人");  
		cell.setCellStyle(style);
		cell = row.createCell(27);  
		cell.setCellValue("联系方式");  
		cell.setCellStyle(style);
		cell = row.createCell(28);  
		cell.setCellValue("保修终止日");  
		cell.setCellStyle(style);
		cell = row.createCell(29);  
		cell.setCellValue("安装日期");  
		cell.setCellStyle(style);
		cell = row.createCell(30);  
		cell.setCellValue("启用时间");  
		cell.setCellStyle(style);
		cell = row.createCell(31);  
		cell.setCellValue("交接时运行状况");  
		cell.setCellStyle(style);
		
		
		for (int i = 0; i < selectLsit.size(); i++) {
			row = sheet.createRow(i + 1);  
			EquipmentIedger equipmentIedgerOne = selectLsit.get(i);
			// 创建单元格，并设置值  
			// 编号列居左  
			HSSFCell c1 = row.createCell(0);  
			c1.setCellStyle(style1);  
			String equipmentName = equipmentIedgerOne.getEquipmentName();
			if(equipmentName != "" || equipmentName != null) {
				c1.setCellValue(equipmentName);  //设备名称
			}else {
				c1.setCellValue("");  //设备名称
			}
			
			HSSFCell c2 = row.createCell(1);  
			c2.setCellStyle(style1);
			String regionName = equipmentIedgerOne.getRegionName();
			if(regionName != "" || regionName != null) {
				c2.setCellValue(regionName);  //区域名称
			}else {
				c2.setCellValue("");  //区域名称
			}
			
			HSSFCell c3 = row.createCell(2);  
			c3.setCellStyle(style1);
			String projectName = equipmentIedgerOne.getProjectName();
			if(projectName != "" || projectName != null) {
				c3.setCellValue(projectName);  //项目名称
			}else {
				c3.setCellValue("");  //项目名称
			}
			
			HSSFCell c4 = row.createCell(3);  
			c4.setCellStyle(style1);
			String equipmentTypeName = equipmentIedgerOne.getEquipmentTypeName();
			if(equipmentTypeName != "" || equipmentTypeName != null) {
				c4.setCellValue(equipmentTypeName);  //设备类型
			}else {
				c4.setCellValue("");  //设备类型
			}
			
			HSSFCell c5 = row.createCell(4);  
			c5.setCellStyle(style1);
			String installationAddress = equipmentIedgerOne.getInstallationAddress();
			if(installationAddress != "" || installationAddress != null) {
				c5.setCellValue(installationAddress);  //安装地址
			}else {
				c5.setCellValue("");  //安装地址
			}
			
			HSSFCell c6 = row.createCell(5);  
			c6.setCellStyle(style1);
			String manufacturer = equipmentIedgerOne.getManufacturer();
			if(manufacturer != "" || manufacturer != null) {
				c6.setCellValue(manufacturer);  //生产厂家
			}else {
				c6.setCellValue("");  //生产厂家
			}
			
			HSSFCell c7 = row.createCell(6);  
			c7.setCellStyle(style1);
			String gomanufacturerAddress = equipmentIedgerOne.getGomanufacturerAddress();
			if(gomanufacturerAddress != "" || gomanufacturerAddress != null) {
				c7.setCellValue(gomanufacturerAddress);  //生产厂家地址
			}else {
				c7.setCellValue("");  //生产厂家地址
			}
			
			HSSFCell c8 = row.createCell(7);  
			c8.setCellStyle(style1);
			String contactNumber = equipmentIedgerOne.getContactNumber();
			if(contactNumber != "" || contactNumber != null) {
				c8.setCellValue(contactNumber);  //联系电话
			}else {
				c8.setCellValue("");  //联系电话
			}
			
			HSSFCell c9 = row.createCell(8);  
			c9.setCellStyle(style1);
			String unitModel = equipmentIedgerOne.getUnitModel();
			if(unitModel != "" || unitModel != null) {
				c9.setCellValue(unitModel);  //机组型号
			}else {
				c9.setCellValue("");  //机组型号
			}
			
			HSSFCell c10 = row.createCell(9);  
			c10.setCellStyle(style1);
			String factoryNumber = equipmentIedgerOne.getFactoryNumber();
			if(factoryNumber != "" || factoryNumber != null) {
				c10.setCellValue(factoryNumber);  //出厂编号
			}else {
				c10.setCellValue("");  //出厂编号
			}
			
			HSSFCell c11 = row.createCell(10);  
			c11.setCellStyle(style1);
			String power = equipmentIedgerOne.getPower();
			if(power != "" || power != null) {
				c11.setCellValue(power);  //功率kW
			}else {
				c11.setCellValue("");  //功率kW
			}
			
			HSSFCell c12 = row.createCell(11);  
			c12.setCellStyle(style1);
			Integer voltage = equipmentIedgerOne.getVoltage();
			if(voltage != null) {
				String string = voltage.toString();
				c12.setCellValue(string);  //电压V-
			}else {
				c12.setCellValue("");  //电压V
			}
			
			HSSFCell c13 = row.createCell(12);  
			c13.setCellStyle(style1);
			Integer weight = equipmentIedgerOne.getWeight();
			if(weight != null) {
				String string = weight.toString();
				c13.setCellValue(string);  //重量kg
			}else {
				c13.setCellValue("");  //重量kg
			}
			
			HSSFCell c14 = row.createCell(13);  
			c14.setCellStyle(style1);
			Integer lift = equipmentIedgerOne.getLift();
			if(lift != null) {
				String string = lift.toString();
				c14.setCellValue(string);  //扬程m
			}else {
				c14.setCellValue("");  //扬程m
			}
			
			HSSFCell c15 = row.createCell(14);  
			c15.setCellStyle(style1);
			Integer speed = equipmentIedgerOne.getSpeed();
			if(speed != null) {
				String string = speed.toString();
				c15.setCellValue(string);  //转速r/min
			}else {
				c15.setCellValue("");  //转速r/min
			}
			
			HSSFCell c16 = row.createCell(15);  
			c16.setCellStyle(style1);
			Integer flow = equipmentIedgerOne.getFlow();
			if(flow != null) {
				String string = flow.toString();
				c16.setCellValue(string);  //流量m3/h
			}else {
				c16.setCellValue("");  //流量m3/h
			}
			
			HSSFCell c17 = row.createCell(16);  
			c17.setCellStyle(style1);
			Integer loopNumber = equipmentIedgerOne.getLoopNumber();
			if(loopNumber != null) {
				String string = loopNumber.toString();
				c17.setCellValue(string);  //回路数
			}else {
				c17.setCellValue("");  //回路数
			}
			
			HSSFCell c18 = row.createCell(17);  
			c18.setCellStyle(style1);
			String temperatureRestriction = equipmentIedgerOne.getTemperatureRestriction();
			if(temperatureRestriction != "" || temperatureRestriction != null) {
				c18.setCellValue(temperatureRestriction);  //温度限制℃
			}else {
				c18.setCellValue("");  //温度限制℃
			}
			
			HSSFCell c19 = row.createCell(18);  
			c19.setCellStyle(style1);
			Double capacity = equipmentIedgerOne.getCapacity();	
			if(capacity != null) {
				String string = capacity.toString();
				c19.setCellValue(string);  //容量m3
			}else {
				c19.setCellValue("");  //容量m3
			}
			
			HSSFCell c20 = row.createCell(19);  
			c20.setCellStyle(style1);
			Double electricCurrent = equipmentIedgerOne.getElectricCurrent();
			if( electricCurrent != null) {
				String string = electricCurrent.toString();
				c20.setCellValue(string);  //电流A
			}else {
				c20.setCellValue("");  //电流A
			}
			
			
			HSSFCell c21 = row.createCell(20);  
			c21.setCellStyle(style1);
			String remarks = equipmentIedgerOne.getRemarks();
			if(remarks != "" || remarks != null) {
				c21.setCellValue(remarks);  //备注
			}else {
				c21.setCellValue("");  //备注
			}
			HSSFCell c22 = row.createCell(21);  
			c22.setCellStyle(style1);
			String ifEasyUse = equipmentIedgerOne.getIfEasyUse();
			if(ifEasyUse != "" || ifEasyUse != null) {
				c22.setCellValue(ifEasyUse);  //是否使用
			}else {
				c22.setCellValue("");  //是否使用
			}
			HSSFCell c23 = row.createCell(22);  
			c23.setCellStyle(style1);
			String ifIntact = equipmentIedgerOne.getIfIntact();
			if(ifIntact != "" || ifIntact != null) {
				c23.setCellValue(ifIntact);  //是否完好
			}else {
				c23.setCellValue("");  //是否完好
			}
			HSSFCell c24 = row.createCell(23);  
			c24.setCellStyle(style1);
			String usingState = equipmentIedgerOne.getUsingState();
			if(usingState != "" || usingState != null) {
				c24.setCellValue(usingState);  //设备使用状态
			}else {
				c24.setCellValue("");  //设备使用状态
			}
			HSSFCell c25 = row.createCell(24);  
			c25.setCellStyle(style1);
			String intactState = equipmentIedgerOne.getIntactState();
			if(intactState != "" || intactState != null) {
				c25.setCellValue(intactState);  //设备完好状态
			}else {
				c25.setCellValue("");  //设备完好状态
			}
			HSSFCell c26 = row.createCell(25);  
			c26.setCellStyle(style1);
			String installationUnit = equipmentIedgerOne.getInstallationUnit();
			if(installationUnit != "" || installationUnit != null) {
				c26.setCellValue(installationUnit);  //安装单位
			}else {
				c26.setCellValue("");  //安装单位
			}
			HSSFCell c27 = row.createCell(26);  
			c27.setCellStyle(style1);
			String installContacts = equipmentIedgerOne.getInstallContacts();
			if(installContacts != "" || installContacts != null) {
				c27.setCellValue(installContacts);  //安装联系人
			}else {
				c27.setCellValue("");  //安装联系人
			}
			HSSFCell c28 = row.createCell(27);  
			c28.setCellStyle(style1);
			String contactInformation = equipmentIedgerOne.getContactInformation();
			if(contactInformation != "" || contactInformation != null) {
				c28.setCellValue(contactInformation);  //联系方式
			}else {
				c28.setCellValue("");  //联系方式
			}
			HSSFCell c29 = row.createCell(28);  
			c29.setCellStyle(style1);
			String warrantyTermination = equipmentIedgerOne.getWarrantyTermination();
			if(warrantyTermination != "" || warrantyTermination != null) {
				c29.setCellValue(warrantyTermination);  //保修终止日
			}else {
				c29.setCellValue("");  //保修终止日
			}
			HSSFCell c30 = row.createCell(29);  
			c30.setCellStyle(style1);
			String installTime = equipmentIedgerOne.getInstallTime();
			if(installTime != "" || installTime != null) {
				c30.setCellValue(installTime);  //安装日期
			}else {
				c30.setCellValue("");  //安装日期
			}
			HSSFCell c31 = row.createCell(30);  
			c31.setCellStyle(style1);
			String enableTime = equipmentIedgerOne.getEnableTime();
			if(enableTime != "" || enableTime != null) {
				c31.setCellValue(enableTime);  //启用时间
			}else {
				c31.setCellValue("");  //启用时间
			}
			HSSFCell c32 = row.createCell(31);  
			c32.setCellStyle(style1);
			String handoverTimeType = equipmentIedgerOne.getHandoverTimeType();
			if(handoverTimeType != "" || handoverTimeType != null) {
				c32.setCellValue(handoverTimeType);  //交接时运行状况
			}else {
				c32.setCellValue("");  //交接时运行状况
			}
			
			
		}  
		return workbook;  
	}


    /**
     * 导入Excel
     */
	@Override
	public Integer duquExcel(String destFileName,String regionId,String projectId) {


		FileInputStream fis = null;
		Workbook wookbook = null;
		int flag = 0;

		try {
			// 获取一个绝对地址的流
			fis = new FileInputStream(destFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// 2003版本的excel，用.xls结尾
			wookbook = new HSSFWorkbook(fis);// 得到工作簿

		} catch (Exception ex) {
			// ex.printStackTrace();
			try {
				// 这里需要重新获取流对象，因为前面的异常导致了流的关闭—————————————————————————————加了这一行
				fis = new FileInputStream(destFileName);
				// 2007版本的excel，用.xlsx结尾

				wookbook = new XSSFWorkbook(destFileName);// 得到工作簿
			} catch (IOException e) {
				e.printStackTrace();
				logger.debug("获取Excel失败");
				return 2;
			}
		}

		// 得到一个工作表
		Sheet sheet = wookbook.getSheetAt(0);

		// 获得表头
		Row rowHead = sheet.getRow(0);

		// 根据不同的data放置不同的表头
		Map<Object, Integer> headMap = new HashMap<Object, Integer>();

		// 判断表头是否合格 ------------------------这里看你有多少列
		int physicalNumberOfCells = rowHead.getPhysicalNumberOfCells();
		if (physicalNumberOfCells != 29) {
			System.out.println("表头列数与要导入的数据库不对应");
			logger.debug("表头列数与要导入的数据库不对应");
			return 3;
		}

		try {
			// ----------------这里根据你的表格有多少列
			while (flag < 29) {
				Cell cell = rowHead.getCell(flag);
				if (getRightTypeCell(cell).toString().trim().equals("设备名称")) {
					headMap.put("sbmc", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("安装地址")) {
					headMap.put("ahdz", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("生产厂家")) {
					headMap.put("sccj", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("生产厂家地址")) {
					headMap.put("sccjdz", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("联系电话")) {
					headMap.put("lxdh1", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("机组型号")) {
					headMap.put("jzxh", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("出厂编号")) {
					headMap.put("ccbh", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("功率kW")) {
					headMap.put("gl", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("电压V")) {
					headMap.put("dy", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("重量kg")) {
					headMap.put("zl", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("扬程m")) {
					headMap.put("yc", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("转速r/min")) {
					headMap.put("zs", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("流量m3/h")) {
					headMap.put("ll", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("回路数")) {
					headMap.put("hls", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("温度限制℃")) {
					headMap.put("wdxz", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("容量m3")) {
					headMap.put("rl", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("电流A")) {
					headMap.put("dl", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("备注")) {
					headMap.put("bz", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("是否使用")) {
					headMap.put("sfsy", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("是否完好")) {
					headMap.put("sfwh", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("设备使用状态")) {
					headMap.put("sbsyzt", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("设备完好状态")) {
					headMap.put("sbwhzt", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("安装单位")) {
					headMap.put("azdw", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("安装联系人")) {
					headMap.put("azlxr", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("联系方式")) {
					headMap.put("lxfs2", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("保修终止日")) {
					headMap.put("bxzzr", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("安装日期")) {
					headMap.put("azrq", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("启用时间")) {
					headMap.put("qysj", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("交接时运行状况")) {
					headMap.put("jjsyxzk", flag);
				}
				
				

				flag++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("表头不合规范，请修改后重新导入");
			logger.debug("表头不合规范，请修改后重新导入");
			return 4;
		}


		// 获得数据的总行数
		int totalRowNum = sheet.getLastRowNum();

		// 要获得属性

		String equipmentName = "";  //设备名称
		String installationAddress = "";  //安装地址
		String manufacturer = ""; //生产厂家
		String gomanufacturerAddress = "";  //生产厂家地址
		String contactNumber = "";  //联系电话
		String unitModel = "";  //机组型号
		String factoryNumber = "";  //出厂编号
		String power = ""; //功率kW
		String voltage = ""; //电压V
		String weight = ""; //重量kg
		String lift = ""; //扬程m
		String speed = ""; //转速r/min
		String flow = ""; //流量m3/h
		String loopNumber = ""; //回路数
		String temperatureRestriction = ""; //温度限制℃
		String capacity = ""; //容量m3
		String electricCurrent = ""; //电流A
		String remarks = ""; //备注
		String ifEasyUse = ""; //是否使用
		String ifIntact = ""; //是否完好
		String usingState = ""; //设备使用状态
		String intactState = ""; //设备完好状态
		String installationUnit = ""; //安装单位
		String installContacts = ""; //安装联系人
		String contactInformation = ""; //联系方式
		String warrantyTermination = ""; //保修终止日
		String installTime = ""; //安装日期
		String enableTime = ""; //启用时间
		String handoverTimeType = ""; //交接时运行状况

		if (0 == totalRowNum) {
			System.out.println("Excel内没有数据！");
			logger.debug("Excel内没有数据！");
			return 5;

		}

		Cell cell_1 = null, cell_2 = null, cell_3 = null, cell_4 = null, cell_5 = null, cell_6 = null, cell_7 = null, cell_8 = null,cell_9 = null,
				cell_10 = null,cell_11 = null,cell_12 = null,cell_13 = null,cell_14 = null,cell_15 = null,cell_16 = null,cell_17 = null,cell_18 = null,cell_19 = null,
						cell_20 = null,cell_21 = null,cell_22 = null,cell_23 = null,cell_24 = null,cell_25 = null,cell_26 = null,cell_27 = null,cell_28 = null,cell_29 = null;

		// 获得所有数据
		for (int i = 1; i <= totalRowNum; i++) {
			// 获得第i行对象
			Row row = sheet.getRow(i);

			try {

				cell_1 = row.getCell(headMap.get("sbmc"));
				cell_2 = row.getCell(headMap.get("ahdz"));
				cell_3 = row.getCell(headMap.get("sccj"));
				cell_4 = row.getCell(headMap.get("sccjdz"));
				cell_5 = row.getCell(headMap.get("lxdh1"));
				cell_6 = row.getCell(headMap.get("jzxh"));
				cell_7 = row.getCell(headMap.get("ccbh"));
				cell_8 = row.getCell(headMap.get("gl"));
				cell_9 = row.getCell(headMap.get("dy"));
				cell_10 = row.getCell(headMap.get("zl"));
				cell_11 = row.getCell(headMap.get("yc"));
				cell_12 = row.getCell(headMap.get("zs"));
				cell_13 = row.getCell(headMap.get("ll"));
				cell_14 = row.getCell(headMap.get("hls"));
				cell_15 = row.getCell(headMap.get("wdxz"));
				cell_16 = row.getCell(headMap.get("rl"));
				cell_17 = row.getCell(headMap.get("dl"));
				cell_18 = row.getCell(headMap.get("bz"));
				cell_19 = row.getCell(headMap.get("sfsy"));
				cell_20 = row.getCell(headMap.get("sfwh"));
				cell_21 = row.getCell(headMap.get("sbsyzt"));
				cell_22 = row.getCell(headMap.get("sbwhzt"));
				cell_23 = row.getCell(headMap.get("azdw"));
				cell_24 = row.getCell(headMap.get("azlxr"));
				cell_25 = row.getCell(headMap.get("lxfs2"));
				cell_26 = row.getCell(headMap.get("bxzzr"));
				cell_27 = row.getCell(headMap.get("azrq"));
				cell_28 = row.getCell(headMap.get("qysj"));
				cell_29 = row.getCell(headMap.get("jjsyxzk"));
				
				

				if (cell_2 == null || cell_2.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_2 = cell_1;
				}
				if (cell_3 == null || cell_3.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_3 = cell_1;
				}
				if (cell_4 == null || cell_4.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_4 = cell_1;
				}
				if (cell_5 == null || cell_5.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_5 = cell_1;
				}
				if (cell_6 == null || cell_6.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_6 = cell_1;
				}
				if (cell_7 == null || cell_7.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_7 = cell_1;
				}
				if (cell_8 == null || cell_8.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_8 = cell_1;
				}
				if (cell_9 == null || cell_9.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_9 = cell_1;
				}
				if (cell_10 == null || cell_10.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_10 = cell_1;
				}
				if (cell_11 == null || cell_11.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_11 = cell_1;
				}
				if (cell_12 == null || cell_12.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_12 = cell_1;
				}
				if (cell_13 == null || cell_13.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_13 = cell_1;
				}
				if (cell_14 == null || cell_14.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_14 = cell_1;
				}
				if (cell_15 == null || cell_15.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_15 = cell_1;
				}
				if (cell_16 == null || cell_16.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_16 = cell_1;
				}
				if (cell_17 == null || cell_17.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_17 = cell_1;
				}
				if (cell_18 == null || cell_18.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_18 = cell_1;
				}
				if (cell_19 == null || cell_19.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_19 = cell_1;
				}
				if (cell_20 == null || cell_20.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_20 = cell_1;
				}
				if (cell_21 == null || cell_21.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_21 = cell_1;
				}
				if (cell_22 == null || cell_22.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_22 = cell_1;
				}
				if (cell_23 == null || cell_23.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_23 = cell_1;
				}
				if (cell_24 == null || cell_24.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_24 = cell_1;
				}
				if (cell_25 == null || cell_25.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_25 = cell_1;
				}
				if (cell_26 == null || cell_26.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_26 = cell_1;
				}
				if (cell_27 == null || cell_27.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_27 = cell_1;
				}
				if (cell_28 == null || cell_28.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_28 = cell_1;
				}
				if (cell_29 == null || cell_29.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					cell_29 = cell_1;
				}
				

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("获取单元格错误");
				logger.debug("获取单元格错误");
				return 6;
			}

			try {
				if (cell_1 == null || cell_1.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
					break;
				}
				// 设备名称
				equipmentName = (String) getRightTypeCell(cell_1);
				// 安装地址
				installationAddress = (String) getRightTypeCell(cell_2);
				// 生产厂家
				manufacturer = (String) getRightTypeCell(cell_3);
				// 生产厂家地址
				gomanufacturerAddress = (String) getRightTypeCell(cell_4);
				// 联系电话
				contactNumber = (String) getRightTypeCell(cell_5);
				// 机组型号
				unitModel = (String) getRightTypeCell(cell_6);
				// 出厂编号
				factoryNumber = (String) getRightTypeCell(cell_7);
				// 功率kW
				power = (String) getRightTypeCell(cell_8);
				// 电压V
				voltage = (String) getRightTypeCell(cell_9);
				// 重量kg
				weight = (String) getRightTypeCell(cell_10);
				// 扬程m
				lift = (String) getRightTypeCell(cell_11);
				// 转速r/min
				speed = (String) getRightTypeCell(cell_12);
				// 流量m3/h
				flow = (String) getRightTypeCell(cell_13);
				// 回路数
				loopNumber = (String) getRightTypeCell(cell_14);
				// 温度限制℃
				temperatureRestriction = (String) getRightTypeCell(cell_15);
				// 容量m3
				capacity = (String) getRightTypeCell(cell_16);
				// 电流A
				electricCurrent = (String) getRightTypeCell(cell_17);
				// 备注
				remarks = (String) getRightTypeCell(cell_18);
				// 是否使用
				ifEasyUse = (String) getRightTypeCell(cell_19);
				// 是否完好
				ifIntact = (String) getRightTypeCell(cell_20);
				// 设备使用状态
				usingState = (String) getRightTypeCell(cell_21);
				// 设备完好状态
				intactState = (String) getRightTypeCell(cell_22);
				// 安装单位
				installationUnit = (String) getRightTypeCell(cell_23);
				// 安装联系人
				installContacts = (String) getRightTypeCell(cell_24);
				// 联系方式
				contactInformation = (String) getRightTypeCell(cell_25);
				// 保修终止日
				warrantyTermination = (String) getRightTypeCell(cell_26);
				// 安装日期
				installTime = (String) getRightTypeCell(cell_27);
				// 启用时间
				enableTime = (String) getRightTypeCell(cell_28);
				// 交接时运行状况
				handoverTimeType = (String) getRightTypeCell(cell_29);
				

			} catch (ClassCastException e) {
				e.printStackTrace();
				System.out.println("数据不全是数字或全部是文字!");
				logger.debug("数据不全是数字或全部是文字!");
				return 7;
			}

			
			EquipmentIedger equipmentIedger = new EquipmentIedger();
	
			equipmentIedger.setEquipmentName(equipmentName.trim());  //设备名称
			
			equipmentIedger.setRegionId(regionId);  //区域ID
			
			equipmentIedger.setProjectId(projectId);  //项目ID
			
			if(!installationAddress.trim().equals(equipmentName.trim())) {  //安装地址
				equipmentIedger.setInstallationAddress(installationAddress.trim());
			}else {
				equipmentIedger.setInstallationAddress("");
			}
			if(!manufacturer.trim().equals(equipmentName.trim())) {  //生产厂家
				equipmentIedger.setManufacturer(manufacturer.trim());
			}else {
				equipmentIedger.setManufacturer("");
			}
			if(!gomanufacturerAddress.trim().equals(equipmentName.trim())) {  //生产厂家地址
				equipmentIedger.setGomanufacturerAddress(gomanufacturerAddress.trim());
			}else {
				equipmentIedger.setGomanufacturerAddress("");
			}
			if(!contactNumber.trim().equals(equipmentName.trim())) {  //联系电话
				equipmentIedger.setContactNumber(contactNumber.trim());
			}else {
				equipmentIedger.setContactNumber("");
			}
			if(!unitModel.trim().equals(equipmentName.trim())) {  //机组型号
				equipmentIedger.setUnitModel(unitModel.trim());
			}else {
				equipmentIedger.setUnitModel("");
			}
			if(!factoryNumber.trim().equals(equipmentName.trim())) {  //出厂编号
				equipmentIedger.setFactoryNumber(factoryNumber.trim());
			}else {
				equipmentIedger.setFactoryNumber("");
			}
			if(!power.trim().equals(equipmentName.trim())) {  //功率kW
				equipmentIedger.setPower(power.trim());
			}else {
				equipmentIedger.setPower("");
			}
			if(!voltage.trim().equals(equipmentName.trim())) {  //电压V
				equipmentIedger.setVoltage(Integer.parseInt(voltage.trim()));
			}else {
				equipmentIedger.setVoltage(null);
			}
			if(!weight.trim().equals(equipmentName.trim())) {  //重量kg
				equipmentIedger.setWeight(Integer.parseInt(weight.trim()));
			}else {
				equipmentIedger.setWeight(null);
			}
			if(!lift.trim().equals(equipmentName.trim())) {  //扬程m
				equipmentIedger.setLift(Integer.parseInt(lift.trim()));
			}else {
				equipmentIedger.setLift(null);
			}
			if(!speed.trim().equals(equipmentName.trim())) {  //转速r/min
				equipmentIedger.setSpeed(Integer.parseInt(speed.trim()));
			}else {
				equipmentIedger.setSpeed(null);
			}
			if(!flow.trim().equals(equipmentName.trim())) {  //流量m3/h
				equipmentIedger.setFlow(Integer.parseInt(flow.trim()));
			}else {
				equipmentIedger.setFlow(null);
			}
			if(!loopNumber.trim().equals(equipmentName.trim())) {  //回路数
				equipmentIedger.setLoopNumber(Integer.parseInt(loopNumber.trim()));
			}else {
				equipmentIedger.setLoopNumber(null);
			}
			if(!temperatureRestriction.trim().equals(equipmentName.trim())) {  //温度限制℃
				equipmentIedger.setTemperatureRestriction(temperatureRestriction.trim());
			}else {
				equipmentIedger.setTemperatureRestriction("");
			}
			if(!capacity.trim().equals(equipmentName.trim())) {  //容量m3
				equipmentIedger.setCapacity(Double.parseDouble(capacity.trim()));
			}else {
				equipmentIedger.setCapacity(null);
			}
			if(!electricCurrent.trim().equals(equipmentName.trim())) {  //电流A
				equipmentIedger.setElectricCurrent(Double.parseDouble(electricCurrent.trim()));
			}else {
				equipmentIedger.setElectricCurrent(null);
			}
			if(!remarks.trim().equals(equipmentName.trim())) {  //备注
				equipmentIedger.setRemarks(remarks.trim());
			}else {
				equipmentIedger.setRemarks("");
			}
			if(!ifEasyUse.trim().equals(equipmentName.trim())) {  //是否使用
				equipmentIedger.setIfEasyUse(ifEasyUse.trim());
			}else {
				equipmentIedger.setIfEasyUse("");
			}
			if(!ifIntact.trim().equals(equipmentName.trim())) {  //是否完好
				equipmentIedger.setIfIntact(ifIntact.trim());
			}else {
				equipmentIedger.setIfIntact("");
			}
			if(!usingState.trim().equals(equipmentName.trim())) {  // 设备使用状态
				equipmentIedger.setUsingState(usingState.trim());
			}else {
				equipmentIedger.setUsingState("");
			}
			if(!intactState.trim().equals(equipmentName.trim())) {  //设备完好状态
				equipmentIedger.setIntactState(intactState.trim());
			}else {
				equipmentIedger.setIntactState("");
			}
			if(!installationUnit.trim().equals(equipmentName.trim())) {  //安装单位
				equipmentIedger.setInstallationUnit(installationUnit.trim());
			}else {
				equipmentIedger.setInstallationUnit("");
			}
			if(!installContacts.trim().equals(equipmentName.trim())) {  //安装联系人
				equipmentIedger.setInstallContacts(installContacts.trim());
			}else {
				equipmentIedger.setInstallContacts("");
			}
			if(!contactInformation.trim().equals(equipmentName.trim())) {  //联系方式
				equipmentIedger.setContactInformation(contactInformation.trim());
			}else {
				equipmentIedger.setContactInformation("");
			}
			if(!warrantyTermination.trim().equals(equipmentName.trim())) {  //保修终止日
				equipmentIedger.setWarrantyTermination(warrantyTermination.trim());
			}else {
				equipmentIedger.setWarrantyTermination("");
			}
			if(!installTime.trim().equals(equipmentName.trim())) {  //安装日期
				equipmentIedger.setInstallTime(installTime.trim());
			}else {
				equipmentIedger.setInstallTime("");
			}
			if(!enableTime.trim().equals(equipmentName.trim())) {  //启用时间
				equipmentIedger.setEnableTime(enableTime.trim());
			}else {
				equipmentIedger.setEnableTime("");
			}
			if(!handoverTimeType.trim().equals(equipmentName.trim())) {  //交接时运行状况
				equipmentIedger.setHandoverTimeType(handoverTimeType.trim());
			}else {
				equipmentIedger.setHandoverTimeType("");
			}
			
			
			List<EquipmentIedger> chickName = equipmentIedgerService.chickName(equipmentName.trim());
			if(chickName.size() > 0) {
				return 8;
			}else {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				equipmentIedger.setEquipmentIedgerId(uuid);
				equipmentIedgerService.insert(equipmentIedger);
			}
			

	     }
      
		
		return 0;
	}



	
	
	/**
	 *   Excel 校验格式
	 * @param cell
	 * @return
	 */
	public static Object getRightTypeCell(Cell cell) {

		Object object = null;

		// 把数字当成String来读，避免出现1读成1.0的情况
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING: {
			object = cell.getStringCellValue();
			break;
		}
		case Cell.CELL_TYPE_NUMERIC: {
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			object = cell.getNumericCellValue();
			break;
		}

		case Cell.CELL_TYPE_FORMULA: {
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			object = cell.getNumericCellValue();
			break;
		}

		case Cell.CELL_TYPE_BLANK: {
			cell.setCellType(Cell.CELL_TYPE_BLANK);
			object = cell.getStringCellValue();
			break;
		}
		}
		return object;
	}
	
}
