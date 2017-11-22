package com.firstCapacity.business.powerProject.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.firstCapacity.business.powerProject.entity.powerProject;

public interface powerProjectExcelService {

    //导出Excel文件
    public HSSFWorkbook createExcel(powerProject powerProject,Integer page);
}
