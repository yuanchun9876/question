package com.yuzo.question.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.service.ILoginService;

@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@RequestMapping("/")
	public String login(){
		
		return "login";
	}
	
	@RequestMapping("/main")
	public String mainPage(SysUser user ,String rememberMe, HttpServletRequest request, HttpServletResponse response, HttpSession session , Model model) throws FileNotFoundException{
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
		//System.out.println("path:" + path);
		
		
		String name = user.getUserName();
		String pass = user.getUserPass();
		
		List<SysUser> userList = loginService.queryUserByName(name);
		
		if(userList!=null && userList.size()>0) {
			if (userList.get(0).getUserPass().equals(pass)) {
				
//				List<SysMenu> pmenuList = loginService.queryParMenu(userList.get(0).getUserId());
//				model.addAttribute("pmenuList", pmenuList);
				List<SysMenu> cmenuList = loginService.queryChdMenu(userList.get(0).getUserId());
				System.out.println("cmenuList:" + cmenuList);
				model.addAttribute("cmenuList", cmenuList);
				System.err.println(userList.get(0).getNickName() + ":login");
				
				session.setAttribute("user", userList.get(0));
				Cookie cookieUsername = null;
				Cookie cookiePassword = null;
				Cookie cookieRememberMe = null;
				System.out.println("rememberMe:" + rememberMe);
				if("true".equals(rememberMe)) {
					cookieUsername = new Cookie("username", name);
			        cookiePassword = new Cookie("password", pass);
			        cookieRememberMe = new Cookie("rememberMe", rememberMe);
			        
					cookieUsername.setMaxAge(60*60*24*30);
		            cookiePassword.setMaxAge(60*60*24*30);
		            cookieRememberMe.setMaxAge(60*60*24*30);
		            
		            response.addCookie(cookieUsername);
		            response.addCookie(cookiePassword);
		            response.addCookie(cookieRememberMe);
				}else {
					cookieUsername = new Cookie("username", name);
			        cookiePassword = new Cookie("password", pass);
			        cookieRememberMe = new Cookie("rememberMe", rememberMe);
			        
					cookieUsername.setMaxAge(0);
		            cookiePassword.setMaxAge(0);
		            cookieRememberMe.setMaxAge(0);
		            
		            response.addCookie(cookieUsername);
		            response.addCookie(cookiePassword);
		            response.addCookie(cookieRememberMe);
				}
				
			
				
				return "common/main";
			} else {
				model.addAttribute("msg", "登录异常");
				return "login";
			}
		}else {
			model.addAttribute("msg", "登录异常");
			return "login";
		}
		
	}
	
	
	
	@RequestMapping("/dashboard")
	public String dashboard(){
		
		return "common/dashboard";
	}
	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request){
		request.getSession().invalidate();    
		return "login";  
	}
	
	@RequestMapping("/perLoginOut")
	public String perLoginOut(HttpServletRequest request){
		//request.getSession().invalidate();
		return "loginOut";
	}
}
