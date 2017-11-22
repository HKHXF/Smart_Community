package com.firstCapacity.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class printDateType {

	
	
	static public JSONObject printSuccessData(Integer code,String messge,Object data){
		String json1 = JSON.toJSONString(data);
		String str = "{'code':"+code+",'message':"+"'messge'"+",'data':"+json1+"}";
//		String str = "cose";
		Object json = JSON.toJSON(str);
		return (JSONObject) json;
	}
	
	
	static public JSONObject printSuccess(Integer code,String messge){
		
		String str = "{'code':"+code+"'message':"+messge+"}";
		Object json = JSON.toJSON(str);
		return (JSONObject) json;
	}
	
	
	
	static public JSONObject printError(Integer code,String messge){
		
		String str = "{'code':"+code+"'message':"+messge+"}";
		Object json = JSON.toJSON(str);
		return (JSONObject) json;
	}
	
}
