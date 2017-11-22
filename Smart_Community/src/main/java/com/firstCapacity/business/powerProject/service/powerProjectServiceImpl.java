package com.firstCapacity.business.powerProject.service;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_30;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_31;
import com.firstCapacity.business.HeFeiPower.entity.HF_hy_32;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_30Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_31Mapper;
import com.firstCapacity.business.HeFeiPower.mapper.HF_hy_32Mapper;
import com.firstCapacity.business.equipmentType.entity.EquipmentType;
import com.firstCapacity.business.equipmentType.mapper.EquipmentTypeMapper;
import com.firstCapacity.business.powerProject.entity.HFHySQL;
import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.business.powerProject.entity.usepublic;
import com.firstCapacity.business.powerProject.mapper.HFHySQLMapper;
import com.firstCapacity.business.powerProject.mapper.powerMapper;
import com.firstCapacity.business.powerProject.mapper.powerProjectMapper;
import com.firstCapacity.business.powerType.entity.powerType;
import com.firstCapacity.business.powerType.mapper.powerTypeMapper;
import com.firstCapacity.util.json.SpringMVCUtil;

@Service
public class powerProjectServiceImpl implements powerProjectService{
	
	
	private final static Logger logger = LoggerFactory.getLogger(powerProjectServiceImpl.class); 

