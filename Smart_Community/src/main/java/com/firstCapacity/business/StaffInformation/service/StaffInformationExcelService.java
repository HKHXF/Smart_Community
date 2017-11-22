package com.firstCapacity.business.StaffInformation.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.firstCapacity.business.StaffInformation.entity.StaffInformation;

public interface StaffInformationExcelService {


    //导出Excel文件
    public HSSFWorkbook createExcel(StaffInformation staffInformation);
}
