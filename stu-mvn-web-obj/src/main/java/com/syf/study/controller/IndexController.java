package com.syf.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	

	@RequestMapping("/index")
	public String login() {
		System.out.println("��ת����ҳ");
		return "/index";
	}

}
