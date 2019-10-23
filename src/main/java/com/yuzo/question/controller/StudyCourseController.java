package com.yuzo.question.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.yuzo.question.entity.Teacher;
import com.yuzo.question.entity.UserAnswerList;
import com.yuzo.question.service.IStudyCourseService;
import com.yuzo.question.service.ISubjUnitService;
import com.yuzo.question.service.ISysRoleService;

@Controller
@RequestMapping("/stdycrse")
public class StudyCourseController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudyCourseController.class);
	
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
		if (scqList!=null && scqList.size()>0) {
			model.addAttribute("scqList", scqList);	
		} else {
			scqList = stdycrseService.queryScqByCrseIdForSctn(crseId);
			model.addAttribute("scqList", scqList);	
		}
		
		
		
		return "stdycrse/set_qstn_crse";
	}
	@RequestMapping("/setqstnflag")
	public String setqstnflag(String crseId, Model model) {
		
		StudyCourse crse = stdycrseService.queryById(crseId);
		model.addAttribute("crse", crse);	
		
		List<StudyCourseQuestion> scqList = stdycrseService.queryScqByCrseId(crseId);
		model.addAttribute("scqList", scqList);	
		
		return "stdycrse/qstn_flag_crse";
	}
	
	
	@RequestMapping("/ajaxAddCrseQstn")
	@ResponseBody
	public String ajaxAddCrseQstn(String crseId, String qstnId) {
		
		int count = stdycrseService.addCrseQstn(crseId, qstnId);
		
		return "add";
	}
	@RequestMapping("/ajaxDelCrseQstn")
	@ResponseBody
	public String ajaxDelCrseQstn(String crseId, String qstnId) {
		
		int count = stdycrseService.delCrseQstn(crseId, qstnId);
		
		return "del";
	}
	
	@RequestMapping("/showqstnpage")
	public String showqstnpage(String crseId, Model model) {
		
		StudyCourse crse = stdycrseService.queryById(crseId);
		model.addAttribute("crse", crse);	
		
		List<StudyCourseQuestion> scqList = stdycrseService.queryScqByCrseId(crseId);
		List<Question> qstnList0 = new ArrayList<>();
		List<Question> qstnList2 = new ArrayList<>();
		List<Question> qstnList4 = new ArrayList<>();
		for (StudyCourseQuestion scq : scqList) {
			Question qstn = stdycrseService.queryQstnById(scq.getQstnId());
			switch (qstn.getQstnTypeId()) {
			case "0":
				qstnList0.add(qstn);
				break;
			case "1":
				
				break;
			case "2":
				qstnList2.add(qstn);;
				break;
			case "3":
				
				break;
			case "4":
				qstnList4.add(qstn);;
				break;
			default:
				break;
			}
		}
		
		if(qstnList0!=null && qstnList0.size()>0) {
			List<Question> ql0 = stdycrseService.addAnswerByQstn(qstnList0);
			model.addAttribute("qstnList0", ql0);
		}
		if(qstnList2!=null && qstnList2.size()>0) {
			model.addAttribute("qstnList2", qstnList2);
		}
		if(qstnList4!=null && qstnList4.size()>0) {
			model.addAttribute("qstnList4", qstnList4);
		}
		
		return "stdycrse/show_qstn_crse";
	}
	
	@RequestMapping("/ajaxCharsPlanMcUnit")
	@ResponseBody
	public Map<String, Object> ajaxCharsPlanMcUnit(String crseId, Model model) {
		
		
		Map<String, Object> map = new HashMap<>();
		//testPlanService.charsPlanMc(tpId, mcId);
		List<StudyCourseQuestion> scqList = stdycrseService.queryScqByCrseId(crseId);
		
		// 知识章
		Set<String> unitIds = new HashSet<>();
		// 知识节
		Set<String> sctnIds = new HashSet<>();
		
		for (StudyCourseQuestion scq : scqList) {
			//Question qstn = stdycrseService.queryQstnById(scq.getQstnId());
			SubjUnit unit = stdycrseService.queryUnitBySctnId(scq.getSubjSctnId());
			unitIds.add(unit.getSubjUnitId());
		}
		System.out.println(unitIds.size());
		
		String[] unitTitles = new String[unitIds.size()];
		Integer[] unitCounts = new Integer[unitIds.size()];
		
		List<String> sctnTitles = new ArrayList<>();
		List<Integer> sctnCounts = new  ArrayList<>();
		
		List<Map<String, Object>> unitList = new ArrayList<>();
		List<Map<String, Object>> sctnList = new ArrayList<>();
		
		int i = 0;
		for (String unitId : unitIds) {
			// 知识章
			Map<String, Object> unitMap = new HashMap<>();			
			SubjUnit unit = stdycrseService.queryUnitById(unitId);		
			
			unitTitles[i] = unit.getSubjUnitTitle();
			unitMap.put("name", unit.getSubjUnitTitle());

			unitCounts[i] = stdycrseService.totalUnitCount(crseId, unit.getSubjUnitId());		
			unitMap.put("value", stdycrseService.totalUnitCount(crseId, unit.getSubjUnitId()));
			
			unitList.add(unitMap);
			i++;
			
			// 知识节
			List<SubjSection> sctns = stdycrseService.querySctnsByUnit(unitId);
			for (SubjSection sctn : sctns) {
				Integer sctnCount = stdycrseService.totalSctnCount(crseId, sctn.getSubjSctnId());
				if(sctnCount>0) {
					Map<String, Object> sctnMap = new HashMap<>();	
					sctnTitles.add(sctn.getSubjSctnTitle());
					sctnCounts.add(sctnCount);
					sctnMap.put("name", sctn.getSubjSctnTitle());
					sctnMap.put("value", sctnCount);
					sctnList.add(sctnMap);
				}
			}
		}
		
		
		map.put("sctnList", sctnList);
		map.put("unitList", unitList);
		//map.put("unitCounts", unitCounts);
		
		String[] titls = new String[unitTitles.length + sctnTitles.size()];
		for(int j=0; j<unitTitles.length; j++) {
			titls[j]=unitTitles[j];
		}
		
		for(int j=unitTitles.length; j<(unitTitles.length + sctnTitles.size()); j++) {
			titls[j]=sctnTitles.get(j-unitTitles.length);
		}
		
		map.put("titles", titls);
		
		System.out.println(Arrays.toString(titls));
					
		return map;
	}
	
	
	
	@RequestMapping("/setqstnSave")
	public String setqstnSave(String crseId, String[] qstns, Model model) {		
		int count = stdycrseService.setCrseQstn(crseId, qstns );			
		return "redirect:query";
	}
	@RequestMapping("/qstnflagSave")
	public String qstnflagSave(String crseId, String[] qstns,String[] qstnFlags, Model model) {		
		int count = stdycrseService.setCrseQstnFlag(crseId, qstns, qstnFlags );			
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
