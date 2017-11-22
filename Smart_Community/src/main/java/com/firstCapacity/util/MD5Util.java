package com.firstCapacity.util;

import org.apache.shiro.crypto.hash.Md5Hash; 
 

 /**
 * Created with IDEA
 * 基于Shiro的MD5加密
 */ 


public class MD5Util {
	
	
	public static String md5(String str,String salt){ 
		
		return new Md5Hash(str,salt).toString(); 
		
		} 
	
	
	
	
	public static void main(String[] args) { 
		
		String md5 = md5("000000","hexiangfeng"); 
		
		System.out.println(md5); 
		
		} 
	}
