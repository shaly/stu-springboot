package com.syf.study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.syf.study.util.Constant;
import com.syf.study.vo.UserVo;
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		System.out.println("跳转到登录页面");
		return "/login";
	}
	
	//一个tomcat 并发量250个请求

	@ResponseBody
	@RequestMapping(value="/logined")
//public String logined(@RequestParam("account") String account,@RequestParam("password") String password,@RequestParam("code")String code) {
	public String logined(UserVo userVo,HttpSession httpSession) {
		System.out.println("account="+userVo.getAccount()+";password="+userVo.getPassword()+";code="+userVo.getCode());
		//只差整合mybatis查询数据库，将用户信息存在session中
		
		
		
		if("Jane".equals(userVo.getAccount())) {
			httpSession.setAttribute(Constant.SESSION_USER_KEY, userVo);
			return "success";
		}
		return "failed";
	}
	
}
