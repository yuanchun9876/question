package com.yuzo.question.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.service.ISysMenuService;


@Controller
@RequestMapping("/sysmenu")
public class SysMenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
	
	@Autowired
	private ISysMenuService  sysMenuService;
	
	@RequestMapping("query")
	public String query(String pid, Model model) {
		
		System.out.println("query_pid:" + pid);
		List<SysMenu> parList = sysMenuService.queryPar();		
		model.addAttribute("parList", parList);
		
		if(pid!=null ) {
//			List<SysMenu> chdList = sysMenuService.queryChd(parList.get(0).getMenuId());		
			List<SysMenu> chdList = sysMenuService.queryChd(pid);		
			model.addAttribute("chdList", chdList);
			model.addAttribute("parId", pid);
		}else {
			List<SysMenu> chdList = sysMenuService.queryChd(null);		
			model.addAttribute("chdList", chdList);
			model.addAttribute("parId", parList.get(0).getMenuId());
		}	
		
		return "sysmenu/list_menu";
	}
	
	
	@RequestMapping("addPage")
	public String addPage(String pare, String type, Model model) {
		model.addAttribute("pare", pare);
		model.addAttribute("type", type);
		List<SysMenu> parList = new ArrayList<>(); 
		if ("0".equals(type)) {
			SysMenu menu = sysMenuService.queryById("0");
			parList.add(menu);
			
		} else {
			parList = sysMenuService.queryPar();		
			
		}
		
		model.addAttribute("parList", parList);
		return "sysmenu/add_menu";
	}
	
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(SysMenu menu, String type) {
		System.out.println("menu:" + menu);
		menu.setMenuId(UUID.randomUUID().toString());
		menu.setMenuIslink(type);
	
		int count = sysMenuService.save(menu);
		
		System.out.println("menu:" + count);
		
		return "true";
	}
	
	@RequestMapping("selectByPids")
	@ResponseBody
	public List<SysMenu> selectByPids(@RequestParam("pmenuIds[]")String[] pmenuIds) {
		System.out.println(Arrays.toString(pmenuIds));
		List<SysMenu> list = sysMenuService.selectByPids(pmenuIds);
		System.out.println(list);
		
		return list;
	}
	
	@RequestMapping("/editPage")
	public String editPage(String menuId, String type, Model model) {
		
		SysMenu menu = sysMenuService.queryById(menuId);
		model.addAttribute("menu", menu);	
		
		model.addAttribute("type", type);
		List<SysMenu> parList = new ArrayList<>(); 
		if ("0".equals(type)) {
			parList.add(sysMenuService.queryById("0"));
			
		} else {
			parList = sysMenuService.queryPar();		
			
		}		
		model.addAttribute("parList", parList);
		return "sysmenu/edit_menu";
	}
	
	@RequestMapping("/editSave")
	@ResponseBody
	public String editSave(SysMenu menu) {		
		
		int count = sysMenuService.update(menu);
		System.out.println("menu:" + count);
		return "true";
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		System.out.println("ids:" + Arrays.toString(ids));
		int count = sysMenuService.dels(ids);
		System.out.println("dels:" + count);
		return "redirect:query";
	}
}
