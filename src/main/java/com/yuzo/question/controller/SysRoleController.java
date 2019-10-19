package com.yuzo.question.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.entity.SysRole;
import com.yuzo.question.entity.Teacher;
import com.yuzo.question.service.ISubjUnitService;
import com.yuzo.question.service.ISysRoleService;

@Controller
@RequestMapping("/sysrole")
public class SysRoleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);
	
	@Autowired
	private ISysRoleService  sysRoleService;
	
	@RequestMapping("query")
	public String query(Model model) {
		
		List<SysRole> list = sysRoleService.queryAll();
		model.addAttribute("list", list);
		return "sysrole/list_role";
	}
	
	
	@RequestMapping("addPage")
	public String addPage(Model model) {
	
		return "sysrole/add_role";
	}
	
	@RequestMapping("addSave")
	public String addSave(SysRole role) {

		role.setRoleId(UUID.randomUUID().toString());
		role.setRoleState("1");
		int count = sysRoleService.save(role);
		
		System.out.println("role:" + count);
		
		return "redirect:query";
	}
	
	@RequestMapping("/editPage")
	public String editPage(String roleId,HttpSession session, Model model) {
		
		SysRole role = sysRoleService.queryById(roleId);
		model.addAttribute("role", role);	
	
		return "sysrole/edit_role";
	}
	
	@RequestMapping("/setmenupage")
	public String setmenupage(String roleId, Model model) {
		
		SysRole role = sysRoleService.queryById(roleId);
		model.addAttribute("role", role);	
		
		List<SysMenu> parList = sysRoleService.queryPar();		
		model.addAttribute("parList", parList);
		
		return "sysrole/edit_menu_role";
	}
	
	@RequestMapping("/editSave")
	public String editSave(SysRole role) {		
		
		int count = sysRoleService.update(role);
		System.out.println("role:" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/editMenu")
	public String editMenu(String roleId, String[] pids, String[] cids) {		
		System.out.println(roleId);
		System.out.println(Arrays.toString(pids));
		System.out.println(Arrays.toString(cids));
		int count = sysRoleService.editMenu(roleId, pids, cids);
		System.out.println("role:" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		System.out.println("ids:" + Arrays.toString(ids));
		int count = sysRoleService.dels(ids);
		System.out.println("dels:" + count);
		return "redirect:query";
	}
}
