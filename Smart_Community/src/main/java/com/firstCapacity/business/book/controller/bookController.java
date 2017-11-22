package com.firstCapacity.business.book.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.JSONArray;
import com.firstCapacity.business.user.entity.User;
import com.firstCapacity.business.user.realm.MyRealm;
import com.firstCapacity.util.MD5Util;
import com.firstCapacity.util.Systomr;
import com.firstCapacity.util.VerifyCodeUtil;
import com.firstCapacity.util.json.ApiController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.firstCapacity.business.book.entity.Book;
import com.firstCapacity.business.book.service.bookService;;

@Controller
@RequestMapping("/book")
public class bookController extends ApiController{
	 private final static Logger logger = LoggerFactory.getLogger(bookController.class); 
	
	@Resource
	private bookService bookService;
	
	
	
	
	


	/**
	 *  模糊搜索Freemarker
	 * @param user  elementData
	 */
	@RequestMapping(value="/SelectMohuFreemarker",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String SelectMohuFreemarker(Model model,Book book,@RequestParam(required=true,defaultValue="1") Integer page,@RequestParam(required=false,defaultValue="10") Integer pageSize) {
		
		PageInfo<Book> p = null;
		try {
			book.setName("1");
			PageHelper.startPage(page, pageSize);
			PageHelper.orderBy("crest_time desc");
			List<Book> selectMohu = bookService.selectAll(book);
			p = new PageInfo<Book>(selectMohu);
			logger.debug("分页查询执行成功");
//			System.out.println("测试路径=========>"+Systomr.NAME);
//			System.out.println("测试名称=========>"+Systomr.URL);
			
			
			String userIdNow = MyRealm.getUserIdNow();  //当前登陆用户ID
			model.addAttribute("user", userIdNow);
			
			
			
 			model.addAttribute("PageInfo", p);
			return "/view/bookList";
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("分页查询执行失败");
			return "/error/error";
		}
		
		
	}
	
	
	
	@RequestMapping(value="/testJsp",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String testJsp() {
		
		
		return "/jsp/test";
	}
	
	@RequestMapping(value="/testHtml",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String testHtml() {
		
		
		return "/html/testHtml";
	}
	
	
	

	

}
