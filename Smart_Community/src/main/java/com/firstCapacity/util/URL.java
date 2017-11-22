package com.firstCapacity.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
public class URL {
 static private String testname = null;
 static private String testurl = null;
 static{
  loads();
 }
 synchronized static public void loads(){
  if(testname == null || testurl == null)
  {
   InputStream is = URL.class.getResourceAsStream("/URL.properties");
   Properties dbProps = new Properties();
   try {
    dbProps.load(new InputStreamReader(is, "utf-8"));
//    testname = dbProps.getProperty("dataname");
    testurl = dbProps.getProperty("ImgaUrl");
   }
   catch (Exception e) {
    System.err.println("不能读取属性文件. " + "请确保URL.properties在CLASSPATH指定的路径中");
   }
  }
 }
// public static String getName() {
// if(testname==null)
//  loads();
//  return testname;
// }
 public static String getUrl() {
 if(testurl==null)
 loads();
 return testurl;
 }
}