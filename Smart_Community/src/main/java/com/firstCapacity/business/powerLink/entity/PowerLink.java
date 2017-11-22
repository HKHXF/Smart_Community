package com.firstCapacity.business.powerLink.entity;

import java.io.Serializable;

public class PowerLink implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private Integer linkId;  //主键

    private String fieldName;  //字段名称

    private String tableName;  //数据表名称

    private String fieldDecipher;  //字段解释

    private String type;  //类型

    private String equipmentiedgerid;  //设备ID
 
    private String projectId;  //能源项目ID(纽带)
    
    
    
    


    public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hefei.field_name
     *
     * @return the value of hefei.field_name
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hefei.field_name
     *
     * @param fieldName the value for hefei.field_name
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hefei.table_name
     *
     * @return the value of hefei.table_name
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hefei.table_name
     *
     * @param tableName the value for hefei.table_name
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hefei.field_decipher
     *
     * @return the value of hefei.field_decipher
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public String getFieldDecipher() {
        return fieldDecipher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hefei.field_decipher
     *
     * @param fieldDecipher the value for hefei.field_decipher
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public void setFieldDecipher(String fieldDecipher) {
        this.fieldDecipher = fieldDecipher == null ? null : fieldDecipher.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hefei.type
     *
     * @return the value of hefei.type
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hefei.type
     *
     * @param type the value for hefei.type
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hefei.equipmentIedgerId
     *
     * @return the value of hefei.equipmentIedgerId
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public String getEquipmentiedgerid() {
        return equipmentiedgerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hefei.equipmentIedgerId
     *
     * @param equipmentiedgerid the value for hefei.equipmentIedgerId
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public void setEquipmentiedgerid(String equipmentiedgerid) {
        this.equipmentiedgerid = equipmentiedgerid == null ? null : equipmentiedgerid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hefei.project_id
     *
     * @return the value of hefei.project_id
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hefei.project_id
     *
     * @param projectId the value for hefei.project_id
     *
     * @mbg.generated Wed Nov 08 22:08:09 CST 2017
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }
}