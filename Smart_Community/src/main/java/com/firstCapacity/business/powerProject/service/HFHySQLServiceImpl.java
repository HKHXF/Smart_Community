package com.firstCapacity.business.powerProject.service;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.firstCapacity.business.HeFeiPower.entity.HF_hy_01;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_02;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_03;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_04;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_05;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_06;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_07;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_08;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_09;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_10;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_11;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_12;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_13;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_14;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_15;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_16;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_17;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_18;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_19;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_20;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_21;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_22;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_23;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_25;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_26;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_27;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_28;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_29;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_01Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_02Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_03Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_04Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_05Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_06Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_07Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_08Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_09Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_10Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_11Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_12Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_13Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_14Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_15Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_16Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_17Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_18Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_19Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_20Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_21Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_22Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_23Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_25Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_26Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_27Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_28Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_29Mapper;


@Service
public class HFHySQLServiceImpl implements HFHySQLService{
	
	@Resource
	private HF_hy_01Mapper hF_hy_01Mapper;
	@Resource
	private HF_hy_02Mapper hF_hy_02Mapper;
	@Resource
	private HF_hy_03Mapper hF_hy_03Mapper;
	@Resource
	private HF_hy_04Mapper hF_hy_04Mapper;
	@Resource
	private HF_hy_05Mapper hF_hy_05Mapper;
	@Resource
	private HF_hy_06Mapper hF_hy_06Mapper;
	@Resource
	private HF_hy_07Mapper hF_hy_07Mapper;
	@Resource
	private HF_hy_08Mapper hF_hy_08Mapper;
	@Resource
	private HF_hy_09Mapper hF_hy_09Mapper;
	@Resource
	private HF_hy_10Mapper hF_hy_10Mapper;
	@Resource
	private HF_hy_11Mapper hF_hy_11Mapper;
	@Resource
	private HF_hy_12Mapper hF_hy_12Mapper;
	@Resource
	private HF_hy_13Mapper hF_hy_13Mapper;
	@Resource
	private HF_hy_14Mapper hF_hy_14Mapper;
	@Resource
	private HF_hy_15Mapper hF_hy_15Mapper;
	@Resource
	private HF_hy_16Mapper hF_hy_16Mapper;
	@Resource
	private HF_hy_17Mapper hF_hy_17Mapper;
	@Resource
	private HF_hy_18Mapper hF_hy_18Mapper;
	@Resource
	private HF_hy_19Mapper hF_hy_19Mapper;
	@Resource
	private HF_hy_20Mapper hF_hy_20Mapper;
	@Resource
	private HF_hy_21Mapper hF_hy_21Mapper;
	@Resource
	private HF_hy_22Mapper hF_hy_22Mapper;
	@Resource
	private HF_hy_23Mapper hF_hy_23Mapper;
	@Resource
	private HF_hy_25Mapper hF_hy_25Mapper;
	@Resource
	private HF_hy_26Mapper hF_hy_26Mapper;
	@Resource
	private HF_hy_27Mapper hF_hy_27Mapper;
	@Resource
	private HF_hy_28Mapper hF_hy_28Mapper;
	@Resource
	private HF_hy_29Mapper hF_hy_29Mapper;
	
	
	
	
	private final static Logger logger = LoggerFactory.getLogger(HFHySQLServiceImpl.class);

