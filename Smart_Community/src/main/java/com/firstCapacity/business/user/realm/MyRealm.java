package com.firstCapacity.business.user.realm;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpRequest;

import com.firstCapacity.business.user.entity.Role;
import com.firstCapacity.business.user.entity.User;
import com.firstCapacity.business.user.service.RoleService;
import com.firstCapacity.business.user.service.userService;



/**
 * 登录核心
 */ 
public class MyRealm extends AuthorizingRealm { 
	
	
//	findUserByUserName(String username)根据username查询用户，之后Shiro会根据查询出来的User的密码来和提交上来的密码进行比对。
//	findRoles(String username)根据username查询该用户的所有角色，用于角色验证。
//	findPermissions(String username)根据username查询他所拥有的权限信息，用于权限判断。

	
	@Resource 
	private userService userService; 
	
	@Resource 
	private RoleService rolesService; 
	
       
      
      
      /** 
       * 权限认证，获取登录用户的权限
       */  
      @Override  
      protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {  
//          String loginName=(String) principalCollection.fromRealm(getName()).iterator().next(); 
          String username = principalCollection.getPrimaryPrincipal().toString() ;
          //此处连库匹配了登录用户的数据，具体怎么做，需要根据个人需求而定
          User user=userService.getByUsername(username);  
          List<Role> list = rolesService.selectRoleByUserId(user.getUserId());
          if(user!=null){  
              SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
              //获取用户的角色名称
              info.addRole(user.getUserName());  
              for (Role role : list) {  
            	  info.addRole(role.getRoleName());    
              } 
              //获取用户的权限
//              List<Role> roleList=user.getRoleList();  
              for (Role role : list) {  
                  info.addStringPermission(role.getRoleName());  
              }  
              return info;  
          }  
          return null;  
      }    
      
      
      /**
      }
     * 首先执行这个登录验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
     @Override 
     protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException { 
    	 //获取用户账号
    	 String username = token.getPrincipal().toString() ;
    	 User user = userService.getByUsername(username);  //findUserByUserName(String username)根据username查询用户，之后Shiro会根据查询出来的User的密码来和提交上来的密码进行比对。
	    	 if (user != null){ 
	    		 String id = user.getUserId();
	    		 setSession("userId",id);
	    		 //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realName。
	    		 AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(), user.getUserName()) ;
	    		 return authenticationInfo ; 
	    		 
	    	 }else{
	    		 return null ; 
	         } 
    	 } 
     
     
     
     
		   /** 
		   * 将一些数据放到ShiroSession中,以便于其它地方使用 
		   * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
		   */  
		  private static void setSession(Object key, Object value){  
		      Subject currentUser = SecurityUtils.getSubject();  
		      if(null != currentUser){  
		    	  SecurityUtils.getSubject().getSession().setTimeout(-1000l);
		          Session session = currentUser.getSession();  
		          System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
		          if(null != session){  
		              session.setAttribute(key, value);  
		          }  
		      }  
		  }  
		  
		  
		  
		  
		  public static String getUserIdNow(){  
			  Subject subject = SecurityUtils.getSubject();
			  Session session = subject.getSession();
			  Object attribute = session.getAttribute("userId");
			  
			  return (String)attribute;
			  
		  }  
     
     
     
     }

