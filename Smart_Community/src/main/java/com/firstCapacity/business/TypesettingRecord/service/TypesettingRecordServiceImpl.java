package com.firstCapacity.business.TypesettingRecord.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.firstCapacity.business.TypesettingRecord.entity.TypesettingRecord;
import com.firstCapacity.business.TypesettingRecord.mapper.TypesettingRecordMapper;
import com.firstCapacity.business.powerProject.controller.powerProjectJsonController;
import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.business.user.realm.MyRealm;
import com.firstCapacity.util.json.SpringMVCUtil;

@Transactional
@Service
public class TypesettingRecordServiceImpl implements TypesettingRecordService{
	
	
	private final static Logger logger = LoggerFactory.getLogger(powerProjectJsonController.class);

	@Resource
	private TypesettingRecordMapper TypesettingRecordMapper;
	
	/**
	 * 模糊查询列表
	 */
	@Override
	public List<TypesettingRecord> selectList(TypesettingRecord typesettingRecord) {

		List<TypesettingRecord> selectList = TypesettingRecordMapper.selectList(typesettingRecord);
		for (TypesettingRecord typesettingRecord2 : selectList) {
			 SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
			 Date createTime = typesettingRecord2.getCreateTime();
			 String format = formatter.format(createTime);
			 typesettingRecord2.setCreateTimeNew(format);
		}
		
		return selectList;
	}

	
	/**
	 *  新增排班记录
	 */
	@Override
	public void insert(TypesettingRecord typesettingRecord) {
		String userIdNow = MyRealm.getUserIdNow();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		MultipartFile upFiles = typesettingRecord.getUpFiles();
		String upFilesname = upFiles.getOriginalFilename();
		if(upFiles != null && upFilesname != "" ) {
			String savaFile = savaFile(typesettingRecord);
			typesettingRecord.setFilePath(savaFile);
			typesettingRecord.setTypesettingId(uuid);
			typesettingRecord.setUserId(userIdNow);
			TypesettingRecordMapper.insertSelective(typesettingRecord);
		}else {
			typesettingRecord.setTypesettingId(uuid);
			typesettingRecord.setUserId(userIdNow);
			TypesettingRecordMapper.insertSelective(typesettingRecord);
		}
		
		
		
	}


	/**
	 * 新增时检查名称是否重复
	 */
	@Override
	public List<TypesettingRecord> chickNme(String fileName) {

		List<TypesettingRecord> chickNme = TypesettingRecordMapper.chickNme(fileName);
		return chickNme;
	} 

	
	
	
	
	
	
	/**
	 *  上传文件(排班图片)
	 * @param powerProject
	 * @return  文件路径
	 */
	public String savaFile(TypesettingRecord typesettingRecord) {
			 MultipartFile upFiles = typesettingRecord.getUpFiles();
			 String originalFilename2 = upFiles.getOriginalFilename();
			 
						String originalFilename = originalFilename2;
						String uuid = UUID.randomUUID().toString().replaceAll("-", "");
						String rootPath = SpringMVCUtil.getRequest().getSession().getServletContext().getRealPath("/");
//						if(type == 1) { //修改时删除原文件
//							String projectId = powerProject.getProjectId();
//							powerProject selectByPrimaryKey = powerProjectMapper.selectByPrimaryKey(projectId);
//							String projectImage = selectByPrimaryKey.getProjectImage();
//							File file = new File(rootPath+projectImage);
//							if(file.exists()) {
//								file.delete();
//							}
//						}
						
						String filepath = "/upload/panban/"+uuid+originalFilename;
							String destFileName = rootPath+filepath;
	 						File file = new File(destFileName);
							//判断目标文件所在的目录是否存在  
					        if(!file.getParentFile().exists()) {  
					            //如果目标文件所在的目录不存在，则创建父目录  
					            System.out.println("目标文件所在目录不存在，准备创建它！"); 
					            file.mkdirs();
					            logger.debug("新建文件成功");
					        }  
					        try {
								file.createNewFile();// 创建文件函数
								upFiles.transferTo(file); 
								
							} catch (Exception e) {
								e.printStackTrace();
							}
			 return filepath;

	}
	
	
	
	
	
	
	/**
	 * 根据ID查询详情
	 */
	public TypesettingRecord selectOne(String typesettingId) {
		
		TypesettingRecord selectByPrimaryKey = TypesettingRecordMapper.selectByPrimaryKey(typesettingId);
		
		return selectByPrimaryKey;
	}


	
	
	/**
	 *   根据ID删除盘版信息
	 */
	@Override
	public void delete(String typesettingId) {
		String rootPath = SpringMVCUtil.getRequest().getSession().getServletContext().getRealPath("/");
		
		TypesettingRecord selectByPrimaryKey = TypesettingRecordMapper.selectByPrimaryKey(typesettingId);
		String projectImage = selectByPrimaryKey.getFilePath();
		if(projectImage != null && projectImage != "") {
			File file = new File(rootPath+projectImage);//删除原文件
			if(file.exists()) {
				file.delete();
			}
		}
		TypesettingRecordMapper.deleteByPrimaryKey(typesettingId);
		
	}
	
	
	
	
}
