package com.firstCapacity.business.powerLink.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.powerLink.entity.PowerLink;
import com.firstCapacity.business.powerLink.mapper.PowerLinkMapper;

@Transactional
@Service
public class PowerLinkExcelServiceImpl implements PowerLinkExcelService{

	private final static Logger logger = LoggerFactory.getLogger(PowerLinkExcelServiceImpl.class); 
	
	@Resource
	private PowerLinkMapper powerLinkMapper;
	
	
	


    /**
     * 导入Excel
     */
	@Override
	public Integer duquExcel(String destFileName) {


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
		if (physicalNumberOfCells != 5) {
			System.out.println("表头列数与要导入的数据库不对应");
			logger.debug("表头列数与要导入的数据库不对应");
			return 3;
		}

		try {
			// ----------------这里根据你的表格有多少列
			while (flag < 5) {
				Cell cell = rowHead.getCell(flag);
				if (getRightTypeCell(cell).toString().trim().equals("字段名称")) {
					headMap.put("zdmc", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("数据表名称")) {
					headMap.put("sjbmc", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("字段解释")) {
					headMap.put("zdjs", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("类型")) {
					headMap.put("lx", flag);
				}
				if (getRightTypeCell(cell).toString().trim().equals("设备ID")) {
					headMap.put("sbid", flag);
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

		String fieldName = "";  //字段名称
		String tableName = "";  //数据表名称
		String fieldDecipher = ""; //字段解释
		String type = "";  //类型
		String equipmentiedgerid = "";  //设备ID

		if (0 == totalRowNum) {
			System.out.println("Excel内没有数据！");
			logger.debug("Excel内没有数据！");
			return 5;

		}

		Cell cell_1 = null, cell_2 = null, cell_3 = null, cell_4 = null, cell_5 = null;

		// 获得所有数据
		for (int i = 1; i <= totalRowNum; i++) {
			// 获得第i行对象
			Row row = sheet.getRow(i);

			try {

				cell_1 = row.getCell(headMap.get("zdmc"));
				cell_2 = row.getCell(headMap.get("sjbmc"));
				cell_3 = row.getCell(headMap.get("zdjs"));
				cell_4 = row.getCell(headMap.get("lx"));
				cell_5 = row.getCell(headMap.get("sbid"));
				
				

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
				// 字段名称
				fieldName = (String) getRightTypeCell(cell_1);
				// 数据表名称
				tableName = (String) getRightTypeCell(cell_2);
				// 字段解释
				fieldDecipher = (String) getRightTypeCell(cell_3);
				// 类型
				type = (String) getRightTypeCell(cell_4);
				// 设备ID
				equipmentiedgerid = (String) getRightTypeCell(cell_5);
				

			} catch (ClassCastException e) {
				e.printStackTrace();
				System.out.println("数据不全是数字或全部是文字!");
				logger.debug("数据不全是数字或全部是文字!");
				return 7;
			}

			
			PowerLink powerLink = new PowerLink();
	
			powerLink.setFieldName(fieldName.trim());
			powerLink.setTableName(tableName.trim());
			powerLink.setFieldDecipher(fieldDecipher.trim());
			powerLink.setType(type.trim());
			powerLink.setEquipmentiedgerid(equipmentiedgerid.trim());
			powerLink.setProjectId("666d1c6a065440daa3f059b40dc6d3d7");
			powerLinkMapper.insertSelective(powerLink);
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
