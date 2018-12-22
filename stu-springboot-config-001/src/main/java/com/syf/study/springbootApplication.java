package com.syf.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syf.study.service.UserService;
//@EnableAutoConfiguration
////此配置是自动加载springboot管理的所有配置类，这个配置类会自动根据你pom.xml文件中的依赖有关
///**
//* eg:
//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-web</artifactId><!-- web包包括了springmvc,servlet,aop,core,bean,tomcat,json处理 -->
//    </dependency>
// 会自动把springboot中的配置包中关于spring-boot-starter-web的配置加载到spring容器进行管理
// spring-boot-autoconfigure-2.0.4.RELEASE.jar
// @EnableAutoConfiguration此注解是把所有项目pom.xml中依赖配置类全部找出来，放入高set结合中，然后让容器去初始化
// 
//* @author Administrator
//*
//*/
//
//@ComponentScan("com.syf.study.*")//扫描包
//@SpringBootConfiguration//加载application.properties配置类

@SpringBootApplication//次注解等于上面所有注解之和
public class springbootApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(springbootApplication.class, args);
	}
}
