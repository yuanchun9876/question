package com.yuzo.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String login(){
		
		return "/login";
	}
	
	@RequestMapping("/main")
	public String mainPage(){
		
		return "/common/main";
	}
	
	
	
	@RequestMapping("/dashboard")
	public String dashboard(){
		
		return "/common/dashboard";
	}
}
