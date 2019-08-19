package com.yuzo.question.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.WorkList;
import com.yuzo.question.service.IWorkListService;

@Controller
@RequestMapping("/worklist")
public class WorkListController {

	@Autowired
	private IWorkListService  workListService;
	
	@RequestMapping("/query")
	public String query(HttpSession session, Model model) {
		
		List<WorkList> list = workListService.query();
		System.out.println(list);
		model.addAttribute("list", list);		
		return "worklist/list_work";
	}
	
	@RequestMapping("addPage")
	public String addPage( Model model) {
		return "worklist/add_work";
	}
	
	@RequestMapping("addSave")
	public String addSave(WorkList wl)  {

	
		wl.setWlId(UUID.randomUUID().toString());
		int count = workListService.save(wl);
		
		System.out.println("WorkList:" + count);
		
		return "redirect:query";
	}
	
	@RequestMapping("/editPage")
	public String editPage(String wlId,HttpSession session, Model model) {
		
		WorkList wl = workListService.queryById(wlId);
		model.addAttribute("wl", wl);
		
		return "worklist/edit_work";
	}
	
	
	@RequestMapping("/editSave")
	public String editSave(WorkList wl) {
		
		int count = workListService.update(wl);
	
		return "redirect:query";
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		int count = workListService.dels(ids);
		System.out.println(":" + count);
		return "redirect:query";
	}
	
}