	@Override
	public List<Object> SelectListOn(String table,String startTime,String endTime) {
		List<Object> selectListOn = new ArrayList<Object>();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String startTimeDate = "";
		String endTimeDate = "";
		if(startTime.equals("1") || startTime == "1") {
			int parseInt = Integer.parseInt(endTime);
			Long q = (long) (3600000*parseInt); //小时换算毫秒
			long time = date.getTime();
			long timeNew = time-q;
			Date dateq = new Date(timeNew);
			startTimeDate = sf.format(dateq);
			endTimeDate = sf.format(date);
			
		}else {
//			Date parse = sf.parse(startTime);
			startTimeDate = startTime;
			endTimeDate = endTime;
		}
		logger.debug("开始时间：==========》"+startTimeDate);
		logger.debug("结束时间：==========》"+endTimeDate);
		
		if(table.equals("HF_hy_01")) {
			HF_hy_01 HF_hy_01 = new HF_hy_01();
			HF_hy_01.setStartTime(startTimeDate);
			HF_hy_01.setEndTime(endTimeDate);
			selectListOn = hF_hy_01Mapper.SelectListOn(HF_hy_01);
		}else if(table.equals("HF_hy_02")) {
			HF_hy_02 HF_hy_02 = new HF_hy_02();
			HF_hy_02.setStartTime(startTimeDate);
			HF_hy_02.setEndTime(endTimeDate);
			selectListOn = hF_hy_02Mapper.SelectListOn(HF_hy_02);
		}else if(table.equals("HF_hy_03")){
			HF_hy_03 HF_hy_03 = new HF_hy_03();
			HF_hy_03.setStartTime(startTimeDate);
			HF_hy_03.setEndTime(endTimeDate);
			selectListOn = hF_hy_03Mapper.SelectListOn(HF_hy_03);
		}else if(table.equals("HF_hy_04")){
			HF_hy_04 HF_hy_04 = new HF_hy_04();
			HF_hy_04.setStartTime(startTimeDate);
			HF_hy_04.setEndTime(endTimeDate);
			selectListOn = hF_hy_04Mapper.SelectListOn(HF_hy_04);
		}else if(table.equals("HF_hy_05")){
			HF_hy_05 HF_hy_05 = new HF_hy_05();
			HF_hy_05.setStartTime(startTimeDate);
			HF_hy_05.setEndTime(endTimeDate);
			selectListOn = hF_hy_05Mapper.SelectListOn(HF_hy_05);
		}else if(table.equals("HF_hy_06")){
			HF_hy_06 HF_hy_06 = new HF_hy_06();
			HF_hy_06.setStartTime(startTimeDate);
			HF_hy_06.setEndTime(endTimeDate);
			selectListOn = hF_hy_06Mapper.SelectListOn(HF_hy_06);
		}else if(table.equals("HF_hy_07")){
			HF_hy_07 HF_hy_07 = new HF_hy_07();
			HF_hy_07.setStartTime(startTimeDate);
			HF_hy_07.setEndTime(endTimeDate);
			selectListOn = hF_hy_07Mapper.SelectListOn(HF_hy_07);
		}else if(table.equals("HF_hy_08")){
			HF_hy_08 HF_hy_08 = new HF_hy_08();
			HF_hy_08.setStartTime(startTimeDate);
			HF_hy_08.setEndTime(endTimeDate);
			selectListOn = hF_hy_08Mapper.SelectListOn(HF_hy_08);
		}else if(table.equals("HF_hy_09")){
			HF_hy_09 HF_hy_09 = new HF_hy_09();
			HF_hy_09.setStartTime(startTimeDate);
			HF_hy_09.setEndTime(endTimeDate);
			selectListOn = hF_hy_09Mapper.SelectListOn(HF_hy_09);
		}else if(table.equals("HF_hy_10")){
			HF_hy_10 HF_hy_10 = new HF_hy_10();
			HF_hy_10.setStartTime(startTimeDate);
			HF_hy_10.setEndTime(endTimeDate);
			selectListOn = hF_hy_10Mapper.SelectListOn(HF_hy_10);
		}else if(table.equals("HF_hy_11")){
			HF_hy_11 HF_hy_11 = new HF_hy_11();
			HF_hy_11.setStartTime(startTimeDate);
			HF_hy_11.setEndTime(endTimeDate);
			selectListOn = hF_hy_11Mapper.SelectListOn(HF_hy_11);
		}else if(table.equals("HF_hy_12")){
			HF_hy_12 HF_hy_12 = new HF_hy_12();
			HF_hy_12.setStartTime(startTimeDate);
			HF_hy_12.setEndTime(endTimeDate);
			selectListOn = hF_hy_12Mapper.SelectListOn(HF_hy_12);
		}else if(table.equals("HF_hy_13")){
			HF_hy_13 HF_hy_13 = new HF_hy_13();
			HF_hy_13.setStartTime(startTimeDate);
			HF_hy_13.setEndTime(endTimeDate);
			selectListOn = hF_hy_13Mapper.SelectListOn(HF_hy_13);
		}else if(table.equals("HF_hy_14")){
			HF_hy_14 HF_hy_14 = new HF_hy_14();
			HF_hy_14.setStartTime(startTimeDate);
			HF_hy_14.setEndTime(endTimeDate);
			selectListOn = hF_hy_14Mapper.SelectListOn(HF_hy_14);
		}else if(table.equals("HF_hy_15")){
			HF_hy_15 HF_hy_15 = new HF_hy_15();
			HF_hy_15.setStartTime(startTimeDate);
			HF_hy_15.setEndTime(endTimeDate);
			selectListOn = hF_hy_15Mapper.SelectListOn(HF_hy_15);
		}else if(table.equals("HF_hy_16")){
			HF_hy_16 HF_hy_16 = new HF_hy_16();
			HF_hy_16.setStartTime(startTimeDate);
			HF_hy_16.setEndTime(endTimeDate);
			selectListOn = hF_hy_16Mapper.SelectListOn(HF_hy_16);
		}else if(table.equals("HF_hy_17")){
			HF_hy_17 HF_hy_17 = new HF_hy_17();
			HF_hy_17.setStartTime(startTimeDate);
			HF_hy_17.setEndTime(endTimeDate);
			selectListOn = hF_hy_17Mapper.SelectListOn(HF_hy_17);
		}else if(table.equals("HF_hy_18")){
			HF_hy_18 HF_hy_18 = new HF_hy_18();
			HF_hy_18.setStartTime(startTimeDate);
			HF_hy_18.setEndTime(endTimeDate);
			selectListOn = hF_hy_18Mapper.SelectListOn(HF_hy_18);
		}else if(table.equals("HF_hy_19")){
			HF_hy_19 HF_hy_19 = new HF_hy_19();
			HF_hy_19.setStartTime(startTimeDate);
			HF_hy_19.setEndTime(endTimeDate);
			selectListOn = hF_hy_19Mapper.SelectListOn(HF_hy_19);
		}else if(table.equals("HF_hy_20")){
			HF_hy_20 HF_hy_20 = new HF_hy_20();
			HF_hy_20.setStartTime(startTimeDate);
			HF_hy_20.setEndTime(endTimeDate);
			selectListOn = hF_hy_20Mapper.SelectListOn(HF_hy_20);
		}else if(table.equals("HF_hy_21")){
			HF_hy_21 HF_hy_21 = new HF_hy_21();
			HF_hy_21.setStartTime(startTimeDate);
			HF_hy_21.setEndTime(endTimeDate);
			selectListOn = hF_hy_21Mapper.SelectListOn(HF_hy_21);
		}else if(table.equals("HF_hy_22")){
			HF_hy_22 HF_hy_22 = new HF_hy_22();
			HF_hy_22.setStartTime(startTimeDate);
			HF_hy_22.setEndTime(endTimeDate);
			selectListOn = hF_hy_22Mapper.SelectListOn(HF_hy_22);
		}else if(table.equals("HF_hy_23")){
			HF_hy_23 HF_hy_23 = new HF_hy_23();
			HF_hy_23.setStartTime(startTimeDate);
			HF_hy_23.setEndTime(endTimeDate);
			selectListOn = hF_hy_23Mapper.SelectListOn(HF_hy_23);
		}else if(table.equals("HF_hy_25")){
			HF_hy_25 HF_hy_25 = new HF_hy_25();
			HF_hy_25.setStartTime(startTimeDate);
			HF_hy_25.setEndTime(endTimeDate);
			selectListOn = hF_hy_25Mapper.SelectListOn(HF_hy_25);
		}else if(table.equals("HF_hy_26")){
			HF_hy_26 HF_hy_26 = new HF_hy_26();
			HF_hy_26.setStartTime(startTimeDate);
			HF_hy_26.setEndTime(endTimeDate);
			selectListOn = hF_hy_26Mapper.SelectListOn(HF_hy_26);
		}else if(table.equals("HF_hy_27")){
			HF_hy_27 HF_hy_27 = new HF_hy_27();
			HF_hy_27.setStartTime(startTimeDate);
			HF_hy_27.setEndTime(endTimeDate);
			selectListOn = hF_hy_27Mapper.SelectListOn(HF_hy_27);
		}else if(table.equals("HF_hy_28")){
			HF_hy_28 HF_hy_28 = new HF_hy_28();
			HF_hy_28.setStartTime(startTimeDate);
			HF_hy_28.setEndTime(endTimeDate);
			selectListOn = hF_hy_28Mapper.SelectListOn(HF_hy_28);
		}else if(table.equals("HF_hy_29")){
			HF_hy_29 HF_hy_29 = new HF_hy_29();
			HF_hy_29.setStartTime(startTimeDate);
			HF_hy_29.setEndTime(endTimeDate);
			selectListOn = hF_hy_29Mapper.SelectListOn(HF_hy_29);
		}
		
		
		return selectListOn;
	} 

	
	
	
	
}
