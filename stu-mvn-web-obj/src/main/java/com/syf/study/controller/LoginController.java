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
		System.out.println("��ת����¼ҳ��");
		return "/login";
	}
	
	//һ��tomcat ������250������

	@ResponseBody
	@RequestMapping(value="/logined")
//public String logined(@RequestParam("account") String account,@RequestParam("password") String password,@RequestParam("code")String code) {
	public String logined(UserVo userVo,HttpSession httpSession) {
		System.out.println("account="+userVo.getAccount()+";password="+userVo.getPassword()+";code="+userVo.getCode());
		//ֻ������mybatis��ѯ���ݿ⣬���û���Ϣ����session��
		
		
		
		if("Jane".equals(userVo.getAccount())) {
			httpSession.setAttribute(Constant.SESSION_USER_KEY, userVo);
			return "success";
		}
		return "failed";
	}
	
}
