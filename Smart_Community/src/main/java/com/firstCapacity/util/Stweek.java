package com.firstCapacity.util;

import java.io.InputStream;
import java.util.Properties;
public class Stweek {
 static private String TESTMEIJUDATA = null;
 static private String TESTJURL = null;
 static{
  loads();
 }
 synchronized static public void loads(){
  if(TESTMEIJUDATA == null || TESTJURL == null)
  {
   InputStream is = Stweek.class.getResourceAsStream("/URL.properties");
   Properties dbProps = new Properties();
   try {
    dbProps.load(is);
    TESTMEIJUDATA = dbProps.getProperty("validateQuery");
    TESTJURL = dbProps.getProperty("validate");
   }
   catch (Exception e) {
    System.err.println("不能读取属性文件. " +
    "请确保db.properties在CLASSPATH指定的路径中");
   }
  }
 }
 public static String getStartdate() {
 if(TESTMEIJUDATA==null)
  loads();
  return TESTMEIJUDATA;
 }
 public static String getTotalweek() {
 if(TESTJURL==null)
 loads();
 return TESTJURL;
 }
}