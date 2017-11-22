package com.firstCapacity.util.json;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;

public class SpringController
{
  public Logger logger = LoggerFactory.getLogger(super.getClass());
  public static final View UNRESOLVED_VIEW = new View()
  {

  public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
  {
  }

	public String getContentType() {
		return null;
	}
  };
  
  

  public HttpServletRequest getRequest()
  {
    return SpringMVCUtil.getRequest();
  }

  public HttpServletResponse getResponse()
  {
    return SpringMVCUtil.getResponse();
  }

  public void print(String result) {
    render(result);
  }
  
  public void render(String result) {
    SpringMVCUtil.render(result, "text/plain");
  }

  public void renderText(String result) {
    SpringMVCUtil.render(result, "text/plain");
  }

  public void renderJson(String result) {
    SpringMVCUtil.render(result, "application/json");
  }

  public void renderXml(String result) {
    SpringMVCUtil.render(result, "text/xml");
  }

  public void renderHtml(String result) {
    SpringMVCUtil.render(result, "text/html");
  }

  
  public void render(String result, String contentType) {
	    SpringMVCUtil.render(result, contentType);
	  }
  
  public String redirectTo(String url) {
	    return new StringBuilder().append("redirect:").append(url).toString();
	  }

	  public String forwardTo(String url) {
	    return new StringBuilder().append("forward:").append(url).toString();
	  }

	  public void setAttribute(String key, Object value)
	  {
	    getRequest().setAttribute(key, value);
	  }
  
}
