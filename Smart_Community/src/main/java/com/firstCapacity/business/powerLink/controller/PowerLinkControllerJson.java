package com.firstCapacity.business.powerLink.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstCapacity.business.HeFeiPower.entity.HF_hy_01;
import com.firstCapacity.business.powerLink.entity.PowerLink;
import com.firstCapacity.business.powerLink.entity.suoyouAll;
import com.firstCapacity.business.powerLink.service.PowerLinkService;
import com.firstCapacity.util.json.ApiController;

@Controller
@RequestMapping("/powerLinkJson")
public class PowerLinkControllerJson extends ApiController {

	@Resource
	private PowerLinkService powerLinkService;
	
	
	@RequestMapping(value="/test", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public void test() {
		
		try {
			HF_hy_01 test = powerLinkService.test();
			this.printSuccess(test, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1, "系统异常");
		}
		
	}
	
	
	@RequestMapping(value="/testgo", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
    public void testgo(HttpServletRequest request,HttpServletResponse response,PowerLink powerLink) {
		 
	       try {
	    	   HF_hy_01 test = powerLinkService.test();
			   this.printSuccess(test, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.printFailure(1,"服务异常");
		}
	      
	      
	
	}
	
	
}
