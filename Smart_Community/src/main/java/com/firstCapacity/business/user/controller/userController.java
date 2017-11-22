package com.firstCapacity.business.user.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstCapacity.business.user.entity.User;
import com.firstCapacity.business.user.service.userService;
import com.firstCapacity.util.MD5Util;
import com.firstCapacity.util.json.ApiController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
import org.springframework.web.servlet.view.InternalResourceViewResolver;  

@Controller
@RequestMapping("/user")
public class userController extends ApiController{
	 private final static Logger logger = LoggerFactory.getLogger(userController.class); 
	
	@Resource
	private userService userservice;
	
	
	@RequestMapping("/index")  
	public String index() {
		System.out.println("首页 ");
		
		return "/html/index";
		
	}
	
	
//  	@RequestMapping("/bootStrap")
//	public String bootStrap(){
//		
//		System.out.println("盒子");
//		
//		return "/index";
//	}
  	
  	
  	
  	@RequestMapping("/yonghu")
	public String demo(){
		
		System.out.println("盒子");
		
		return "/html/aUser";
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
    public String userList(Model model,User user,@RequestParam(required=true,defaultValue="1") Integer page,@RequestParam(required=false,defaultValue="2") Integer pageSize,Integer flag) {
		
		PageInfo<User> p = null;
		try {
			PageHelper.startPage(page, pageSize);
			PageHelper.orderBy("create_time desc");
			List<User> selectMohu = userservice.SelectMohu(user);
			p = new PageInfo<User>(selectMohu);
			logger.debug("分页查询执行成功");
			
			logger.debug("===========================>>>>>>分页查询执行成功");
//			System.out.println("测试路径=========>"+Systomr.NAME);
//			System.out.println("测试名称=========>"+Systomr.URL);
			model.addAttribute("flag", flag); //选中
 			model.addAttribute("PageInfo", p);
			return "/html/user/aUser";
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("分页查询执行失败");
			return "/error/error";
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/quanxian")
	public String quanxian(Model model,Integer flag){
		
		System.out.println("权限管理");
		model.addAttribute("flag", flag); //选中
		return "/html/user/aRole";
	}
	
	@RequestMapping("/register")
	public String register(){
		
		System.out.println("注册用户");
		
		return "/bootindex/page-register";
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
						this.printSuccess(0, "/user/index");
					}
			}else {
				this.printFailure(1, "该用户名已存在");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常,请稍后再试");
		}
		
		
	}
    
    
	/** 
     * 用户登录(JSON方式) 
     */  
    @RequestMapping(value="/loginToJson", method=RequestMethod.POST, produces = "application/json; charset=utf-8")  
    @ResponseBody
    public void loginToJson(HttpServletRequest request,String username,String password){  
        try {
//			String username = request.getParameter("username").trim();  
//			String password = request.getParameter("password").trim();  
			//获取HttpSession中的验证码
//			String verifyCode = (String)request.getSession().getAttribute("verifyCode"); 	
			//获取用户请求表单中输入的验证码  
//			String submitCode = WebUtils.getCleanParam(request, "verifyCode");  
//			System.out.println("用户[" + username + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");  
//        if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(verifyCode, submitCode.toLowerCase())) {  
//            request.setAttribute("message_login", "验证码不正确");  
//            this.printFailure(1, "验证码不正确");
//            return;
//        }  
			String md5 = MD5Util.md5(password, "hexiangfeng");
			UsernamePasswordToken token = new UsernamePasswordToken(username, md5);  
			token.setRememberMe(true);  
			System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
			//获取当前的Subject  
			Subject currentUser = SecurityUtils.getSubject(); 
			
//			HttpSession session = request.getSession();
//			session.getAttribute("");
			
			try {  
			    //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
			    //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
			    //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
			    System.out.println("对用户[" + username + "]进行登录验证..验证开始");  
			    currentUser.login(token);  
			    System.out.println("对用户[" + username + "]进行登录验证..验证通过");
			    SavedRequest savedRequest = WebUtils.getSavedRequest(request);
			    
			    if(savedRequest == null) {
			    	 String url1 = "/user/index"; //首页
			    	 this.printSuccess(0,url1);
			    }else {
			    	String url = WebUtils.getSavedRequest(request).getRequestUrl();  //找到请求前的地址
			    	 this.printSuccess(0,url);
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
//            request.setAttribute("message_login", "用户名或密码错误次数过多");
			    this.printFailure(1, "用户名或密码错误次数过多");
			}catch(AuthenticationException ae){  
			    //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
			    System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
			    ae.printStackTrace();  
//            resultPageURL = "用户名或密码不正确";  
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
     * 用户登出 
     */  
    @RequestMapping("/logout")  
    public String logout(HttpServletRequest request){  
         SecurityUtils.getSubject().logout();  
         return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";  
    }  
	
    
   

	

}
