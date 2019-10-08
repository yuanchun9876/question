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

import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.StuCrseList;
import com.yuzo.question.entity.StuCrseTest;
import com.yuzo.question.entity.StuLevel;
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
	public String query(Model model, HttpServletRequest request) {
		
		List<StudyCourse> list = stuCrseService.queryStudyCourse();
		model.addAttribute("list", list);
		
		SysUser u = (SysUser) request.getSession().getAttribute("user");
		
		StuLevel user = stuCrseService.querySlById(u.getUserId());
		System.out.println(user);
		if(user == null ) {
			
			user = new StuLevel();
			user.setNickName(u.getNickName());
			user.setUserCrseLevel("");
			user.setUserId(u.getUserId());
			user.setUserName(u.getUserName());
		}
		model.addAttribute("user", user);
		
		return "stucrse/list_stucrse";
	}
	
	@RequestMapping("doSubCrse")
	public String doSubCrse(String mcId, Model model) {
		
		List<StuLevel> list = stuCrseService.querySlsByMcId(mcId);
		model.addAttribute("list", list);
		
	
		
		return "stucrse/list_mc_level";
	}
	
	
	
	@RequestMapping("/ajaxCharsPlanMcUnit")
	@ResponseBody
	public Map<String, Object> ajaxCharsPlanMcUnit(String crseId,String mcId, Model model) {
		System.out.println(crseId + ":" + mcId);

		Map<String, Object> map = stuCrseService.querySclsByCrseAndMc(crseId, mcId);
	
		return map;
	}
	
	@RequestMapping("/ajaxCharsPlanMcSctn")
	@ResponseBody
	public Map<String, Object> ajaxCharsPlanMcSctn(String crseId,String mcId, Model model) {
		System.out.println(crseId + ":" + mcId);
		
		Map<String, Object> map = stuCrseService.querySctnsByCrseAndMc(crseId, mcId);
		
		
		return map;
	}
	
	@RequestMapping("showAnsPage")
	public String showQstnPage(String crseId, String mcId, String qstnId, Model model) {
		
		Question qstn = stuCrseService.queryQstnById(qstnId);
		model.addAttribute("qstn", qstn);		
		List<Answer> ansList = stuCrseService.queryByQstnId(qstnId);
		System.out.println(ansList);
		model.addAttribute("list", ansList);	
		
		List<StuCrseList> sclList = stuCrseService.totalUal(crseId, mcId, qstnId);
		System.out.println(sclList);
		model.addAttribute("sclList", sclList);	
		
		
		return "stucrse/show_crse_qstn";
	}
	
	@RequestMapping("charsCrseMc")
	public String charsCrseMc(String crseId, String mcId, Model model) {
		
		model.addAttribute("crseId", crseId);
		model.addAttribute("mcId", mcId);
		
		List<Map<String, Object>> mcSclList = stuCrseService.queryMcSclList(crseId, mcId);
		System.out.println(mcSclList);
		model.addAttribute("mcSclList", mcSclList);
		

		return "stucrse/chars_crse_mc";
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
	public String showCrseQstnPage(String crseId, String userId, HttpServletRequest request, Model model) {
		
		StudyCourse crse = stuCrseService.queryCrseById(crseId);
		model.addAttribute("crse", crse);
		System.out.println("userId:" + userId);
		if(userId==null) {

			SysUser user = (SysUser) request.getSession().getAttribute("user");
			userId = user.getUserId();
		}
		
//		System.out.println(user);
		
		List<StuCrseTest> list = stuCrseService.queryStuCrseTest(crseId, userId);
		System.out.println("list:" + list);
		
		model.addAttribute("list", list);
		
		return "stucrse/show_stucrsetest";
	}
	
	
	@RequestMapping("openCrseQstnPage")
	public String openCrseQstnPage(String crseId, Model model) {
		StudyCourse crse = stuCrseService.queryCrseById(crseId);
		model.addAttribute("crse", crse);
		int flag = crse.getQstnFlag();
		
		int qc0 = crse.getQstnTest0();		
		//int qc1 = crse.getQstnCount1();		
		int qc2 = crse.getQstnTest2();		
		//int qc3 = crse.getQstnCount3();		
		//int qc4 = crse.getQstnCount4();	
		
		System.out.println("sum-qc0:" + qc0 );
		System.out.println("sum-qc2:" + qc2 );
		
		int sum = crse.getQstnTest0() + crse.getQstnTest1() + crse.getQstnTest2() + crse.getQstnTest3() + crse.getQstnTest4();
		
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
			do {
				q0size = (int) (Math.random()*(qc0-qsListFlag0.size() + 1 ));
			} while ( q0size + crse.getQstnCount2() < sum );
			
			
			
			
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
			
			do {
				q0size = (int) (Math.random()*(qc0 + 1));
			} while ( q0size + crse.getQstnCount2() < sum );
			
			
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
	public String answerSave(String crseId,Integer sctlen, String[] qstns0,String[] ans0, String[] qstns2,String[] ans2, String[] qstns4,String[] ans4, HttpServletRequest request, Model model) {
		
//		System.out.println(Arrays.toString(qstns0));
//		System.out.println(Arrays.toString(ans0));
//		System.out.println(Arrays.toString(qstns2));
//		System.out.println(Arrays.toString(ans2));
//		System.out.println("crseId:" + crseId);
		System.out.println("sctlen:" + sctlen);
			
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		
		stuCrseService.saveAnswer(user,sctlen, crseId, qstns0, ans0, qstns2, ans2);	

		return "redirect:query";
	}
	

}


