package com.yuzo.question.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.service.IAnswerService;

@Controller
@RequestMapping("/ans")
public class AnswerController {
	
	private Logger logger = Logger.getLogger(AnswerController.class);
	
	@Autowired
	private IAnswerService ansService;
	
	@RequestMapping("/query")
	public String answerpage(String id,Model model){	
		logger.debug("id:::" + id);
		Question qstn = ansService.queryQstnById(id);
		model.addAttribute("qstn", qstn);		
		List<Answer> ansList = ansService.queryByQstnId(id);
		model.addAttribute("list", ansList);	
		
		return "ans/list_ans";
	}
	
	@RequestMapping("addPage")
	public String addPage(String qstnId, Model model) {
		
		model.addAttribute("qstnId", qstnId);
		return "ans/add_ans";
	}
	
	@RequestMapping("addSave")
	public String addSave(Answer ans)  {	
		ans.setAnsId(UUID.randomUUID().toString());
		int count = ansService.save(ans);		
		return "redirect:query?id=" + ans.getQstnId();
	}
	
	@RequestMapping("/editPage")
	public String editPage(String id, Model model) {		
		Answer ans = ansService.queryById(id);
		model.addAttribute("ans", ans);		
		
		return "ans/edit_ans";
	}
	
	@RequestMapping("/editSave")
	public String editSave(Answer ans) {	
		int count = ansService.update(ans);
		return "redirect:query?id=" + ans.getQstnId();
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {	
		Answer ans = ansService.queryById(ids[0]);
		int count = ansService.dels(ids);	
		return "redirect:query?id=" + ans.getQstnId();
	}

}
