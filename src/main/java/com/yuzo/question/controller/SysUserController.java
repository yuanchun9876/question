package com.yuzo.question.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuzo.question.entity.StuLevel;
import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SysRole;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.SysUserRole;
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
		System.out.println(list);
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
		

		List<SysUser> list = userService.queryByMcId(mcId );
		System.out.println("/sysuser/querybymc:" + list);
		model.addAttribute("list", list);
		return "sysuser/list_mc_user";
	}
	
	@RequestMapping("/sysuser/queryStuByMc")
	@ResponseBody
	public List<SysUser> queryStuByMc(String mcId, Model model) {
			
		List<SysUser> list = userService.queryByMcId(mcId );
		System.out.println("/sysuser/querybymc:" + list);
		
		return list;
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
	
	@RequestMapping("/sysuser/setName")
	public String setName(String userId, Model model) {
		
		int count = userService.setName(userId);

		return "redirect:query";
	}
	
	@RequestMapping("/sysuser/setlevel")
	public String setlevel(String userId, Model model) {
		
		StuLevel user = userService.querySlById(userId);
		System.out.println(user);
		if(user == null ) {
			SysUser u = userService.queryById(userId);
			user = new StuLevel();
			user.setNickName(u.getNickName());
			user.setUserCrseLevel("");
			user.setUserId(u.getUserId());
			user.setUserName(u.getUserName());
		}
		model.addAttribute("user", user);
		
		
		List<StudyCourse> crseList = userService.queryCrse();
		//System.out.println(user);
		model.addAttribute("crseList", crseList);
		
		return "sysuser/set_user_level";
	}
	
	
	@RequestMapping("/sysuser/saveUserLevel")
	public String saveUserLevel(StuLevel sl ) {
		
		int count = userService.saveSl(sl);	
		return "redirect:query";
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
	
	@RequestMapping("/sysuser/singleUserName")	
	@ResponseBody
	public String singleUserName(String userName) {
		
		List<SysUser> userList = userService.queryByName(userName);
		if (userList!=null && userList.size()>0) {
			return "no";
		} else {
			return "yes";
		}
	}
	
	@RequestMapping("/sysuser/editUserRole")
	public String editUserMc(String userId, String[] ids) {		
		
	
		int count = userService.updateUserRole(userId, ids);
		//System.out.println(":" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/sysuser/rolepage")
	public String rolepage(String userId, Model model) {		
		SysUser user = userService.queryById(userId);
		System.out.println(user);
		model.addAttribute("user", user);
		
		List<SysUserRole> urList = userService.queryUserRole(user.getUserId());
		System.out.println(urList);
		model.addAttribute("urList", urList);	
		
		List<SysRole> rolelist = userService.queryRoleList(urList);
		System.out.println(rolelist);
		model.addAttribute("rolelist", rolelist);	
		
		return "sysuser/edit_role_user";
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
	
	
	@RequestMapping("/sysuser/updatePass")
	public String updatePass(HttpServletRequest request,  Model model) {
		
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		
		model.addAttribute("user", user);
		return "sysuser/edit_pass_user";
	}

	
	@RequestMapping("/sysuser/checkpass")
	@ResponseBody
	public String checkpass(String oldPass, HttpServletRequest request) {
		
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		if (user.getUserPass().equals(oldPass)) {
			return "yes";
		} else {
			return "no";
		}
	}
	
	@RequestMapping("/sysuser/editPassSave")
	@ResponseBody
	public String editPassSave(SysUser user, HttpServletRequest request) {
		
		System.out.println(user);
		int count = userService.update(user);
		if (count > 0) {
			return "true";
		} else {
			return "false";
		}
		
	}
	
	@RequestMapping("/sysuser/editFaceSave")
	@ResponseBody
	public String editFaceSave(SysUser user, HttpServletRequest request) {
		
		System.out.println(user);
		int count = userService.update(user);
		if (count > 0) {
			return "true";
		} else {
			return "false";
		}
		
	}
	@RequestMapping("/sysuser/editPhoneSave")
	@ResponseBody
	public String editPhoneSave(SysUser user, HttpServletRequest request) {
		
		System.out.println(user);
		int count = userService.update(user);
		if (count > 0) {
			return "true";
		} else {
			return "false";
		}
		
	}
	@RequestMapping("/sysuser/editNickSave")
	@ResponseBody
	public String editNickSave(SysUser user, HttpServletRequest request) {
		
		System.out.println(user);
		int count = userService.update(user);
		if (count > 0) {
			return "true";
		} else {
			return "false";
		}
		
	}
	
	@RequestMapping("/sysuser/updateFace")
	public String updateFace(HttpServletRequest request,  Model model) {
		
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		
		model.addAttribute("user", user);
		return "sysuser/edit_face_user";
	}
	@RequestMapping("/sysuser/updatePhone")
	public String updatePhone(HttpServletRequest request,  Model model) {
		
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		
		model.addAttribute("user", user);
		return "sysuser/edit_phone_user";
	}
	@RequestMapping("/sysuser/updateNick")
	public String updateNick(HttpServletRequest request,  Model model) {
		
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		
		model.addAttribute("user", user);
		return "sysuser/edit_nick_user";
	}
	

	/**
	 * 
	* @Title: checkCustomertTel  
	* @Description: 验证手机号是否重复
	* @param @param tel
	* @param @return    
	* @return Boolean     
	* @throws
	*         
	 */
	@RequestMapping("/sysuser/checkCustomertTel")
	@ResponseBody
	public JSONObject checkCustomertTel(String tel, HttpSession session) {
		return userService.checkCustomertTel(tel, session);
	}

	
	/**
	 * 
	* @Title: checkSMSCode  
	* @Description: 验证短信验证码
	* @param @param smsCode
	* @param @return    
	* @return Boolean     
	* @throws
	 */
	@RequestMapping("/sysuser/checkSMSCode")
	@ResponseBody
	public JSONObject checkSMSCode(String smsCode, HttpSession session) {
		return userService.checkSMSCode(smsCode, session);
	}
	
	
	/**
	 * @throws ClientException 
	 * 
	* @Title: sendCode  
	* @Description: 发送短信验证码
	* @param @return    
	* @return JSONObject     
	* @throws
	 */
	@RequestMapping("/sysuser/sendCode")
	@ResponseBody
	public JSONObject sendCode(String tel, HttpSession session)  {
		return userService.sendCode(tel, session);
	}
	
	
	/**
	 * 
	* @Title: sendCode  
	* @Description: 用户注册
	* @param @return    
	* @return JSONObject     
	* @throws
	 */
	@RequestMapping("/sysuser/registerUser")
	@ResponseBody
	public JSONObject registerUser(SysUser user, HttpSession session)  {
		System.out.println("user:" + user);
		return userService.registerUser(user,  session);
	}
	
}
