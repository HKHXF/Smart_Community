package com.firstCapacity.business.equipmentIedger.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.firstCapacity.business.equipmentIedger.entity.EquipmentIedger;

public interface EquipmentIedgerExcelService {

    //导出Excel文件
    public HSSFWorkbook createExcel(EquipmentIedger equipmentIedger);
    
    //读取Excel
    public Integer duquExcel(String destFileName,String regionId,String projectId);
}
