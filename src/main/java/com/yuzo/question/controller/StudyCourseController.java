package com.yuzo.question.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.StudyCourseQuestion;
import com.yuzo.question.entity.StudyPeriod;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.entity.SysRole;
import com.yuzo.question.entity.Teacher;
import com.yuzo.question.service.IStudyCourseService;
import com.yuzo.question.service.ISubjUnitService;
import com.yuzo.question.service.ISysRoleService;

@Controller
@RequestMapping("/stdycrse")
public class StudyCourseController {
	
	static Logger logger = Logger.getLogger(StudyCourseController.class);
	
	@Autowired
	private IStudyCourseService  stdycrseService;
	
	@RequestMapping("query")
	public String query(Model model) {
		
		List<StudyCourse> list = stdycrseService.queryAll();
		model.addAttribute("list", list);
		return "stdycrse/list_crse";
	}
	
	
	@RequestMapping("addPage")
	public String addPage(Model model) {
		List<StudyPeriod> pdList = stdycrseService.queryPeriod();
		model.addAttribute("pdList", pdList);
		return "stdycrse/add_crse";
	}
	
	@RequestMapping("addSave")
	public String addSave(StudyCourse crse) {

		crse.setCrseId(UUID.randomUUID().toString());
	
		int count = stdycrseService.save(crse);
		
		System.out.println("role:" + count);
		
		return "redirect:query";
	}
	
	@RequestMapping("/editPage")
	public String editPage(String crseId,HttpSession session, Model model) {
		
		StudyCourse crse = stdycrseService.queryById(crseId);
		model.addAttribute("crse", crse);	
		
		List<StudyPeriod> pdList = stdycrseService.queryPeriod();
		model.addAttribute("pdList", pdList);
	
		return "stdycrse/edit_crse";
	}
	
	@RequestMapping("/setsctnpage")
	public String setsctnpage(String crseId, Model model) {
		
		StudyCourse crse = stdycrseService.queryById(crseId);
		model.addAttribute("crse", crse);	
			
		List<SubjectCourse> subjList = stdycrseService.querySubj();
		model.addAttribute("subjList", subjList);
		List<SubjUnit> subjUnitList = stdycrseService.querySubjUnit();
		model.addAttribute("subjUnitList", subjUnitList);
		List<SubjSection> subjSctnList = stdycrseService.querySubjSctn();
		model.addAttribute("subjSctnList", subjSctnList);		
		return "stdycrse/set_sctn_crse";
	}
	
	
	
	@RequestMapping("/setSctnSave")
	public String setSctnSave(String crseId, String[] sctnIds, Model model) {		
		int count = stdycrseService.setCrseSctn(crseId, sctnIds);			
		return "redirect:query";
	}

	@RequestMapping("/setqstnpage")
	public String setqstnpage(String crseId, Model model) {
		
		StudyCourse crse = stdycrseService.queryById(crseId);
		model.addAttribute("crse", crse);	
		
		List<StudyCourseQuestion> scqList = stdycrseService.queryScqByCrseId(crseId);
		model.addAttribute("scqList", scqList);	
		
		return "stdycrse/set_qstn_crse";
	}
	
	@RequestMapping("/setqstnSave")
	public String setqstnSave(String crseId, String[] qstns, Model model) {		
		int count = stdycrseService.setCrseQstn(crseId, qstns);			
		return "redirect:query";
	}

	@RequestMapping("/editSave")
	public String editSave(StudyCourse crse) {		
		
		int count = stdycrseService.update(crse);
		System.out.println("role:" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		System.out.println("ids:" + Arrays.toString(ids));
		int count = stdycrseService.dels(ids);
		System.out.println("dels:" + count);
		return "redirect:query";
	}
}
