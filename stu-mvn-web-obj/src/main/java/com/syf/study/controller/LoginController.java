package com.syf.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		System.out.println("Ìø×ªµ½µÇÂ¼Ò³Ãæ");
		return "/login";
	}
	
	
}
