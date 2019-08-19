package com.yuzo.question.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserReplyList;
import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.UserUpdatePointsType;
import com.yuzo.question.entity.WorkList;
import com.yuzo.question.page.SysUserPage;
import com.yuzo.question.service.ISubjectCourseService;
import com.yuzo.question.service.ISysUserService;
import com.yuzo.question.service.IUserUpdatePointsService;
import com.yuzo.question.service.IUserUpdateTypeService;

@Controller
@RequestMapping("/updatepoints")
@SessionAttributes("userpage")
public class UserUpdatePointsController {

	@Autowired
	private IUserUpdatePointsService  userUpdatePointsService;
	
	@Autowired
	private ISysUserService  userService;
	
	/**
	 * 初始化分页对象,并放到model里
	 */
	@ModelAttribute("userpage")
	public SysUserPage initPage() {
		return new SysUserPage();
	}
	
	@RequestMapping("/query")
	public String query(@ModelAttribute("userpage")SysUserPage page, Model model,String clearpage) {
		
		if (clearpage != null) {
			BeanUtils.copyProperties(new SysUserPage(), page);
		}
		//	
		System.out.println("userpage: " + page);
		
		model.addAttribute("page", page);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());		
		List<SysUser> list = userService.queryPage(page);
		System.out.println(list);
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
        model.addAttribute("pageInfo",pageInfo);
        
    	List<UserTeam> tmlist = userService.querytm();
		System.out.println(tmlist);
		model.addAttribute("tmlist", tmlist);	
		
    	List<UserMyclass> mclist = userService.querymc();
		System.out.println(mclist);
		model.addAttribute("mclist", mclist);	
		
		return "updatepoints/list_uup";
	}
	
	@RequestMapping("/replypage")
	public String replypage(String userId, Model model) {
		SysUser user = userService.queryById(userId);
		model.addAttribute("user", user);	
		
		List<UserReplyList> replyList = userUpdatePointsService.queryReplyByUserId(userId);
		
		model.addAttribute("replyList", replyList);	
		
		return "updatepoints/list_reply_uup";
	}
	
	@RequestMapping("/uuppage")
	public String uuppage(String userId, Model model) {
		SysUser user = userService.queryById(userId);
		model.addAttribute("user", user);	
		
		List<UserUpdatePoints> uupList = userUpdatePointsService.queryUupByUserId(userId);
		
		model.addAttribute("uupList", uupList);	
		
		return "updatepoints/list_uup_uup";
	}
	
	
	@RequestMapping("addPage")
	public String addPage(String userId,Model model) {
		
		SysUser user = userService.queryById(userId);
		model.addAttribute("user", user);	
		
		List<UserUpdatePointsType> uuptList = userUpdatePointsService.queryUupt();
		model.addAttribute("uuptList", uuptList);	
		
		List<WorkList> wlList = userUpdatePointsService.queryWl();
		model.addAttribute("wlList", wlList);
		
		return "updatepoints/add_uup";
	}
	
	@RequestMapping("addSave")
	public String addSave(UserUpdatePoints uup){

		uup.setUupId(UUID.randomUUID().toString());
		int count = userUpdatePointsService.save(uup);
		
		System.out.println("uupt:" + count);
		
		return "redirect:query";
	}
	
	@RequestMapping("/editPage")
	public String editPage(String userId, String uupId,HttpSession session, Model model) {
		SysUser user = userService.queryById(userId);
		model.addAttribute("user", user);	
		
		List<UserUpdatePointsType> uuptList = userUpdatePointsService.queryUupt();
		model.addAttribute("uuptList", uuptList);	
		
		System.out.println(uupId);
		UserUpdatePoints uup = userUpdatePointsService.queryUupById(uupId);
		System.out.println(uup);
		model.addAttribute("uupt", uup);
		
		List<WorkList> wlList = userUpdatePointsService.queryWl();
		model.addAttribute("wlList", wlList);
		
		return "updatepoints/edit_uup";
	}
	
	@RequestMapping("/editSave")
	public String editSave(UserUpdatePoints uup ) {
		System.out.println(uup);
		int count = userUpdatePointsService.update(uup);
	
		return "redirect:query";
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		int count = userUpdatePointsService.dels(ids);
		System.out.println("uupt:" + count);
		return "redirect:query";
	}
	
}
