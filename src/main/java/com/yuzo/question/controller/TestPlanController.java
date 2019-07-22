package com.yuzo.question.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.TestPlan;
import com.yuzo.question.entity.TestPlanDetailed;
import com.yuzo.question.entity.UserMyclass;
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
	
	

	@RequestMapping("setSave")
	public String setSave(
			String tpId,
			String[] typeIds, Integer[] typeNums, Integer[] typePns,
			String[] fromIds, Integer[] fromNums,
			String[] subjIds, Integer[] subjNums,
			String[] unitIds, Integer[] unitNums,
			String[] sctnIds, Integer[] sctnNums,			
			Model model) {
		System.out.println("tpId:" + tpId);
		System.out.println("typeIds:" + Arrays.toString(typeIds));
		System.out.println("typeNums:" + Arrays.toString(typeNums));
		System.out.println("typePns:" + Arrays.toString(typePns));
		System.out.println("fromIds:" + Arrays.toString(fromIds));
		System.out.println("fromNums:" + Arrays.toString(fromNums));
		System.out.println("subjIds:" + Arrays.toString(subjIds));
		System.out.println("subjNums:" + Arrays.toString(subjNums));
		System.out.println("unitIds:" + Arrays.toString(unitIds));
		System.out.println("unitNums:" + Arrays.toString(unitNums));
		System.out.println("sctnIds:" + Arrays.toString(sctnIds));
		System.out.println("sctnNums:" + Arrays.toString(sctnNums));
		
		
		
		int count = testPlanService.saveSet(tpId, typeIds, typeNums, typePns, fromIds, fromNums, subjIds, subjNums, unitIds, unitNums, sctnIds, sctnNums);
		
		
		return "redirect:query";
	}
	
	@RequestMapping("/openpaper")
	public String openpaper(String tpId, Model model) {
		
		model.addAttribute("tpId", tpId);
		
		TestPlan plan = testPlanService.queryById(tpId);
		if("0".equals(plan.getTpType())) {
			
			// 类型
			List<TestPlanDetailed> typeList = testPlanService.queryQstnType(tpId);
			
			// 出处
			List<TestPlanDetailed> fromList = testPlanService.queryQstnFrom(tpId);
			
			// 知识节
			List<TestPlanDetailed> sctnList = testPlanService.querySctn(tpId);
			
			for (TestPlanDetailed tpdType : typeList) {
				
				// 单选
				if("0".equals(tpdType.getQstnTypeId())) {
					List<Question> qstnList0 = new ArrayList<>();
					
					for (TestPlanDetailed tpdFrom : fromList) {
						for (TestPlanDetailed tpdSctn : sctnList) {
							
							List<Question>  ll = testPlanService.queryQuesByParams(tpdType.getQstnTypeId(), tpdFrom.getQstnFromTypeId(), tpdSctn.getSubjSctnId() );
							qstnList0.addAll(ll);
						}		
					}
					System.out.println("qstnList0:" + qstnList0);
					int qstnTotal0 = tpdType.getTypeNum()-1;				
					Collections.shuffle(qstnList0);	
					
					model.addAttribute("qstnList0", qstnList0.subList(0, qstnTotal0));
				}
				// 多选
				if("1".equals(tpdType.getQstnTypeId())) {
					List<Question> qstnList1 = new ArrayList<>();
					
					for (TestPlanDetailed tpdFrom : fromList) {
						for (TestPlanDetailed tpdSctn : sctnList) {
							
							List<Question>  ll = testPlanService.queryQuesByParams(tpdType.getQstnTypeId(), tpdFrom.getQstnFromTypeId(), tpdSctn.getSubjSctnId() );
							qstnList1.addAll(ll);
						}		
					}
					System.out.println("qstnList1:" + qstnList1);
					model.addAttribute("qstnList1", qstnList1);
				}
				// 填空
				if("2".equals(tpdType.getQstnTypeId())) {
					List<Question> qstnList2 = new ArrayList<>();
					
					for (TestPlanDetailed tpdFrom : fromList) {
						for (TestPlanDetailed tpdSctn : sctnList) {
							
							List<Question>  ll = testPlanService.queryQuesByParams(tpdType.getQstnTypeId(), tpdFrom.getQstnFromTypeId(), tpdSctn.getSubjSctnId() );
							qstnList2.addAll(ll);
						}		
					}
					System.out.println("qstnList2:" + qstnList2);
					model.addAttribute("qstnList2", qstnList2);
				}
				// 判断
				if("3".equals(tpdType.getQstnTypeId())) {
					List<Question> qstnList3 = new ArrayList<>();
					
					for (TestPlanDetailed tpdFrom : fromList) {
						for (TestPlanDetailed tpdSctn : sctnList) {
							
							List<Question>  ll = testPlanService.queryQuesByParams(tpdType.getQstnTypeId(), tpdFrom.getQstnFromTypeId(), tpdSctn.getSubjSctnId() );
							qstnList3.addAll(ll);
						}		
					}
					System.out.println("qstnList3:" + qstnList3);
					model.addAttribute("qstnList3", qstnList3);
				}
				// 简答
				if("4".equals(tpdType.getQstnTypeId())) {
					List<Question> qstnList4 = new ArrayList<>();
					
					for (TestPlanDetailed tpdFrom : fromList) {
						for (TestPlanDetailed tpdSctn : sctnList) {
							
							List<Question>  ll = testPlanService.queryQuesByParams(tpdType.getQstnTypeId(), tpdFrom.getQstnFromTypeId(), tpdSctn.getSubjSctnId() );
							qstnList4.addAll(ll);
						}		
					}
					System.out.println("qstnList4:" + qstnList4.size());
					
					int qstnTotal4 = tpdType.getTypeNum()>qstnList4.size()?qstnList4.size():tpdType.getTypeNum();
					
					System.out.println(qstnTotal4);
					
					Collections.shuffle(qstnList4);		
					
					model.addAttribute("qstnList4", qstnList4.subList(0, qstnTotal4));
				}
			}
		}
		
		return "testplan/open_paper_plan";
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
	@RequestMapping("/targetClass")
	public String targetClass(String tpId, Model model) {
		
		TestPlan plan = testPlanService.queryById(tpId);
		model.addAttribute("plan", plan);	
		List<UserMyclass> mclist = testPlanService.queryMc();
		model.addAttribute("mclist", mclist);	
		
		return "testplan/set_plan_target";
	}
	
	@RequestMapping("/answerSave")
	public String answerSave(String tpId, String[] qstns0,String[] ans0,String[] qstns4,String[] ans4, HttpServletRequest request, Model model) {

		SysUser user = (SysUser) request.getSession().getAttribute("user");
		
		testPlanService.saveAnswer(user, tpId, qstns0, ans0, qstns4, ans4);
		
		return "redirect:query";
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
	
	//----------------------------------------------------------
	
	@RequestMapping("/userplanlist")
	public String userplanlist(HttpSession session, Model model) {
		
		SysUser user = (SysUser) session.getAttribute("user");
	
		List<TestPlan> planlist = testPlanService.queryByUserClass(user);
		model.addAttribute("planlist", planlist);	
	
		return "testplan/list_plan_userclass";
	}
}
