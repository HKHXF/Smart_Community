package com.firstCapacity.util.json;

import com.alibaba.fastjson.JSONObject;

public class Result
{
  protected boolean success = true;
  protected int code = 0;
  protected String message ="";
  protected static final int ERROR_CODE_NONE = 0;
  protected static final int ERROR_CODE_COMMON = 500;

  public Result()
  {
  }

  public Result(RunError error)
  {
    this.success = (!(error.isError()));
    this.code = error.getCode();
    this.message = error.getMessage();
  }

  public Result(String message) {
    this.message = message;
  }

  public Result(boolean success) {
    setSuccess(success);
  }

  public Result(boolean success, String message) {
    setSuccess(success);
    this.message = message;
  }

  public Result(boolean success, int code, String message) {
    setSuccess(success);
    this.code = code;
    this.message = message;
  }

  public boolean isSuccess() {
    return this.success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
    if (success)
      this.code = 0;
    else if (this.code == 0)
      this.code = 500;
  }

  public int getCode()
  {
    return this.code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setErrorMessage(String message) {
    this.success = false;
    this.code = 500;
    this.message = message;
  }

  public void setErrorMessage(int code, String message) {
    this.success = false;
    this.code = code;
    this.message = message;
  }

  public String toJson() {
    return JSONObject.toJSONString(this);
  }

  public String toString()
  {
    String str = "[Result] --success:" + this.success + " --code:" + this.code;
    if (this.message != null) str = str + " --message:" + this.message;
    return str;
  }
}
