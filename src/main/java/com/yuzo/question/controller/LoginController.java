package com.yuzo.question.controller;

import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String login(){
		
		return "/login";
	}
	
	@RequestMapping("/main")
	public String mainPage(HttpServletRequest request) throws FileNotFoundException{
		String path = request.getRealPath("");
	
		File filePath=new File(ResourceUtils.getURL("classpath:").getPath());
		if(!filePath.exists()  ){
			filePath=new File("");
		}
		File upload=new File(filePath.getAbsolutePath(),"/static/upload/");
		if (!upload.exists()) {
			upload.mkdirs();
		}
		path = filePath.getAbsolutePath()+"\\static\\upload\\";
		System.out.println("path:" + path);
		return "/common/main";
	}
	
	
	
	@RequestMapping("/dashboard")
	public String dashboard(){
		
		return "/common/dashboard";
	}
}
