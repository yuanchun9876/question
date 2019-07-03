package com.yuzo.question.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzo.question.entity.Answer;
import com.yuzo.question.service.IAnswerService;

@Controller
@RequestMapping("/ans")
public class AnswerController {
	
	private Logger logger = Logger.getLogger(AnswerController.class);
	
	@Autowired
	private IAnswerService ansService;
	
	@RequestMapping("/query")
	public String answerpage(String id,Model model){
		
		List<Answer> ansList = ansService.queryByQstnId(id);
		model.addAttribute("list", ansList);
		
		return "ans/list_ans";
	}

}
