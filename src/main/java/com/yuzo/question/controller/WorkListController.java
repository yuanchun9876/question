package com.yuzo.question.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.WorkList;
import com.yuzo.question.entity.WorkType;
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
	
	@RequestMapping("/byStuPage")
	public String byStuPage(Model model) {
		
		List<UserMyclass> mclist = workListService.queryMc();
		model.addAttribute("mclist", mclist);	
		
		return "worklist/list_select_class_work";
	}
	
	@RequestMapping("/queryWlByMc")
	public String queryWlByMc(String mcId, Model model) {
		
		List<Map<String, Object>> list = workListService.queryByMc(mcId);
		System.out.println(list);
		model.addAttribute("list", list);
		
		List<SysUser>  userList = workListService.queryUserByMc(mcId);
		System.out.println(userList);
		model.addAttribute("userList", userList);	
		
		return "worklist/list_stu_work";
	}
	
	@RequestMapping("addPage")
	public String addPage( Model model) {
		List<WorkType> wtList = workListService.queryWt();
		System.out.println(wtList);
		model.addAttribute("wtList", wtList);		
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
		//System.out.println(wlId);
		WorkList wl = workListService.queryById(wlId);
		//System.out.println(wl);
		model.addAttribute("wl", wl);
		
		List<WorkType> wtList = workListService.queryWt();
		System.out.println(wtList);
		model.addAttribute("wtList", wtList);	
		
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
