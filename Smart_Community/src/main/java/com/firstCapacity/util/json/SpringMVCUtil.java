package com.firstCapacity.util.json;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpringMVCUtil
{
  private static final ThreadLocal<HttpServletRequest> REQ_LOCAL = new ThreadLocal();
  private static final ThreadLocal<HttpServletResponse> RES_LOCAL = new ThreadLocal();

  public static HttpServletRequest getRequest() {
    return ((HttpServletRequest)REQ_LOCAL.get());
  }

  public static HttpServletResponse getResponse() {
    return ((HttpServletResponse)RES_LOCAL.get());
  }

  public static void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
    REQ_LOCAL.set(request);
    RES_LOCAL.set(response);
  }

  public static void cleanRequestAndResponse() {
    REQ_LOCAL.remove();
    RES_LOCAL.remove();
  }

  public static void render(String result) {
    render(result, "text/plain");
  }

  public static void renderText(String result) {
    render(result, "text/plain");
  }

  public static void renderJson(String result) {
    render(result, "application/json");
  }

  public static void renderXml(String result) {
    render(result, "text/xml");
  }

  public static void renderHtml(String result) {
    render(result, "text/html");
  }

  public static void render(String result, String contentType) {
    String fullContentType = contentType + ";charset=UTF-8";
    HttpServletResponse response = getResponse();
    response.setContentType(fullContentType);
    try {
      response.getWriter().write(result);
      response.getWriter().flush();
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }
}
