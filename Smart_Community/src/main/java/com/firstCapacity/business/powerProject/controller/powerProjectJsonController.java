package com.firstCapacity.business.powerProject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstCapacity.business.HeFeiPower.entity.HF_hy_31;
import com.firstCapacity.business.powerLink.entity.PowerLink;
import com.firstCapacity.business.powerLink.service.PowerLinkService;
import com.firstCapacity.business.powerProject.entity.HFHySQL;
import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.business.powerProject.entity.usepublic;
import com.firstCapacity.business.powerProject.service.powerProjectService;
import com.firstCapacity.business.powerType.entity.powerType;
import com.firstCapacity.business.powerType.service.powerTypeService;
import com.firstCapacity.util.PageHelper;
import com.firstCapacity.util.Pager;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/powerProjectJson")
public class powerProjectJsonController extends ApiController{

	 private final static Logger logger = LoggerFactory.getLogger(powerProjectJsonController.class); 
	
	 @Resource
	 private powerProjectService powerProjectService;
	 
	 @Resource
	 private powerTypeService powerTypeService;
	 
	 @Resource
	 private PowerLinkService powerLinkService;
	 
	 
	 
	 
	 /**
	  *  新增项目
	  * @param powerProject
	  */
	 @RequestMapping(value="/insert", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void insert(powerProject powerProject) {
		 
		 try {
			List<powerProject> chickOne = powerProjectService.chickOne(powerProject.getProjectName());
			 if(chickOne.size() > 0) {
				 this.printFailure(1, "该项目已存在,请检查!!!"); 
			 }else {
				 powerProjectService.imsert(powerProject);
				 this.printSuccess(null, "新增成功");
			 }
		} catch (Exception e) {
			logger.error("项目新增失败");
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍候再试!!!");
		}
	 }
	 
	 /**
	  * 修改项目
	  * @param powerProject
	  */
	 @RequestMapping(value="/update", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void update(powerProject powerProject) {
		 
		 try {
			powerProjectService.update(powerProject);
			this.printSuccess();
		} catch (Exception e) {
			logger.error("项目修改失败");
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍候再试!!!");
		}
		 
	 }
	 
	 
	 /**
	  *  删除项目或区域
	  * @param projectId
	  */
	 @RequestMapping(value="/delete", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void delete(String projectId) {
		 
		 try {
			powerProjectService.delete(projectId);
			this.printSuccess();
		} catch (Exception e) {
			logger.error("项目修改失败");
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍候再试!!!");
		}
		 
	 }
	 
	 
	 /**
	  * 删除区域时检查区域下是否有项目
	  */
	 @RequestMapping(value="/chickDelete", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void chickDelete(String projectId) {
		 
		 try {
			List<powerProject> selectProbjectByQuyu = powerProjectService.selectProbjectByQuyu(projectId);
			 if(selectProbjectByQuyu.size() > 0) {
				 this.printSuccess(0, "成功");
			 }else {
				 this.printSuccess("1", "成功");
			 }
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常，请稍后再试!!!");
		}
		 
	 }
	 
	 
	 /**
	  * 查询项目详情
	  * @param projectId
	  */
	 @RequestMapping(value="/selectOne", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectOne(String projectId) {
		 
		 try {
			powerProject selectOne = powerProjectService.selectOne(projectId);
			this.printSuccess(selectOne,"成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍候再试!!!");
		}
	 }
	 
	 
	 /**
	  *  区域项目树结构
	  */
	 @RequestMapping(value="/tree", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void tree() {
		 try {
			 usepublic queryListAll = powerProjectService.queryListAll();			 
			 this.printSuccess(queryListAll);
			 logger.debug("区域项目树查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1,"系统错误，请稍候再试!!!");
			logger.debug("后台系统异常");
		}
		 
	 }
	 
	 
	 /**
	  *  模糊查询列表
	  * @param powerProject
	  */
	 @RequestMapping(value="/selectqueryList", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectqueryList(powerProject powerProject,@RequestParam(required=true,defaultValue="1") Integer page) {
		 
		 try {
			PageHelper.startPager(page);
			List<powerProject> selectqueryList = powerProjectService.selectqueryList(powerProject);
			Pager<powerProject> p = new Pager<powerProject>(selectqueryList);
			List<powerProject> selectQuyu = powerProjectService.qyuryQuyu();  //所有的区域
			List<powerType> selectList = powerTypeService.selectList();  //所有类别
			usepublic useInsert = new usepublic();
			useInsert.setQuyu(selectQuyu);
			useInsert.setLeibie(selectList);
			useInsert.setList(p);
			
			 this.printSuccess(useInsert, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统错误,请稍候再试!!!");
		}
		 
	 }
	 
	 
	 /**
	  * 查询区域列表
	  */
	 @RequestMapping(value="/selectQuyu", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectQuyu() {
		 
		 try {
			List<powerProject> qyuryQuyu = powerProjectService.qyuryQuyu();
			this.printSuccess(qyuryQuyu, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 /**
	  * 能源项目查询所有项目
	  */
	 @RequestMapping(value="/queryList", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void queryList(powerProject powerProject,@RequestParam(required=true,defaultValue="1") Integer page) {
		 
		 try {
			 PageHelper.startPager(page);
			 List<powerProject> selectqueryList = powerProjectService.selectqueryList(powerProject);
			 Pager<powerProject> p = new Pager<powerProject>(selectqueryList);
			 this.printSuccess(p, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
	 /**
	  * 查询区域和项目
	  */
	 @RequestMapping(value="/selectQuyuAndProbjectAndType", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectQuyuAndProbject() {
		 
		 try {
			usepublic selectQuyuAndProbject = powerProjectService.selectQuyuAndProbject();
			this.printSuccess(selectQuyuAndProbject, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
		 
	 }
	 
	 
	 /**
	  * 按照区域ID查询项目列表
	  * @param projectId
	  */
	 @RequestMapping(value="/selectProbjectByQuyu", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectProbjectByQuyu(String projectId) {
		 
		 try {
			List<powerProject> selectProbjectByQuyu = powerProjectService.selectProbjectByQuyu(projectId);
			this.printSuccess(selectProbjectByQuyu, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 /**
	  * 按照项目ID查询区域列表
	  * @param projectId
	  */
	 @RequestMapping(value="/selectQuyuByProject", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectQuyuByProject(String projectId) {
		 
		 try {
			powerProject selectQuyuByProject = powerProjectService.selectQuyuByProject(projectId);
			this.printSuccess(selectQuyuByProject, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
	 /**
	  * 系统运行
	  */
	 @RequestMapping(value="/xitong", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void xitong(String projectId) {
		 
		 try {
			 powerProject powerProject = powerProjectService.xitong(projectId);
			 this.printSuccess(powerProject, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
	 /**
	  * 系统-能效
	  */
	 @RequestMapping(value="/xitongNengxiao", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	    public void xitongNengxiao(HttpServletRequest request,HttpServletResponse response,PowerLink powerLink) {
		 
	      try {
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/com/firstCapacity/business/HeFeiPower/mapper/"); //获取下载路劲
			  List<Object> selectLinkByProjectId = powerLinkService.selectLinkByProjectId(path, powerLink);
			  this.printSuccess(selectLinkByProjectId, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常");
		}
		 
	 }
	 
	 /**
	  * 能耗统计
	  */
	 @RequestMapping(value="/nenghaotongji", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void nenghaotongji(HttpServletRequest request) {
		 
		 HttpSession session = request.getSession(); 
		 Object attribute = session.getAttribute("projectId");
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 /**
	  * 系统运行（大接口全部）
	  */
	 @RequestMapping(value="/xitongyinxingAll", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void xitongyinxingAll(HttpServletRequest request,String tableName,String projectId) {
		 
		 try {
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/com/firstCapacity/business/HeFeiPower/entity/"); //获取项目文件
			 Object xitongyinxingAll = powerProjectService.xitongyinxingAll(path, tableName,projectId);
			 this.printSuccess(xitongyinxingAll, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
		 
	 }
	 
	 
	 /**
	  * 查询一个时间段内的数据
	  */
	 @RequestMapping(value="/selectListTime", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectListTime() {
		 
		 try {
			List<Object> selectListTime = powerProjectService.selectListTime();
			 this.printSuccess(selectListTime, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 /**
	  * 设备调节记录切换
	  */
	 @RequestMapping(value="/shebeiTiaojie", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void shebeiTiaojie() {
		 
		 
		 try {
			SimpleDateFormat sf = new SimpleDateFormat("MM");
			 Date date = new Date();
			 String format = sf.format(date);
			 this.printSuccess(format, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
		 
	 }
	 
	 
	 
	 
	 
	 /**
	  * 设备调节记录数据
	  */
	 @RequestMapping(value="/shebeiTiaojieDate", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void shebeiTiaojieDate() {
		 
		 
		 try {
			 List<HF_hy_31> selectListShebei = powerProjectService.selectListShebeiDate();
			 this.printSuccess(selectListShebei, "成功");
			 
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
		 
	 }
	 
	 
	 
	 /**
	  * 运行参数总控制
	  * @param projectId
	  */
	 @RequestMapping(value="/yunxingCanshu", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void yunxingCanshu(String projectId) {
		 
		 try {
			Object yunxingCanshu = powerProjectService.yunxingCanshu(projectId);
			 this.printSuccess(yunxingCanshu, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
	 /**
	  * 初始化表名称
	  */
	 @RequestMapping(value="/inintTableName", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void inintTableName() {
		 
		 
		 try {
			List<HFHySQL> inintTableName = powerProjectService.inintTableName();
			 this.printSuccess(inintTableName);
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
		 
	 }
	 
	 
	 
	 /**
	  * 根据表名称查询字段
	  * @param table
	  */
	 @RequestMapping(value="/selectByTableName", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void selectByTableName(String table) {
		 
		 try {
			List<HFHySQL> selectByTableName = powerProjectService.selectByTableName(table);
			 this.printSuccess(selectByTableName);
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
}
