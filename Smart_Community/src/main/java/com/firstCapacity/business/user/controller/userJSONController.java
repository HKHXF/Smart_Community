package com.firstCapacity.business.user.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.firstCapacity.business.user.entity.User;
import com.firstCapacity.business.user.service.userService;
import com.firstCapacity.util.MD5Util;
import com.firstCapacity.util.PageHelper;
import com.firstCapacity.util.Pager;
import com.firstCapacity.util.json.ApiController;

import javax.servlet.http.HttpServletRequest;  
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;  

@Controller
@RequestMapping("/userjson")
public class userJSONController extends ApiController{
	 private final static Logger logger = LoggerFactory.getLogger(userJSONController.class); 
	
	@Resource
	private userService userservice;
	
	
	/**
	 *  用户列表json渲染
	 * @param model
	 * @param user
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/userListJson",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
    public void userListJson(String userName,String userPhone,@RequestParam(required=true,defaultValue="1") Integer page,@RequestParam(required=false,defaultValue="3") Integer pageSize) {
		
		Pager<User> p = null;
		try {
			User user = new User();
			user.setUserName(userName);
			user.setUserPhone(userPhone);
			PageHelper.startPage(page, pageSize);
			PageHelper.orderBy("create_time desc");
			List<User> selectMohu = userservice.SelectMohu(user);
			p = new Pager<User>(selectMohu);
			logger.debug("Json分页查询执行成功");
			this.printSuccess(p);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("json分页查询执行失败");
			this.printFailure(1, "系统异常，请稍后再试");
		}
		
		
	}
	
	
	/** 
     * 用户登录(JSON方式) 
     */  
    @RequestMapping(value="/loginToJson", method=RequestMethod.POST, produces = "application/json; charset=utf-8")  
    @ResponseBody
    public void loginToJson(HttpServletRequest request,String username,String password){  
        try {
			String md5 = MD5Util.md5(password, "hexiangfeng");
			UsernamePasswordToken token = new UsernamePasswordToken(username, md5);  
			token.setRememberMe(true);  
			System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
			//获取当前的Subject  
			Subject currentUser = SecurityUtils.getSubject(); 
			try {  
			    currentUser.login(token);  
			    System.out.println("对用户[" + username + "]进行登录验证..验证通过");
			    SavedRequest savedRequest = WebUtils.getSavedRequest(request);
			    String url1 = "/homepage/index"; //首页
			    if(savedRequest == null) {
			    	    this.printSuccess(0,url1);
			    }else {
			    	String url = WebUtils.getSavedRequest(request).getRequestUrl();  //找到请求前的地址
			    	if(url.equals("/")) {
			    		this.printSuccess(0,url1);
			    	}else {
			    		 this.printSuccess(0,url);
			    	}
			    }
				}catch(UnknownAccountException uae){  
				    System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");  
				    this.printFailure(1, "账户不存在");
				}catch(IncorrectCredentialsException ice){  
				    System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");  
				    this.printFailure(1, "密码不正确");
				}catch(LockedAccountException lae){  
				    System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");  
				    this.printFailure(1, "账户已锁定");
				}catch(ExcessiveAttemptsException eae){  
				    System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");  
				    this.printFailure(1, "用户名或密码错误次数过多");
				}catch(AuthenticationException ae){  
				    //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
				    System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
				    ae.printStackTrace();  
				    this.printFailure(1, "用户名或密码不正确");
				}  
			//验证是否登录成功  
			if(currentUser.isAuthenticated()){  
			    System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");  
			}else{  
			    token.clear();  
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure("系统异常请稍后再试");
		}  
    }  
    
      
      
    /**
	 *  添加注册用户
	 * @param record
	 * @return
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public void insert(User record) {
		try {
			User byUsername = userservice.getByUsername(record.getUserName());
			if(byUsername == null) {
				    int insert = userservice.insert(record);
					if(insert != 1) {
						this.printFailure(1, "未知失败");
					}else {
						PageHelper.startPage(1,10);
						PageHelper.orderBy("create_time desc");
						List<User> selectMohu = userservice.SelectMohu(null);
						Pager<User> p = new Pager<User>(selectMohu);
						this.printSuccess(p,"新增成功");
					}
			}else {
				this.printFailure(1, "该用户名已存在");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure("系统异常,请稍后再试");
		}
		
		
	}
    
	
	
	/**
	 *  删除用户
	 * @param userId
	 */
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
    public void deleteUser(String userId) {
    	
		try {
			 List<String> listObjectFir = (List<String>) JSONArray.parse(userId);
			userservice.deleteUser(listObjectFir);
			PageHelper.startPage(1, 10);
			PageHelper.orderBy("create_time desc");
			List<User> selectMohu = userservice.SelectMohu(null);
			Pager<User> p = new Pager<User>(selectMohu);
			this.printSuccess(p,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常，请稍后再试!!!");
		}
    	
    	
    }
   
	
	/**
	 * 用户详情
	 * @param userId
	 */
	@RequestMapping(value="/selectOne", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public void selectOne(String userId) {
		try {
			User selectByPrimaryKey = userservice.selectByPrimaryKey(userId);
			this.printSuccess(selectByPrimaryKey,"查询详情成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常，请稍后再试!!!");
		}
	}

	
	
	/**
	 *  修改详情
	 * @param record
	 */
	@RequestMapping(value="/updateOne", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public void updateByPrimaryKeySelective(User record) {
		
		try {
			userservice.updateByPrimaryKeySelective(record);
			PageHelper.startPage(1, 10);
			PageHelper.orderBy("create_time desc");
			List<User> selectMohu = userservice.SelectMohu(null);
			Pager<User> p = new Pager<User>(selectMohu);
			this.printSuccess(p,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常，请稍后再试!!!");
		}
		
		
		
	}
	
	
	
	
	/**
	 *  用户列表
	 * @param model
	 * @param user
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/userList")
	@ResponseBody
    public void userList(Model model,User user) {
		
		try {
			PageHelper.startPager(null);
			List<User> selectMohu = userservice.SelectMohu(user); 
			Pager<User> p = new Pager<User>(selectMohu);
			logger.debug("分页查询执行成功");
			this.printSuccess(p,"查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("分页查询执行失败");
			this.printFailure(1, "系统异常,请稍后再试!!!");
		}
		
		
	}
	

}
