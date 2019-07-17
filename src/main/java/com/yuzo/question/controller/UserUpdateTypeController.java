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
import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.UserUpdatePointsType;
import com.yuzo.question.service.ISubjectCourseService;
import com.yuzo.question.service.IUserUpdateTypeService;

@Controller
@RequestMapping("/updatetype")
public class UserUpdateTypeController {

	@Autowired
	private IUserUpdateTypeService  userUpdateTypeService;
	
	@RequestMapping("/query")
	public String query(HttpSession session, Model model) {
		
		List<UserUpdatePoints> list = userUpdateTypeService.query();
		System.out.println(list);
		model.addAttribute("list", list);		
		return "updatetype/list_uupt";
	}
	
	@RequestMapping("addPage")
	public String addPage(HttpSession session, Model model) {
		return "updatetype/add_uupt";
	}
	
	@RequestMapping("addSave")
	public String addSave( UserUpdatePointsType uupt){

		uupt.setUuptId(UUID.randomUUID().toString());
		int count = userUpdateTypeService.save(uupt);
		
		System.out.println("uupt:" + count);
		
		return "redirect:query";
	}
	
	@RequestMapping("/editPage")
	public String editPage(String uuptId,HttpSession session, Model model) {
		
		UserUpdatePointsType uupt = userUpdateTypeService.queryById(uuptId);
		model.addAttribute("uupt", uupt);
		
		return "updatetype/edit_uupt";
	}
	
	@RequestMapping("/editSave")
	public String editSave(UserUpdatePointsType uupt ) {
		
		int count = userUpdateTypeService.update(uupt);
	
		return "redirect:query";
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		int count = userUpdateTypeService.dels(ids);
		System.out.println("uupt:" + count);
		return "redirect:query";
	}
	
}
