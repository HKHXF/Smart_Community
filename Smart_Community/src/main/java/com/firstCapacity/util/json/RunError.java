package com.firstCapacity.util.json;


public abstract interface RunError
{
  public abstract int getCode();

  public abstract String getMessage();

  public abstract void appendMessage(String paramString);

  public default  boolean isError()
  {
    return (getCode() != 0);
  }
}