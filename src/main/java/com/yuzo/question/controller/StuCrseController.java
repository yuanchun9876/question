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
import com.yuzo.question.entity.StuCrseList;
import com.yuzo.question.entity.StuCrseTest;
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
	
	@RequestMapping("ajaxCharsCrse")
	@ResponseBody
	public Map<String, Object> ajaxCharsCrse(String crseId, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		List<StuCrseTest> list = stuCrseService.querySctByCrseId(crseId, user.getUserId());
		StudyCourse crse = stuCrseService.queryCrseById(crseId);
		map.put("crseName", crse.getCrseName());
		String[] sctNums = new String[list.size()];
		Integer[] sctTotals = new Integer[list.size()];
		for (int i = 0; i < list.size(); i++) {
			StuCrseTest sct = list.get(i);
			sctNums[i] = "第" + sct.getSctNum() + "次";
			sctTotals[i] = sct.getSctTotal();
		}
		map.put("sctNums", sctNums);
		map.put("sctTotals", sctTotals);
				
		return map;
		
	}
	@RequestMapping("ajaxCharsCrseBySctn")
	@ResponseBody
	public Map<String, Object> ajaxCharsCrseBySctn(String crseId, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		
//		List<StuCrseTest> sctList = stuCrseService.querySctByCrseId(crseId, user.getUserId());
//		
//		List<StuCrseList> sclList = stuCrseService.querySclByCrseAndUser(crseId, user.getUserId());
		
		List<Map<String, Object>> sclCountList = stuCrseService.querySclCountByCrseAndUser(crseId, user.getUserId());
		// qstn_count,SUBJ_SCTN_ID,SUBJ_SCTN_TITLE
		System.out.println(sclCountList);
		// 知识节
		Integer[] sctn_yes = new Integer[sclCountList.size()];
		Integer[] sctn_count = new Integer[sclCountList.size()];
		List<Map<String, Object>> sctnList = new ArrayList<>();
		List<Map<String, Object>> cList = new ArrayList<>();
	
		
		for (int i=0; i<sclCountList.size(); i++) {
			Map<String, Object> countMap = sclCountList.get(i);
			Map<String, Object> cMap = new HashMap<>();
			
			sctn_yes[i] = stuCrseService.totalSctnYes(crseId, user.getUserId(), countMap.get("SUBJ_SCTN_ID").toString());
			
			sctn_count[i] = Integer.parseInt(countMap.get("qstn_count").toString());
			cMap.put("text",countMap.get("SUBJ_SCTN_TITLE").toString());
			cMap.put("max",Integer.parseInt(countMap.get("qstn_count").toString()));
			cList.add(cMap);
		}
		
		System.out.println(sctnList);
		map.put("sctnList", sctnList);
		map.put("sctn_yes", sctn_yes);
		map.put("sctn_count", sctn_count);
		map.put("cList", cList);
		
		return map;
		
	}
	
	@RequestMapping("showQstnPage")
	public String showQstnPage(String sctId, Model model) {
		
		StuCrseTest sct = stuCrseService.queryById(sctId);
		model.addAttribute("sct", sct);
		
		List<StuCrseList> sclList0 = stuCrseService.queryStuCrseListByType(sctId, "0");		
		if(sclList0!=null && sclList0.size()>0) {
			System.out.println("sclList0:" + sclList0);
			sclList0 = stuCrseService.addAnswerByQstnForScl0(sclList0);
			model.addAttribute("sclList0", sclList0);
		}
		
		List<StuCrseList> sclList2 = stuCrseService.queryStuCrseListByType(sctId, "2");
		if(sclList2!=null && sclList2.size()>0) {
			sclList2 = stuCrseService.addAnswerByQstnForScl2(sclList2);
			model.addAttribute("sclList2", sclList2);
		}
		
		
		return "stucrse/show_crse_test";
	}
	
	@RequestMapping("showCrseQstnPage")
	public String showCrseQstnPage(String crseId, HttpServletRequest request, Model model) {
		
		StudyCourse crse = stuCrseService.queryCrseById(crseId);
		model.addAttribute("crse", crse);

		SysUser user = (SysUser) request.getSession().getAttribute("user");
//		System.out.println(user);
		
		List<StuCrseTest> list = stuCrseService.queryStuCrseTest(crseId, user.getUserId());
		model.addAttribute("list", list);
		
		return "stucrse/show_stucrsetest";
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


