package com.firstCapacity.util.json;


public class ApiController extends SpringController
{
  public void printSuccess()
  {
    ApiResult result = new ApiResult();
    renderJson(result.toJson());
  }

  public void printSuccess(Object data) {
    ApiResult result = new ApiResult(data);
    renderJson(result.toJson());
  }

  public void printSuccess(Object data, String message) {
    ApiResult result = new ApiResult(data, message);
    renderJson(result.toJson());
  }

  public void printFailure(String errmsg) {
    ApiResult result = new ApiResult(false, errmsg);
    renderJson(result.toJson());
  }

  public void printFailure(int errcode, String errmsg) {
    ApiResult result = new ApiResult(false, errcode, errmsg);
    renderJson(result.toJson());
  }
}