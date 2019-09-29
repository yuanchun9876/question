package com.yuzo.question.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.StudyCourseQuestion;
import com.yuzo.question.entity.StudyPeriod;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.entity.SysRole;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.Teacher;
import com.yuzo.question.entity.UserAnswerList;
import com.yuzo.question.service.IStuCrseService;
import com.yuzo.question.service.IStudyCourseService;
import com.yuzo.question.service.ISubjUnitService;
import com.yuzo.question.service.ISysRoleService;

@Controller
@RequestMapping("/stucrse")
public class StuCrseController {
	
	static Logger logger = Logger.getLogger(StuCrseController.class);
	
	@Autowired
	private IStuCrseService  stuCrseService;
	
	@RequestMapping("query")
	public String query(Model model) {
		
		List<StudyCourse> list = stuCrseService.queryStudyCourse();
		model.addAttribute("list", list);
		return "stucrse/list_stucrse";
	}
	
	
	@RequestMapping("openCrseQstnPage")
	public String openCrseQstnPage(String crseId, Model model) {
		StudyCourse crse = stuCrseService.queryCrseById(crseId);
		model.addAttribute("crse", crse);
		int flag = crse.getQstnFlag();
		
		int qc0 = crse.getQstnCount0();		
		//int qc1 = crse.getQstnCount1();		
		int qc2 = crse.getQstnCount2();		
		//int qc3 = crse.getQstnCount3();		
		//int qc4 = crse.getQstnCount4();	
		
		System.out.println("sum-qc0:" + qc0 );
		System.out.println("sum-qc2:" + qc2 );
		
		int sum = 20;
		int q0size = 0;
		int q2size = 0;
		
		List<Question> qsListFlag0 = stuCrseService.queryQstnFlag(crseId, "0" ,"checked");
		//List<Question> qsListFlag1 = stuCrseService.queryQstnFlag(crseId, "1" ,"checked");
		List<Question> qsListFlag2 = stuCrseService.queryQstnFlag(crseId, "2" ,"checked");
		//List<Question> qsListFlag3 = stuCrseService.queryQstnFlag(crseId, "3" ,"checked");
		//List<Question> qsListFlag4 = stuCrseService.queryQstnFlag(crseId, "4" ,"checked");
		
	
		
		List<Question> qsListNotFlag0 = stuCrseService.queryQstnFlag(crseId, "0", "false");
		//List<Question> qsListNotFlag1 = stuCrseService.queryQstnFlag(crseId, "1", "false");
		List<Question> qsListNotFlag2 = stuCrseService.queryQstnFlag(crseId, "2", "false");
		//List<Question> qsListNotFlag3 = stuCrseService.queryQstnFlag(crseId, "3", "false");
		//List<Question> qsListNotFlag4 = stuCrseService.queryQstnFlag(crseId, "4", "false");
		
		if (qsListFlag0 != null &&  qsListFlag0.size()>0) {
			q0size = (int) (Math.random()*(qc0-qsListFlag0.size() + 1 ));
			
			
			
			if (qsListFlag2!=null  &&  qsListFlag2.size() >0) {
				q2size = sum - qsListFlag2.size() - qsListFlag0.size() - q0size;
								
				Collections.shuffle(qsListNotFlag2);
				qsListFlag2.addAll(qsListNotFlag2.subList(0, q2size));
			} else {
				q2size = sum - q0size - qsListFlag0.size();
				
				Collections.shuffle(qsListNotFlag2);
				qsListFlag2 = qsListNotFlag2.subList(0, q2size);
			}
			Collections.shuffle(qsListNotFlag0);		
			qsListFlag0.addAll(qsListNotFlag0.subList(0, q0size));
			
			
		} else {
			q0size = (int) (Math.random()*(qc0 + 1));
			if (qsListFlag2!=null  &&  qsListFlag2.size() >0) {
				q2size = sum - qsListFlag2.size() - qsListFlag0.size() - q0size;
				
				Collections.shuffle(qsListNotFlag2);
				qsListFlag2.addAll(qsListNotFlag2.subList(0, q2size));
				
			} else {
				q2size = sum - q0size - qsListFlag0.size();
				
				Collections.shuffle(qsListNotFlag2);
				qsListFlag2 = qsListNotFlag2.subList(0, q2size);
			}
			Collections.shuffle(qsListNotFlag0);
			qsListFlag0 = qsListNotFlag0.subList(0, q0size);
		}

		
		//qsListFlag0.addAll(qsListNotFlag0.subList(0, q0size));
		List<Question> ql0 = stuCrseService.addAnswerByQstn(qsListFlag0);
		Collections.shuffle(ql0);
		model.addAttribute("qstnList0", ql0);
		Collections.shuffle(qsListFlag2);	
		model.addAttribute("qstnList2", qsListFlag2);

		return "stucrse/open_crse_test";
	}

	
	@RequestMapping("/answerSave")
	public String answerSave(String crseId, String[] qstns0,String[] ans0, String[] qstns2,String[] ans2, String[] qstns4,String[] ans4, HttpServletRequest request, Model model) {
		
		System.out.println(Arrays.toString(qstns0));
		System.out.println(Arrays.toString(ans0));
		System.out.println(Arrays.toString(qstns2));
		System.out.println(Arrays.toString(ans2));
		System.out.println("crseId:" + crseId);
			
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		
		stuCrseService.saveAnswer(user, crseId, qstns0, ans0, qstns2, ans2);
//		
//		if ("3".equals(tpType)) {
//			return "redirect:userplanlist3";
//		} else {
//			return "redirect:userplanlist0";
//		}
		return "redirect:query";
	}
	
//	@RequestMapping("addSave")
//	public String addSave(StudyCourse crse) {
//
//		crse.setCrseId(UUID.randomUUID().toString());
//	
//		int count = stuCrseService.save(crse);
//		
//		System.out.println("role:" + count);
//		
//		return "redirect:query";
//	}
//	
//	@RequestMapping("/editPage")
//	public String editPage(String crseId,HttpSession session, Model model) {
//		
//		StudyCourse crse = stuCrseService.queryById(crseId);
//		model.addAttribute("crse", crse);	
//		
//		List<StudyPeriod> pdList = stdycrseService.queryPeriod();
//		model.addAttribute("pdList", pdList);
//	
//		return "stdycrse/edit_crse";
//	}
//	
//
//
//	@RequestMapping("/editSave")
//	public String editSave(StudyCourse crse) {		
//		
//		int count = stuCrseService.update(crse);
//		System.out.println("role:" + count);
//		return "redirect:query";
//	}
//	
//	@RequestMapping("/dels")
//	public String dels(String[] ids) {		
//		System.out.println("ids:" + Arrays.toString(ids));
//		int count = stuCrseService.dels(ids);
//		System.out.println("dels:" + count);
//		return "redirect:query";
//	}
}


