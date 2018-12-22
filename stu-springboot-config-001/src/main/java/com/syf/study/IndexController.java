package com.syf.study;

import org.apache.tomcat.util.http.fileupload.ThresholdingOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syf.study.service.UserService;

//springmvc控制器
@Controller
public class IndexController {
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		
		return userService.sayHello();
	}

	@ResponseBody
	@RequestMapping("/index")
	public String index() {
		
		return "index method!!!";
	}

	@RequestMapping("/toIndexPage")
	public String toIndexPage() {
		logger.trace("trace 日志...");
		logger.debug("debug 日志...");
		logger.info("info 日志...");
		logger.warn("warn 日志...");
		logger.error("error 日志...");
		return "index";
	}

}
