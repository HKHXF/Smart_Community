package com.firstCapacity.util.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ApiResult extends Result
{
  private Object data;
//  private boolean encrypt = false;

  public ApiResult() {
  }

  public ApiResult(RunError error) {
    super(error);
  }

  public ApiResult(boolean success) {
    super(success);
  }

  public ApiResult(boolean success, String message) {
    super(success, message);
  }

  public ApiResult(boolean success, int code, String message) {
    super(success, code, message);
  }

  public ApiResult(Object data)
  {
    this.data = data;
  }

  public ApiResult(Object data, String message) {
    super(message);
    this.data = data;
  }

//  public boolean isEncrypt() {
//    return this.encrypt;
//  }
//
//  public void setEncrypt(boolean encrypt) {
//    this.encrypt = encrypt;
//  }

  public <X> X getData()
  {
    return (X) this.data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public static ApiResult parse(String json) {
    return ((ApiResult)JsonUtil.jsonToBean(json, ApiResult.class));
  }

  private <X> X dataToBean(Object data, Class<?> clazz)
  {
    if ((data == null) || (clazz == null)) {
      return null;
    }
    if (data instanceof JSONObject) {
      return JsonUtil.jsonToBean(data, clazz);
    }
    if (clazz.isInstance(data)) {
      return (X) data;
    }
    return null;
  }

  public <X> X dataToBean(Class<?> clazz) {
    return dataToBean(this.data, clazz);
  }

  public <X> List<X> dataToBeans(Class<?> clazz)
  {
    if ((this.data == null) || (clazz == null)) {
      return null;
    }
    List dataList = new ArrayList();
    if (this.data instanceof JSONArray) {
      JSONArray datas = (JSONArray)this.data;
      for (int i = 0; i < datas.size(); ++i) {
        Object object = datas.get(i);
        Object x = dataToBean(object, clazz);
        dataList.add(x);
      }
      return dataList;
    }
    if (List.class.isInstance(this.data)) {
      return ((List)this.data);
    }
    return null;
  }

  public String toString()
  {
    String str = "[ApiResult] --success:" + this.success + " --code:" + this.code;
     str = str + " --data:" + this.data;
     str = str + " --message:" + this.message;
    return str;
  }
}