	@Resource
	private powerProjectMapper powerProjectMapper;
	@Resource
	private powerTypeMapper powerTypeMapper;
	@Resource
	private EquipmentTypeMapper equipmentTypeMapper;
	@Resource
	private HF_hy_30Mapper hF_hy_30mapper;
	@Resource
	private HF_hy_31Mapper hF_hy_31mapper;
	@Resource
	private powerMapper powerMapper;
	@Resource
	private HF_hy_32Mapper hF_hy_32mapper;
	@Resource
	private HFHySQLMapper hFHySQLMapper;
	
	
	/**
	 * 新增项目
	 */
	@Override
	public void imsert(powerProject powerProject) {
		
		if(powerProject.getUpFiles() == null) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			powerProject.setProjectId(uuid);
			powerProjectMapper.insertSelective(powerProject);
		}else {
			String savaFile = savaFile(powerProject,0); //文件路径
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			powerProject.setProjectId(uuid);
			powerProject.setProjectImage(savaFile);
			powerProjectMapper.insertSelective(powerProject);
		}
	
	}

	
	/**
	 * 新增时校验是否已存在
	 */
	@Override
	public List<powerProject> chickOne(String projectName) {
		List<powerProject> chickOne = powerProjectMapper.chickOne(projectName);
		
		return chickOne;
	}


	/**
	 * 修改项目
	 */
	@Override
	public void update(powerProject powerProject) {
		MultipartFile upFiles = powerProject.getUpFiles();
		 String originalFilename2 = upFiles.getOriginalFilename();
		if(upFiles == null || originalFilename2 == null || originalFilename2 == "") {
			powerProjectMapper.updateByPrimaryKeySelective(powerProject);
		}else {
			String savaFile = savaFile(powerProject,1); //文件路径
			powerProject.setProjectImage(savaFile);
			powerProjectMapper.updateByPrimaryKeySelective(powerProject);
		}
		
		
	}


	
	
	
	/**
	 * 级联删除区或项目
	 */
	public void delete(String projectId) {
		List<powerProject> selectPid = powerProjectMapper.selectPid(projectId);
		if(selectPid != null && selectPid.size() > 0) {
			for (powerProject powerProject : selectPid) {
				
				String projectId2 = powerProject.getProjectId(); //查询实体下的子集ID
				powerProjectMapper.deleteByPrimaryKey(projectId2);  //删除
				delete(projectId2);
			}
		}
		powerProjectMapper.deleteByPrimaryKey(projectId);  //删除
	}
	
	


	/**
	 * 项目详情
	 */
	@Override
	public powerProject selectOne(String projectId) {
		powerProject selectOne = powerProjectMapper.selectOne(projectId);
		if(selectOne != null) {  //查询父级名称
			String projectPid = selectOne.getProjectPid();
			powerProject selectByPrimaryKey = powerProjectMapper.selectByPrimaryKey(projectPid);
			String projectName = selectByPrimaryKey.getProjectName();
			selectOne.setProName(projectName);
		}
		return selectOne;
	}


	/**
	 * 查询组织结构树
	 */
	@Override
	public usepublic queryListAll() {
		List<powerProject> queryListAll = powerProjectMapper.queryListAll();
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		 for (powerProject powerProject : queryListAll) {
			 JSONObject json = new JSONObject();
			 
			 json.put("id", powerProject.getProjectId());
			 json.put("pId", powerProject.getProjectPid());
			 json.put("name", powerProject.getProjectName());
			 json.put("open", false);
			 jsonList.add(json);
		}
		
		List<powerProject> selectQuyu = powerProjectMapper.selectQuyu();  //所有的区域
		List<powerType> selectList = powerTypeMapper.selectList();  //所有类别
		usepublic useInsert = new usepublic();
		useInsert.setLeibie(selectList);
		useInsert.setQuyu(selectQuyu);
		useInsert.setTreeList(jsonList);
		return useInsert;
	}


	/**
	 * 查询所有区域
	 */
	@Override
	public usepublic selectQuyu() {
		
		usepublic useInsert = null;
		try {
			List<powerProject> selectQuyu = powerProjectMapper.selectQuyu();  //所有的区域
			List<powerType> selectList = powerTypeMapper.selectList();  //所有类别
			useInsert = new usepublic();
			useInsert.setQuyu(selectQuyu);
			useInsert.setLeibie(selectList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return useInsert;
		
		
	}
	


	/**
	 *  模糊查询所有列表
	 */
	@Override
	public List<powerProject> selectqueryList(powerProject recor) {
		List<powerProject> selectqueryList = powerProjectMapper.selectqueryList(recor);
		for (powerProject powerProject : selectqueryList) {
			String projectPid = powerProject.getProjectPid();
			powerProject selectByPrimaryKey = powerProjectMapper.selectByPrimaryKey(projectPid);
			String projectName = selectByPrimaryKey.getProjectName();
			powerProject.setProName(projectName);
		}
		return selectqueryList;
	}


	/**
	 * 查询所有区域
	 */
	@Override
	public List<powerProject> qyuryQuyu() {
		List<powerProject> selectQuyu = powerProjectMapper.selectQuyu();  //所有的区域
		return selectQuyu;
	}

	
	

	/**
	 *  上传文件(项目图片)
	 * @param powerProject
	 * @return  文件路径
	 */
	public String savaFile(powerProject powerProject,Integer type) {
			 MultipartFile upFiles = powerProject.getUpFiles();
			 String originalFilename2 = upFiles.getOriginalFilename();
			 
						String originalFilename = originalFilename2;
						String uuid = UUID.randomUUID().toString().replaceAll("-", "");
						String rootPath = SpringMVCUtil.getRequest().getSession().getServletContext().getRealPath("/");
						if(type == 1) { //修改时删除原文件
							String projectId = powerProject.getProjectId();
							powerProject selectByPrimaryKey = powerProjectMapper.selectByPrimaryKey(projectId);
							String projectImage = selectByPrimaryKey.getProjectImage();
							File file = new File(rootPath+projectImage);
							if(file.exists()) {
								file.delete();
							}
						}
						
						String filepath = "/upload/powerProject/"+uuid+originalFilename;
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
	 *  查询区域和项目和设备类别
	 */
	@Override
	public usepublic selectQuyuAndProbject() {

		usepublic usepublic = null;
		try {
			List<powerProject> selectQuyu = powerProjectMapper.selectQuyu();  //所有的区域
			List<powerProject> selectProject = powerProjectMapper.selectProject(); //所有项目
			List<EquipmentType> selectAll = equipmentTypeMapper.selectAll(); //所有设备类别
			usepublic = new usepublic();
			usepublic.setProbject(selectProject);
			usepublic.setQuyu(selectQuyu);
			usepublic.setShebeiType(selectAll);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("查询区域和项目失败");
		}
		
		return usepublic;
	}
	
	
	
	
	
	
	
	
	/**
	 *  查询区域和项目和设备类别
	 */
	@Override
	public usepublic quyuProbject() {

		usepublic usepublic = null;
		try {
			List<powerProject> selectQuyu = powerProjectMapper.selectQuyu();  //所有的区域
			List<powerProject> selectProject = powerProjectMapper.selectProject(); //所有项目
			usepublic = new usepublic();
			usepublic.setProbject(selectProject);
			usepublic.setQuyu(selectQuyu);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("查询区域和项目失败");
		}
		
		return usepublic;
	}


	
	/**
	 * 按照区域ID查询项目列表
	 */
	@Override
	public List<powerProject> selectProbjectByQuyu(String projectId) {

		List<powerProject> selectProbjectByQuyu = powerProjectMapper.selectProbjectByQuyu(projectId);
		
		return selectProbjectByQuyu;
	}


	
	/**
	 *  按照项目ID查询区域
	 */
	@Override
	public powerProject selectQuyuByProject(String projectId) {

		powerProject selectByPrimaryKey = powerProjectMapper.selectByPrimaryKey(projectId);
		String projectPid = selectByPrimaryKey.getProjectPid();
		powerProject selectByPrimaryKey2 = powerProjectMapper.selectByPrimaryKey(projectPid);
		
		return selectByPrimaryKey2;
	}


	
	/**
	 * 系统运行
	 */
	@Override
	public powerProject xitong(String projectId) {

		powerProject selectByPrimaryKey = powerProjectMapper.selectByPrimaryKey(projectId);
		String projectName = selectByPrimaryKey.getProjectName();
		String tianqi = projectName.substring(0, 2);  
		selectByPrimaryKey.setTianqi(tianqi);
		return selectByPrimaryKey;
		
	}


	/**
	 * 系统运行（大接口全部）
	 */
	@Override
	public Object xitongyinxingAll(String path,String tableName,String projectId) {

		Object object = null;
		File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                logger.debug(fs.getName() + " [目录]");
            } else {
                
                String mapper = StringUtils.substringBefore(fs.getName(), ".class");
                if(tableName.equals(mapper) && tableName.equals("HF_hy_30")) {

                	List<HF_hy_31> selectOne3 = hF_hy_31mapper.selectOne3();
                	HF_hy_31 select1 = selectOne3.get(0); //第一条
                	HF_hy_31 select3 = selectOne3.get(2); //第三条
                	
                	//当前负荷
                	Float l1FhDq = select1.getL1FhDq();
                	Float l1FhXf = select1.getL1FhXf();
                	Float fuheNow = l1FhDq + l1FhXf;
                	BigDecimal aa = new BigDecimal(fuheNow); 
                	Float fuheNowDate = aa.setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
                	
                	//同比上小时负荷
                	Float l1FhDq2 = select3.getL1FhDq();
                	Float l1FhXf2 = select3.getL1FhXf();
                	Float fuheShang = l1FhDq2 + l1FhXf2;
                	BigDecimal bb = new BigDecimal(fuheShang); 
                	Float fuheShangDate = bb.setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
                	
                	//同比上小时百分比
                	Float last = fuheNow - fuheShang;
                	Float lastDate = 0f;
                	if(fuheShang != 0) {
                		Float end = last/fuheShang*100;
                		BigDecimal cc = new BigDecimal(end); 
                		lastDate = cc.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                	}
                	
                	
                	
                	HF_hy_30 selectOne = hF_hy_30mapper.selectOne();
                	powerProject selectByPrimaryKey = powerProjectMapper.selectByPrimaryKey(projectId);
                	double chargingArea = selectByPrimaryKey.getChargingArea();
                	String runningTime = selectByPrimaryKey.getRunningTime();
                	Float a = (float)chargingArea;
                	
                	//低区天棚负荷
                	Float l1Tt01 = selectOne.getL1Tt01();//低区天棚分水器温度=TT-01
                	Float l1Tt02 = selectOne.getL1Tt02();//低区天棚集水器温度=TT-02
                	Float l1Ft01 = selectOne.getL1Ft01();//低区天棚系统流量=FT-01
                	Float LoadDQTPNew = (float)1.163*(l1Tt01-l1Tt02)*l1Ft01;
                	BigDecimal b1 = new BigDecimal(LoadDQTPNew); 
                	Float LoadDQTP = b1.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
                	
                	//高区天棚加新风负荷
                	Float l1Tt03 = selectOne.getL1Tt03();//新风分水器温度=TT-03
                	Float l1Tt04 = selectOne.getL1Tt04();//新风集水器温度=TT-04
                	Float l1Ft02 = selectOne.getL1Ft02();//新风系统流量=FT-02
                	Float LoadGQXFNew = (float)1.163*(l1Tt03-l1Tt04)*l1Ft02;
                	BigDecimal b2 = new BigDecimal(LoadGQXFNew); 
                	Float LoadGQXF = b2.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
                	//系统总负荷
                	Float Load_total1 = LoadDQTPNew+LoadGQXFNew;
                	BigDecimal b3 = new BigDecimal(Load_total1); 
                	Float Load_total = b3.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
                	
                	//单位平米负荷
                	if(a != 0) {
                		Float b = Load_total/a*1000;
                    	BigDecimal b4 = new BigDecimal(b); 
                    	Float sssa = b4.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
                		selectOne.setLoadAvg(sssa);
                	}else {
                		selectOne.setLoadAvg(null);
                	}
                	
                	
                	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                	Date time = selectOne.getTime();
                	String format = sf.format(time);
                	selectOne.setTimeGo(format);
                	selectOne.setAreaHVAC(chargingArea);
                	selectOne.setLoadDQTP(LoadDQTP);
                	selectOne.setLoadGQXF(LoadGQXF);
                	selectOne.setLoadTotal(Load_total);
                	selectOne.setFuheNow(fuheNowDate);
                	selectOne.setFuheLast(fuheShangDate);
                	selectOne.setFuheLastBai(lastDate);
                	selectOne.setRunningTime(runningTime);
                	
                	object=selectOne;
                }
            }
        }
        
		return object;
	}


	
	//查询一个时间段内的数据
	@Override
	public List<Object> selectListTime() {
		
		List<Object> qutList = new ArrayList<Object>();
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Long q = (long) (259200000); //3天
		long time = date.getTime();
		long timeNew = time-q;
		Date dateq = new Date(timeNew);  
		String format = sf.format(date);  //当前时间
		logger.debug("当前时间=========》》》"+format);
		String format2 = sf.format(dateq); //3天前的时间
		logger.debug("当前时间=========》》》"+format2);
		HF_hy_31 hF_hy_31 = new HF_hy_31();
		hF_hy_31.setTime1(format2);
		hF_hy_31.setTime2(format);
		List<HF_hy_31> selectListZong = hF_hy_31mapper.selectListZong(hF_hy_31);
		
		for (HF_hy_31 hf_hy_312 : selectListZong) {
			
			Float l1FhDq = hf_hy_312.getL1FhDq();
			Float l1FhXf = hf_hy_312.getL1FhXf();
			Float Load_total = l1FhDq+l1FhXf;
	    	
	    	SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    	Date time2 = hf_hy_312.getTime();
	    	String format3 = sfm.format(time2);
	    	HF_hy_31 hf_hy_31 = new HF_hy_31();
	    	hf_hy_31.setLoadTotal(Load_total);
	    	hf_hy_31.setTimeGo(format3);
	    	qutList.add(hf_hy_31);
			
		}
		return qutList;
    	
		
	}
	
	
	
	
	
	    //查询3天设备调节记录
		@Override
		public List<HF_hy_31> selectListShebeiDate() {
			
			List<HF_hy_31> qutList = new ArrayList<HF_hy_31>();
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			Long q = (long) (259200000); //3天
			long time = date.getTime();
			long timeNew = time-q;
			Date dateq = new Date(timeNew);  
			String format = sf.format(date);  //当前时间
			logger.debug("当前时间=========》》》"+format);
			String format2 = sf.format(dateq); //3天前的时间
			logger.debug("当前时间=========》》》"+format2);
			HF_hy_31 hF_hy_31 = new HF_hy_31();
			hF_hy_31.setTime1(format2);
			hF_hy_31.setTime2(format);
			List<HF_hy_31> selectListZong = hF_hy_31mapper.selectListShebei(hF_hy_31);
			
			for (HF_hy_31 hf_hy_312 : selectListZong) {
				
				
				//夏季
				//C_T_SP_1   低区1#热泵制冷温度设定
				Float cpofforon11 = hf_hy_312.getCpofforon11();
				Float cpofforon21 = hf_hy_312.getCpofforon21();
				Float cpofforon31 = hf_hy_312.getCpofforon31();
				Float cpofforon41 = hf_hy_312.getCpofforon41();
				Float ct1 = 0f; //低区1#热泵制冷温度设定
				if((cpofforon11 + cpofforon21 + cpofforon31 + cpofforon41) > 0) {
					ct1 = hf_hy_312.getcTSp1();
				}
				//C_T_SP_2  低区2#热泵制冷温度设定
				Float cpofforon12 = hf_hy_312.getCpofforon12();
				Float cpofforon22 = hf_hy_312.getCpofforon22();
				Float cpofforon32 = hf_hy_312.getCpofforon32();
				Float cpofforon42 = hf_hy_312.getCpofforon42();
				Float ct2 = 0f;
				if((cpofforon12 + cpofforon22 + cpofforon32 + cpofforon42) > 0) {
					ct2 = hf_hy_312.getcTSp2();
				}
				//C_T_SP_3  高区1#热泵制冷温度设定
				Float cpofforon13 = hf_hy_312.getCpofforon13();
				Float cpofforon23 = hf_hy_312.getCpofforon23();
				Float cpofforon33 = hf_hy_312.getCpofforon33();
				Float cpofforon43 = hf_hy_312.getCpofforon43();
				Float ct3 = 0f;
				if((cpofforon13 + cpofforon23 + cpofforon33 + cpofforon43) > 0) {
					ct3 = hf_hy_312.getcTSp3();
				}
				//C_T_SP_4  高区冷水机组制冷温度设定
				Float cpofforon14 = hf_hy_312.getCpofforon14();
				Float cpofforon24 = hf_hy_312.getCpofforon24();
				Float cpofforon34 = hf_hy_312.getCpofforon34();
				Float cpofforon44 = hf_hy_312.getCpofforon44();
				Float ct4 = 0f;
				if((cpofforon14 + cpofforon24 + cpofforon34 + cpofforon44) > 0) {
					ct4 = hf_hy_312.getcTSp4();
				}
				//C_T_SP_5  高区海尔磁悬浮制冷温度设定
				Float jzqt5 = hf_hy_312.getJzqt5();
				Float ct5 = 0f;
				if(jzqt5 > 0) {
					ct5 = hf_hy_312.getcTSp5();
				}
				
				
				//冬季
				//H_T_SP_1  低区1#热泵热泵温度设定
				Float cpofforon11d = hf_hy_312.getCpofforon11();
				Float cpofforon21d = hf_hy_312.getCpofforon21();
				Float cpofforon31d = hf_hy_312.getCpofforon31();
				Float cpofforon41d = hf_hy_312.getCpofforon41();
				Float ht1 = 0f; //低区1#热泵制冷温度设定
				if((cpofforon11d + cpofforon21d + cpofforon31d + cpofforon41d) > 0) {
					ht1 = hf_hy_312.gethTSp1();
				}
				//H_T_SP_2  低区2#热泵热泵温度设定
				Float cpofforon12d = hf_hy_312.getCpofforon12();
				Float cpofforon22d = hf_hy_312.getCpofforon22();
				Float cpofforon32d = hf_hy_312.getCpofforon32();
				Float cpofforon42d = hf_hy_312.getCpofforon42();
				Float ht2 = 0f;
				if((cpofforon12d + cpofforon22d + cpofforon32d + cpofforon42d) > 0) {
					ht2 = hf_hy_312.gethTSp2();
				}
				//H_T_SP_3  高区1#热泵热泵温度设定
				Float cpofforon13d = hf_hy_312.getCpofforon13();
				Float cpofforon23d = hf_hy_312.getCpofforon23();
				Float cpofforon33d = hf_hy_312.getCpofforon33();
				Float cpofforon43d = hf_hy_312.getCpofforon43();
				Float ht3 = 0f;
				if((cpofforon13d + cpofforon23d + cpofforon33d + cpofforon43d) > 0) {
					ht3 = hf_hy_312.gethTSp3();
				}
				//H_T_SP_5  高区海尔磁悬浮热泵温度设定
				Float jzqt5d = hf_hy_312.getJzqt5();
				
				Float ht5 = 0f;
				if(jzqt5d > 0) {
					ht5 = hf_hy_312.gethTSp5();
				}
		    	SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    	Date time2 = hf_hy_312.getTime();
		    	String format3 = sfm.format(time2);
		    	
		    	HF_hy_31 hf_hy_31 = new HF_hy_31();
		    	hf_hy_31.setCtSp1d(ct1);
		    	hf_hy_31.setCtSp2d(ct2);
		    	hf_hy_31.setCtSp3d(ct3);
		    	hf_hy_31.setCtSp4d(ct4);
		    	hf_hy_31.setCtSp5d(ct5);
		    	hf_hy_31.setThTSp1d(ht1);
		    	hf_hy_31.setThTSp2d(ht2);
		    	hf_hy_31.setThTSp3d(ht3);
		    	hf_hy_31.setThTSp5d(ht5);
		    	hf_hy_31.setTimeGo(format3);
		    	qutList.add(hf_hy_31);
				
			}
			return qutList;
	    	
			
		}

		

		/**
		 * 各个项目的运行参数
		 */
		@Override
		public Object yunxingCanshu(String projectId) {
            Object selectNewOne = null;
			powerProject selectByPrimaryKey = powerProjectMapper.selectByPrimaryKey(projectId);
			String projectName = selectByPrimaryKey.getProjectName();
			if(projectName.equals("合肥当代花园")) {
				selectNewOne = hF_hy_32mapper.selectNewOne();
			}
			
			return selectNewOne;
		}


		/**
		 * 初始化表名称
		 */
		@Override
		public List<HFHySQL> inintTableName() {

			List<HFHySQL> inintTableName = hFHySQLMapper.inintTableName();
			return inintTableName;
		}


		/**
		 * 根据表名称查询字段名
		 */
		@Override
		public List<HFHySQL> selectByTableName(String table) {
			List<HFHySQL> selectByTableName = hFHySQLMapper.selectByTableName(table);
            
			return selectByTableName;
		}
	
	
	
	
	
	
	
	
	
}
