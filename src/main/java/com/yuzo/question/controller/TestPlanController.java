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
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.Teacher;
import com.yuzo.question.entity.TestPlan;
import com.yuzo.question.service.ISubjUnitService;
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

		return "testplan/add_plan";
	}
//	
//	@RequestMapping("addSave")
//	public String addSave(
//					SubjUnit unit
//					//,@RequestParam("unitPicUrl")CommonsMultipartFile picFile
//					, HttpSession session
//				) throws IllegalStateException, IOException {
//		// �ϴ�logoͼƬ
//		ServletContext app = session.getServletContext();
////		if(picFile != null) {
////			System.out.println("picFile-fileName��" + picFile.getOriginalFilename());
////			String picRootPath = app.getRealPath("/upload/unit/pic/");
////	        String picPath = new Date().getTime() + picFile.getOriginalFilename();	         
////	        File sctnPicFile = new File(picRootPath + picPath);
////	        //ͨ��CommonsMultipartFile�ķ���ֱ��д�ļ���ע�����ʱ��
////	        picFile.transferTo(sctnPicFile);
////	        unit.setSubjUnitLogoUrl("/upload/unit/pic/" + picPath);
////		}
//		unit.setSubjUnitId(UUID.randomUUID().toString());
//		int count = subjUnitService.save(unit);
//		
//		System.out.println("unit:" + count);
//		
//		return "redirect:query";
//	}
//	
//	@RequestMapping("/editPage")
//	public String editPage(String subjUnitId,HttpSession session, Model model) {
//		
//		SubjUnit unit = subjUnitService.queryById(subjUnitId);
//		model.addAttribute("unit", unit);	
//		Teacher tch = (Teacher) session.getAttribute("tch");
//		String tchId = "1"; // tch.getTchId()
//		model.addAttribute("tchId", tchId);
//		List<SubjectCourse> subjList = subjUnitService.querySubjectCourse();
//		model.addAttribute("subjList", subjList);
//		return "subjunit/edit_unit";
//	}
//	
//	@RequestMapping("/editSave")
//	public String editSave(SubjUnit unit) {		
//		
//		int count = subjUnitService.update(unit);
//		System.out.println("��ɾ��:" + count);
//		return "redirect:query";
//	}
//	
//	@RequestMapping("/dels")
//	public String dels(String[] ids) {		
//		System.out.println("ids:" + Arrays.toString(ids));
//		int count = subjUnitService.dels(ids);
//		System.out.println("��ɾ��:" + count);
//		return "redirect:query";
//	}
}
