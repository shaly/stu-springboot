package com.syf.study.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public String sayHello() {
		
		return "Hello Springboot !!!";
	}

}
