package com.yuzo.question.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.TestPlan;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.page.QuestionPage;
import com.yuzo.question.page.SubjSectionPage;
import com.yuzo.question.service.IQuestionService;
import com.yuzo.question.service.IUserReplyService;

@Controller
@RequestMapping("/userreply")
public class UserReplyController {
	

	@Autowired
	private IUserReplyService userReplyService;
	
	@RequestMapping("/openSetPage")
	public String openSetPage(Model model) {
		
		List<TestPlan> tplist = userReplyService.querytp();
		System.out.println(tplist);
		model.addAttribute("tplist", tplist);
		
		List<UserMyclass> mclist = userReplyService.querymc();
		System.out.println(mclist);
		model.addAttribute("mclist", mclist);	
		
		return "userreply/set_reply";
	}
	
	@RequestMapping("/openPage")
	public String openPage(String tpId, String mcId, Model model) {
		
		List<Question> list = userReplyService.queryQstnByTp(tpId);
		System.out.println(list);
		model.addAttribute("list", list);
		
		model.addAttribute("mcId", mcId);	
		
		return "userreply/set_reply";
	}

	

}
