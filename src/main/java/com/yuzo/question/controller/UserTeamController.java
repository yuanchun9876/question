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
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.page.QuestionPage;
import com.yuzo.question.page.UserTeamPage;
import com.yuzo.question.service.IUserTeamService;

@Controller
@SessionAttributes("teampage")
public class UserTeamController {

	@Autowired
	private IUserTeamService  userTeamService;
	
	/**
	 * 初始化分页对象,并放到model里
	 */
	@ModelAttribute("teampage")
	public UserTeamPage initPage() {
		return new UserTeamPage();
	}
	
	@RequestMapping("/usertm/query")
	public String querymc(@ModelAttribute("teampage")UserTeamPage page, Model model,String clearpage) {
		if (clearpage != null) {
			BeanUtils.copyProperties(new UserTeamPage(), page);
		}
		//	
		System.out.println("page: " + page);
		
		model.addAttribute("page", page);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());		
		List<UserTeam> list = userTeamService.querytm(page);
		
		PageInfo<UserTeam> pageInfo = new PageInfo<UserTeam>(list);
        model.addAttribute("pageInfo",pageInfo);
        
    	List<UserMyclass> mclist = userTeamService.querymc();
		System.out.println(mclist);
		model.addAttribute("mclist", mclist);	
        
		return "userteam/list_tm";
	}
	
	@RequestMapping("/usertm/selectTm")
	@ResponseBody
	public List<UserTeam> selectTm(String mcId) {
		System.out.println("mcId:" + mcId);
		List<UserTeam> tmlist = userTeamService.queryTmByMc(mcId);
		System.out.println(tmlist);	
		return tmlist;
	}
	
	@RequestMapping("/usertm/addPage")
	public String addPage(HttpSession session, Model model) {
		List<UserMyclass> mclist = userTeamService.querymc();
		System.out.println(mclist);
		model.addAttribute("mclist", mclist);	
		return "userteam/add_tm";
	}
	
	@RequestMapping("/usertm/addSave")
	public String addSave(UserTeam tm) throws IllegalStateException, IOException {
		System.out.println("tm:" + tm);
		int count = userTeamService.save(tm);		
		System.out.println("usertm:" + count);		
		return "redirect:query";
	}
	
	@RequestMapping("/usertm/editPage")
	public String editPage(String tmId, Model model) {
		
		UserTeam tm = userTeamService.queryById(tmId);
		System.out.println(tm);
		model.addAttribute("tm", tm);
		
		List<UserMyclass> mclist = userTeamService.querymc();
		System.out.println(mclist);
		model.addAttribute("mclist", mclist);	
		
		return "userteam/edit_tm";
	}
	
	@RequestMapping("/usertm/editSave")
	public String editSave(UserTeam tm) {
		
		int count = userTeamService.update(tm);	
		return "redirect:query";
	}
	
	@RequestMapping("/usertm/dels")
	public String dels(String[] ids) {		
		int count = userTeamService.dels(ids);
		System.out.println(":" + count);
		return "redirect:query";
	}
	
}
