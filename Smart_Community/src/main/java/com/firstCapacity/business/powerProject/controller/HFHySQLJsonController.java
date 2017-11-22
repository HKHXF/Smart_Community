package com.firstCapacity.business.powerProject.controller;


import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstCapacity.business.powerProject.service.HFHySQLService;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/HFHySQLJson")
public class HFHySQLJsonController extends ApiController{

	 private final static Logger logger = LoggerFactory.getLogger(HFHySQLJsonController.class); 
	 @Resource
	 private HFHySQLService hFHySQLService;
     
	  
	 
	 /**
	  *  运行参数
	  * @param table 表名
	  * @param startTime 开始时间
	  * @param endTime  结束时间
	  */
	 @RequestMapping(value="/SelectListOn", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public void SelectListOn(String table,String startTime,String endTime) {
		 
		 try {
			List<Object> selectListOn = hFHySQLService.SelectListOn(table,startTime,endTime);
			 this.printSuccess(selectListOn);
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "服务异常,请稍后再试!!!");
		}
		 
	 }
	 
	 
	 
	 
	 
	 
	 public static void main(String args[])     
	    {   //Java替换掉下划线并让紧跟它后面的字母大写  
	        StringBuffer sb = new StringBuffer();  
	        sb.append("Asd_fgh_jkl");
//	        toLowerCaseFirstOne(sb);
	        int count = sb.indexOf("_");  
	        while(count!=0){  
	            int num = sb.indexOf("_",count);  
	            count = num+1;  
	            if(num!=-1){  
	                char ss = sb.charAt(count);  
	                char ia = (char) (ss - 32);  
	                sb.replace(count,count+1,ia+"");  
//	                System.out.println(sb.toString());  
	            }  
	        }  
	      String ss = sb.toString().replaceAll("_","");  
	      System.out.println(ss+"--------------");  
	      //JAVA去掉或替换指定子字符或空格等  
//	      String str = "a b       c   d   e   f";     
//	      String test = str.replaceAll("//s{1,}", "");     
//	      System.out.println(test);     
//	        String str = "aaaaaaaaabbbbbbaaaaaaaa";     
//	        String test = str.replaceAll("b", "c");     
//	        System.out.println(test);     
	  
	    }    
	 
	//首字母转小写
	 public static String toLowerCaseFirstOne(String s){
	   if(Character.isLowerCase(s.charAt(0)))
	     return s;
	   else
	     return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	 }
	 
	 
	 
	 
}
