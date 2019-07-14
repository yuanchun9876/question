package com.yuzo.question.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.service.IUserClassService;
import com.yuzo.question.service.ISubjectCourseService;

@Controller
public class UserClassController {

	@Autowired
	private IUserClassService  userClassService;
	
	@RequestMapping("/usermc/query")
	public String querymc(Model model) {
		
		List<UserMyclass> list = userClassService.querymc();
		System.out.println(list);
		model.addAttribute("list", list);		
		return "userclass/list_mc";
	}
	
	@RequestMapping("/usermc/addPage")
	public String addPage(HttpSession session, Model model) {
		return "userclass/add_mc";
	}
	
	@RequestMapping("/usermc/addSave")
	public String addSave(UserMyclass mc) throws IllegalStateException, IOException {

		int count = userClassService.save(mc);		
		System.out.println("sctn:" + count);		
		return "redirect:query";
	}
	
	@RequestMapping("/usermc/editPage")
	public String editPage(String mcId,HttpSession session, Model model) {
		
		UserMyclass mc = userClassService.queryById(mcId);
		model.addAttribute("mc", mc);
		
		return "userclass/edit_mc";
	}
	
	@RequestMapping("/usermc/editSave")
	public String editSave(UserMyclass mc) {
		
		int count = userClassService.update(mc);	
		return "redirect:query";
	}
	
	@RequestMapping("/usermc/dels")
	public String dels(String[] ids) {		
		int count = userClassService.dels(ids);
		System.out.println(":" + count);
		return "redirect:query";
	}
	
	
}
