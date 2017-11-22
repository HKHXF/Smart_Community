package com.firstCapacity.business.homepage.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.firstCapacity.util.HttpUtils;
import com.firstCapacity.util.json.ApiController;


@Controller
@RequestMapping("/weatherAliBaba")
public class weatherAliBaba extends ApiController{

	@RequestMapping(value="/weatherToAliBaba", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String weatherToAliBaba(String city) {
	
	    String host = "http://jisutianqi.market.alicloudapi.com";
	    String path = "/weather/query";
	    String method = "GET";
	    String appcode = "7f58a4638a7c4fcebaa49cb350d78389";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("city", city);
	    querys.put("citycode", "citycode");
	    querys.put("cityid", "cityid");
	    querys.put("ip", "ip");
	    querys.put("location", "loca tion");
        String string = "";
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//	    	jsonString = JSONObject.toJSONString(EntityUtils.toString(response.getEntity()));
	    	HttpEntity entity = response.getEntity();
	    	string = EntityUtils.toString(entity);
	    	System.out.println(string);
	    	logger.debug(string);
//	    	this.printSuccess(string, "成功");
	    	//获取response的body
//	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	this.printFailure(1, "系统异常,请稍后再试!!!");
	    }
	    return string;
	}
	
}
