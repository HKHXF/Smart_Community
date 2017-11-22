package com.firstCapacity.business.user.controller;


import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import org.apache.cxf.endpoint.Endpoint;


import javax.xml.namespace.QName;    
import org.apache.cxf.service.model.BindingInfo;  
import org.apache.cxf.service.model.BindingOperationInfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;  
  
/**
 *  调用webservice接口获取信息
 * @author hexiangfeng
 *
 */

public class Client2 {  
  
    public static void main(String[] args) throws Exception {  
        String url = "http://localhost:8080/webservice/WebserviceImpl?wsdl";  
//        String url = "http://localhost:8080/webservice/HelloWorld?wsdl";  
        String method = "webServiceSelectlist";  
//        String method = "say";  
        Object[] parameters = new Object[]{"测试数据1",1,10};  
        Object object = invokeRemoteMethod(url, method, parameters)[0];
        String jsonString = JSON.toJSONString(object);  //转JSON字符串
//        List<Map<String,String>> listObjectFir = (List<Map<String,String>>) JSONArray.parse(jsonString); 
//        ParseJsonStr(object.toString());
        System.out.println(jsonString);
    }  
      
    public static Object[] invokeRemoteMethod(String url, String operation, Object[] parameters){  
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
        if (!url.endsWith("wsdl")) {  
            url += "?wsdl";  
        }  
        org.apache.cxf.endpoint.Client client = dcf.createClient(url);  
        //处理webService接口和实现类namespace不同的情况，CXF动态客户端在处理此问题时，会报No operation was found with the name的异常  
        Endpoint endpoint = client.getEndpoint();  
        QName opName = new QName(endpoint.getService().getName().getNamespaceURI(),operation);  
        BindingInfo bindingInfo= endpoint.getEndpointInfo().getBinding();  
        if(bindingInfo.getOperation(opName) == null){  
            for(BindingOperationInfo operationInfo : bindingInfo.getOperations()){  
                if(operation.equals(operationInfo.getName().getLocalPart())){  
                    opName = operationInfo.getName();  
                    break;  
                }  
            }  
        }  
        Object[] res = null;  
        try {  
            res = client.invoke(opName, parameters);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return res;  
    }     
    
    
    
    public static void ParseJsonStr(String str) {  
    	  
        JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(str);  
        System.out.println(obj);  
        String name = obj.getString("name");  
        String hobby = obj.getString("hobby");  
        JSONObject message = obj.getJSONObject("message");  
        String love = message.getString("love");  
        String sex = message.getString("sex");  
        int age = message.getInteger("age");  
        String englishName = message.getString("EnglishName");  
        System.out.println(hobby);  
        System.out.println(name + ">>" + hobby + ">>" + love + ">>" + sex  
                + ">>" + age + ">>" + englishName);  
    }  
}  