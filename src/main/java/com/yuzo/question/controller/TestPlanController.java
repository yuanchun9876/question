package com.yuzo.question.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.TestPlan;
import com.yuzo.question.service.ITestPlanService;

@Controller
@RequestMapping("testplan")
public class TestPlanController {
	
	static Logger logger = Logger.getLogger(TestPlanController.class);
	
	@Autowired
	private ITestPlanService  testPlanService;
	
	@RequestMapping("query")
	public String query(Model model) {
		
		List<TestPlan> list = testPlanService.queryAll();
		model.addAttribute("list", list);
		return "testplan/list_plan";
	}
	
	

	@RequestMapping("addPage")
	public String addPage(HttpSession session, Model model) {
	
		return "testplan/add_plan";
	}
	
	@RequestMapping("addSave")
	public String addSave( TestPlan plan )  {

		plan.setTpId(UUID.randomUUID().toString());
		plan.setTpDate(new Date());
		plan.setTpTarget("");
		int count = testPlanService.save(plan);
		
		System.out.println("unit:" + count);
		
		return "redirect:query";
	}
	
	@RequestMapping("/editPage")
	public String editPage(String tpId, Model model) {
		
		TestPlan plan = testPlanService.queryById(tpId);
		model.addAttribute("plan", plan);	

		return "testplan/edit_plan";
	}
	
	@RequestMapping("/setPage")
	public String setPage(String tpId, Model model) {
		
		TestPlan plan = testPlanService.queryById(tpId);
		model.addAttribute("plan", plan);	
		
		List<QstnFromType> qstnFromList = testPlanService.queryQstnFrom();
		model.addAttribute("qstnFromList", qstnFromList);
		List<QuestionType> qstnTypeList = testPlanService.queryQstnType();
		model.addAttribute("qstnTypeList", qstnTypeList);
		
		List<SubjectCourse> subjList = testPlanService.querySubj();
		model.addAttribute("subjList", subjList);
		List<SubjUnit> subjUnitList = testPlanService.querySubjUnit();
		model.addAttribute("subjUnitList", subjUnitList);
		List<SubjSection> subjSctnList = testPlanService.querySubjSctn();
		model.addAttribute("subjSctnList", subjSctnList);
		
		return "testplan/set_plan";
	}
	
	
	@RequestMapping("/editSave")
	public String editSave(TestPlan plan) {		
		
		int count = testPlanService.update(plan);
		System.out.println(":" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		System.out.println("ids:" + Arrays.toString(ids));
		int count = testPlanService.dels(ids);
		System.out.println(":" + count);
		return "redirect:query";
	}
}
