package com.firstCapacity.business.homepage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.business.powerProject.service.powerProjectService;

@Controller
@RequestMapping("/homepage")
public class homepage {

	
	 @Resource
	 private powerProjectService powerProjectService;
	
	
	/**
	 *  首页
	 * @return
	 */
	@RequestMapping("/index")  
	public String index() {
		
		return "/html/index";
		
	}
	
	
	
	/**
	 * 项目总览
	 * @return
	 */
	@RequestMapping("/pandect")  
	public String pandect() {
		
		return "/html/homepage";
		
	}
	
	
	/**
	 *  科技能源
	 * @return
	 */
	@RequestMapping("/operation")
	public String operation(HttpServletRequest request,Model model) {
		
		
		HttpSession session = request.getSession(); 
		Object attribute = session.getAttribute("projectId");
		Object tableName = session.getAttribute("tableName");
		model.addAttribute("toID", attribute);
		model.addAttribute("tableNameTo", tableName);
		if(attribute == null || attribute.equals("")) {
			return "/html/power/operation";
		}else {
			return "/html/power/function";
		}
		
		
	}
	
	
	
	
	/**
	 *  退出系统运行并清除缓存
	 * @return
	 */
	@RequestMapping("/delSession")
	public String delSession(HttpServletRequest request) {
		HttpSession session = request.getSession(); 
		session.removeAttribute("projectId");
		session.removeAttribute("tableName");
			return "/html/power/operation";
	}
	
	
	
	/**
	 *  进入项目
	 * @return
	 */
	@RequestMapping("/function")
	public String function(String projectId,String tableName,HttpServletRequest request) {
		
		HttpSession session = request.getSession(); 
		session.setAttribute("projectId", projectId);
		session.setAttribute("tableName", tableName);
		
		return "/html/power/function";
	}
	
	
	/**
	 *  能源能耗
	 * @return
	 */
	@RequestMapping("/nenghaoHome")
	public String nenghaoHome(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession(); 
		Object attribute = session.getAttribute("projectId");
		Object tableName = session.getAttribute("tableName");
		if(attribute == null || attribute.equals("")) {
			return "/html/power/operation";
		}else {
			powerProject selectOne = powerProjectService.selectOne(attribute.toString());
			String projectName = selectOne.getProjectName();
			model.addAttribute("toID", attribute);
			model.addAttribute("toName", projectName);
		
			model.addAttribute("tableNameTo", tableName);
			
			return "/html/power/nenghao";
		}
		
		
		
	}
	
	
	/**
	 *  设备台账
	 * @return
	 */
	@RequestMapping("/shebei")
	public String shebei() {
		return "/html/power/shebei";
	}
	
	
	/**
	 * 维保报修
	 * @return
	 */
	@RequestMapping("/weibo")
	public String weibo() {
		return "/html/power/weibao";
	}
	
	
	/**
	 * 项目管理
	 * @return
	 */
	@RequestMapping("/xmGuanli")
	public String xmGuanli() {
		return "/html/power/xm-gaikuang";
	}
	
	
}
