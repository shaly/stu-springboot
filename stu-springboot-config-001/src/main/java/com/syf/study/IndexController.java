package com.syf.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syf.study.service.UserService;
//springmvc控制器
@Controller
public class IndexController {
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
		
		return "index";
	}

}
