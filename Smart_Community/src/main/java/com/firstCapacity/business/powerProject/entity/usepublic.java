package com.firstCapacity.business.powerProject.entity;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.firstCapacity.business.StaffInformation.entity.StaffInformation;
import com.firstCapacity.business.TypesettingRecord.entity.TypesettingRecord;
import com.firstCapacity.business.equipmentIedger.entity.EquipmentIedger;
import com.firstCapacity.business.equipmentType.entity.EquipmentType;
import com.firstCapacity.business.powerType.entity.powerType;
import com.firstCapacity.util.Pager;

public class usepublic implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<powerProject> quyu;  //区域
	
	private List<powerProject> probject;  //项目
	
	private List<EquipmentType> shebeiType;  //设备类别
	
	private Pager<EquipmentIedger> equipmentIedgerList;  //设备列表 
	
	private List<powerType> leibie;  //类别
	
	private Pager<powerProject> list;  //列表集合
	
	private List<JSONObject> treeList;  //树集合
	
	private Pager<StaffInformation> StaffInformationList;  //职员信息列表
	
	private Pager<TypesettingRecord> TypesettingRecordList;  //排班记录列表
	
	
	
	
 
	




	public Pager<StaffInformation> getStaffInformationList() {
		return StaffInformationList;
	}

	public void setStaffInformationList(Pager<StaffInformation> staffInformationList) {
		StaffInformationList = staffInformationList;
	}

	public Pager<TypesettingRecord> getTypesettingRecordList() {
		return TypesettingRecordList;
	}

	public void setTypesettingRecordList(Pager<TypesettingRecord> typesettingRecordList) {
		TypesettingRecordList = typesettingRecordList;
	}

	public Pager<EquipmentIedger> getEquipmentIedgerList() {
		return equipmentIedgerList;
	}

	public void setEquipmentIedgerList(Pager<EquipmentIedger> equipmentIedgerList) {
		this.equipmentIedgerList = equipmentIedgerList;
	}

	public List<EquipmentType> getShebeiType() {
		return shebeiType;
	}

	public void setShebeiType(List<EquipmentType> shebeiType) {
		this.shebeiType = shebeiType;
	}

	public List<powerProject> getProbject() {
		return probject;
	}

	public void setProbject(List<powerProject> probject) {
		this.probject = probject;
	}

	public List<JSONObject> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<JSONObject> treeList) {
		this.treeList = treeList;
	}

	public List<powerProject> getQuyu() {
		return quyu;
	}

	public void setQuyu(List<powerProject> quyu) {
		this.quyu = quyu;
	}

	public List<powerType> getLeibie() {
		return leibie;
	}

	public void setLeibie(List<powerType> leibie) {
		this.leibie = leibie;
	}

	public Pager<powerProject> getList() {
		return list;
	}

	public void setList(Pager<powerProject> list) {
		this.list = list;
	}


	
	
	
	
	
	
	
}
