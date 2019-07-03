package com.yuzo.question.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.service.IQuestionService;

@Controller
@RequestMapping("qstn")
public class QuestionController {
	
	private Logger logger = Logger.getLogger(QuestionController.class);
	
	@Autowired
	private IQuestionService qstnService;

	@RequestMapping("query")
	public String query(Model model){
		List<Question> list = qstnService.queryAll();
		model.addAttribute("list", list);
		return "qstn/list_qstn";
	}
	
	@RequestMapping("addPage")
	public String addPage(Model model){
		
		List<QstnFromType> qstnFromList = qstnService.queryQstnFrom();
		model.addAttribute("qstnFromList", qstnFromList);
		List<QuestionType> qstnTypeList = qstnService.queryQstnType();
		model.addAttribute("qstnTypeList", qstnTypeList);
		
		List<SubjectCourse> subjList = qstnService.querySubj();
		model.addAttribute("subjList", subjList);
		List<SubjUnit> subjUnitList = qstnService.querySubjUnit();
		model.addAttribute("subjUnitList", subjUnitList);
		List<SubjSection> subjSctnList = qstnService.querySubjSctn();
		model.addAttribute("subjSctnList", subjSctnList);
				
		return "qstn/add_qstn";
	}
	

	@RequestMapping("addSave")
	public String addSave(Question qstn, Model model){
		qstn.setQstnId(UUID.randomUUID().toString());
		qstn.setQstnInputTime(new Date());
		int count = qstnService.save(qstn);
		logger.debug("count:" + count);
		return "redirect:query";
	}
	
	@RequestMapping("editPage")
	public String editPage(String id,Model model){
		
		Question qstn = qstnService.queryById(id);
		model.addAttribute("qstn", qstn);
		List<QstnFromType> qstnFromList = qstnService.queryQstnFrom();
		model.addAttribute("qstnFromList", qstnFromList);
		List<QuestionType> qstnTypeList = qstnService.queryQstnType();
		model.addAttribute("qstnTypeList", qstnTypeList);
		List<SubjectCourse> subjList = qstnService.querySubj();
		model.addAttribute("subjList", subjList);
		List<SubjUnit> subjUnitList = qstnService.querySubjUnit();
		model.addAttribute("subjUnitList", subjUnitList);
		List<SubjSection> subjSctnList = qstnService.querySubjSctn();
		model.addAttribute("subjSctnList", subjSctnList);
		
		SubjSection sctn = qstnService.querySctnBySctnId(qstn.getSubjSctnId());
		String subjUnitId = sctn.getSubjUnitId();
		model.addAttribute("subjUnitId", subjUnitId );
		SubjUnit unit = qstnService.queryUnitByUnitId(subjUnitId);
		String subjId = unit.getSubjId();
		model.addAttribute("subjId", subjId );
		
		return "qstn/edit_qstn";
	}
	

	@RequestMapping("/editSave")
	public String editSave(Question qstn, Model model){
		//qstn.setQstnId(UUID.randomUUID().toString());
		//qstn.setQstnInputTime(new Date());
		int count = qstnService.update(qstn);
		logger.debug("count:" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		int count = qstnService.dels(ids);
		System.out.println("��ɾ��:" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/uploadSimditorImg")
	@ResponseBody
	public JSONObject uploadSimditorImg(MultipartFile file, String type, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		try {
		
			json = qstnService.uploadSimditorImg(file,  type );
		} catch (Exception e) {
			logger.debug("异常:" + e);
		}
		logger.debug("json:" + json);
		return json;
	}

	
	@RequestMapping("/answerpage")
	public String answerpage(String id,Model model){
		
		List<Answer> ansList = qstnService.queryAnswersByQstnId(id);
		model.addAttribute("ansList", ansList);
		
		return "ans/list_ans";
	}
}
