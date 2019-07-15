package com.yuzo.question.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.page.SysUserPage;
import com.yuzo.question.service.ISysUserService;

@Controller
@SessionAttributes("userpage")
public class SysUserController {

	@Autowired
	private ISysUserService  userService;
	
	/**
	 * 初始化分页对象,并放到model里
	 */
	@ModelAttribute("userpage")
	public SysUserPage initPage() {
		return new SysUserPage();
	}
	
	@RequestMapping("/sysuser/query")
	public String query(@ModelAttribute("userpage")SysUserPage page, Model model,String clearpage) {
		if (clearpage != null) {
			BeanUtils.copyProperties(new SysUserPage(), page);
		}
		//	
		System.out.println("userpage: " + page);
		
		model.addAttribute("page", page);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());		
		List<SysUser> list = userService.queryPage(page);
		
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
        model.addAttribute("pageInfo",pageInfo);
        
    	List<UserTeam> tmlist = userService.querytm();
		System.out.println(tmlist);
		model.addAttribute("tmlist", tmlist);	
		
    	List<UserMyclass> mclist = userService.querymc();
		System.out.println(mclist);
		model.addAttribute("mclist", mclist);	
		
		return "sysuser/list_user";
	}
	@RequestMapping("/sysuser/querybymc")
	public String querybymc(String mcId, Model model) {
		
		SysUserPage page = new SysUserPage();
		page.setMcId(mcId);
		List<SysUser> list = userService.queryPage(page );
		model.addAttribute("list", list);
		return "sysuser/list_mc_user";
	}
	@RequestMapping("/sysuser/queryTmByUser")
	@ResponseBody
	public List<SysUser> queryTmByUser(String userId, Model model) {
		
		List<SysUser> list = userService.queryTmByUser(userId );
		return list;
	}
	
	@RequestMapping("/sysuser/addPage")
	public String addPage(HttpSession session, Model model) {
		List<UserTeam> tmlist = userService.querytm();
		System.out.println(tmlist);
		model.addAttribute("tmlist", tmlist);	
		
    	List<UserMyclass> mclist = userService.querymc();
		System.out.println(mclist);
		model.addAttribute("mclist", mclist);	
		
		return "sysuser/add_user";
	}
	
	@RequestMapping("/sysuser/addSave")
	public String addSave(SysUser tm, String mcId)  {
		System.out.println("tm:" + mcId);
		int count = userService.save(tm, mcId);		
		System.out.println("usertm:" + count);		
		return "redirect:query";
	}
	
	@RequestMapping("/sysuser/editPage")
	public String editPage(String userId, Model model) {
		
		SysUser user = userService.queryById(userId);
		System.out.println(user);
		model.addAttribute("user", user);
		
		List<UserTeam> tmlist = userService.querytm();
		System.out.println(tmlist);
		model.addAttribute("tmlist", tmlist);	
		
    	List<UserMyclass> mclist = userService.querymc();
		System.out.println(mclist);
		model.addAttribute("mclist", mclist);	
		
		return "sysuser/edit_user";
	}
	
	@RequestMapping("/sysuser/editSave")
	public String editSave(SysUser tm) {
		
		int count = userService.update(tm);	
		return "redirect:query";
	}
	
	@RequestMapping("/sysuser/dels")
	public String dels(String[] ids) {		
		int count = userService.dels(ids);
		System.out.println(":" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/sysuser/editUserMc")
	public String editUserMc(String userId, String mcId) {		
		int count = userService.updateUch(userId, mcId);
		System.out.println(":" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/sysuser/updatemc")
	public String updatemc(String userId, Model model) {
		
		SysUser user = userService.queryById(userId);
		System.out.println(user);
		model.addAttribute("user", user);
		
		List<UserTeam> tmlist = userService.querytm();
		System.out.println(tmlist);
		model.addAttribute("tmlist", tmlist);	
		
    	List<UserMyclass> mclist = userService.querymc();
		System.out.println(mclist);
		model.addAttribute("mclist", mclist);	
		
		return "sysuser/edit_user_mc";
	}
	@RequestMapping("/sysuser/editUserTm")
	public String editUserTm(SysUser user) {		
		int count = userService.update(user);
		System.out.println(":" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/sysuser/updatetm")
	public String updatetm(String userId, Model model) {
		
		SysUser user = userService.queryById(userId);
		System.out.println(user);
		model.addAttribute("user", user);
		
		List<UserTeam> tmlist = userService.querytm();
		System.out.println(tmlist);
		model.addAttribute("tmlist", tmlist);	
		
		List<UserMyclass> mclist = userService.querymc();
		System.out.println(mclist);
		model.addAttribute("mclist", mclist);	
		
		return "sysuser/edit_user_tm";
	}
	
}
