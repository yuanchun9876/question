package com.yuzo.question.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.TestPlan;
import com.yuzo.question.entity.TestPlanDetailed;
import com.yuzo.question.entity.UserAnswerList;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserTestList;
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
	
	@RequestMapping("xintiao")
	@ResponseBody
	public String xintiao() {
			
		return "xintiao";
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
	public String openpaper(String tpId, String tpType, String utsId, HttpSession session, Model model) {
		
		SysUser user = (SysUser) session.getAttribute("user");
		//System.out.println("user:" + user.getNickName());
		// 判断是否已经答完题
		List<UserTestList> utlist = testPlanService.queryByUserAndTp(user.getUserId(), tpId);
		System.out.println("utlist:" + utlist);
		
		if (!"3".equals(tpType)  &&  utlist!=null  &&  utlist.size()>0 ) {
			UserTestList utl = null;
			if(utsId!=null && !"".equals(utsId)) {
				utl = testPlanService.queryUtlById(utsId);
			}else {
				TestPlan tp = testPlanService.queryById(tpId);
				utl = utlist.get(0);
			}
			
			model.addAttribute("utl", utl);
			
			List<UserAnswerList> ualList0 = testPlanService.queryUalBy(utl.getUtsId(), "0");			
			if(ualList0!=null && ualList0.size()>0) {
				System.out.println("ualList0:" + ualList0);
				ualList0 = testPlanService.addAnswerByQstnForUal0(ualList0);
				model.addAttribute("ualList0", ualList0);
			}

			List<UserAnswerList> ualList1 = testPlanService.queryUalBy(utl.getUtsId(), "1");
			if(ualList1!=null && ualList1.size()>0) {
				model.addAttribute("ualList1", ualList1);
			}
			List<UserAnswerList> ualList2 = testPlanService.queryUalBy(utl.getUtsId(), "2");
			if(ualList2!=null && ualList2.size()>0) {
				ualList2 = testPlanService.addAnswerByQstnForUal2(ualList2);
				model.addAttribute("ualList2", ualList2);
			}
			List<UserAnswerList> ualList3 = testPlanService.queryUalBy(utl.getUtsId(), "3");
			if(ualList3!=null && ualList3.size()>0) {
				model.addAttribute("ualList3", ualList3);
			}
			List<UserAnswerList> ualList4 = testPlanService.queryUalBy(utl.getUtsId(), "4");
			if(ualList4!=null && ualList4.size()>0) {
				System.out.println("ualList4:" + ualList4);
				model.addAttribute("ualList4", ualList4);
			}
						
			return "testplan/show_paper_plan";
			
		} else {
			
		//	session.setMaxInactiveInterval(5*60*60);
			
			TestPlan plan = testPlanService.queryById(tpId);
			model.addAttribute("plan", plan);
			System.out.println("type:" + plan.getTpType());
			// 随机 0   或者  测试 3
			if("0".equals(plan.getTpType()) ||  "3".equals(plan.getTpType())) {
				
				// 类型
				List<TestPlanDetailed> typeList = testPlanService.queryQstnType(tpId);
				
				// 出处
				List<TestPlanDetailed> fromList = testPlanService.queryQstnFrom(tpId);
				
				// 知识节
				List<TestPlanDetailed> sctnList = testPlanService.querySctn(tpId);
				
				for (TestPlanDetailed tpdType : typeList) {
					
					// 单选
					if("0".equals(tpdType.getQstnTypeId())  ) {
						List<Question> qstnList0 = new ArrayList<>();
						
						for (TestPlanDetailed tpdFrom : fromList) {
							for (TestPlanDetailed tpdSctn : sctnList) {
								
								List<Question>  ll = testPlanService.queryQuesByParams(tpdType.getQstnTypeId(), tpdFrom.getQstnFromTypeId(), tpdSctn.getSubjSctnId() );
								qstnList0.addAll(ll);
							}		
						}
						
						Collections.shuffle(qstnList0);	
						int qstnTotal0 = tpdType.getTypeNum()>qstnList0.size()?qstnList0.size():tpdType.getTypeNum();
						List<Question> ql0 = testPlanService.addAnswerByQstn(qstnList0.subList(0, qstnTotal0));
						System.out.println("ql0:" + ql0);
						
						model.addAttribute("qstnList0", ql0.subList(0, qstnTotal0));
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
						
						int qstnTotal2 = tpdType.getTypeNum()>qstnList2.size()?qstnList2.size():tpdType.getTypeNum();						
						Collections.shuffle(qstnList2);		
						System.out.println("qstnList2:" + qstnList2);
						
						model.addAttribute("qstnList2", qstnList2.subList(0, qstnTotal2));
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
						//System.out.println("qstnList4:" + qstnList4.size());
						
						int qstnTotal4 = tpdType.getTypeNum()>qstnList4.size()?qstnList4.size():tpdType.getTypeNum();
						
						//System.out.println(qstnTotal4);
						
						Collections.shuffle(qstnList4);		
						
						model.addAttribute("qstnList4", qstnList4.subList(0, qstnTotal4));
					}
				}
			}
			
			return "testplan/open_paper_plan";
		}
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
	@RequestMapping("/inputScore")
	public String inputScore(String tpId, Model model) {
		
		TestPlan plan = testPlanService.queryById(tpId);
		model.addAttribute("plan", plan);	
		
		List<UserMyclass> mclist = testPlanService.queryMc();
		model.addAttribute("mclist", mclist);	
		
		return "testplan/inputScore_plan";
	}
	
	@RequestMapping("/classCharts")
	public String classCharts(String tpId, Model model) {
		
		TestPlan plan = testPlanService.queryById(tpId);		
		model.addAttribute("plan", plan);	
		List<UserMyclass> mclist = testPlanService.queryMc();
		model.addAttribute("mclist", mclist);	
		
		return "testplan/query_charts_plan";
	}
	
	@RequestMapping("/setScore")
	public String setScore(String tpId, String[] userIds, String[] points) {
		
		System.out.println(tpId);
		System.out.println(Arrays.toString(userIds));
		System.out.println(Arrays.toString(points));
			
		int count = testPlanService.setScore(tpId, userIds, points );
		
		return "redirect:query";
	}
	
	
	@RequestMapping("/queryCharts")
	@ResponseBody
	public Map<String, Object> queryCharts(String mcId, String tpId) {
		
		Map<String, Object> map = testPlanService.queryAnswer(mcId, tpId);
		
		return map;
	}
	
	
	
	@RequestMapping("/targetClass")
	public String targetClass(String tpId, Model model) {
		
		TestPlan plan = testPlanService.queryById(tpId);
		model.addAttribute("plan", plan);	
		List<UserMyclass> mclist = testPlanService.queryMc();
		model.addAttribute("mclist", mclist);	
		
		return "testplan/set_plan_target";
	}
	
	@RequestMapping("/setPlanTarget")
	public String setPlanTarget(TestPlan plan) {
		
		int count = testPlanService.setPlanTarget(plan);
		System.out.println(":" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/answerSave")
	public String answerSave(String tpId,String tpType, String[] qstns0,String[] ans0, String[] qstns2,String[] ans2, String[] qstns4,String[] ans4, HttpServletRequest request, Model model) {
		
//		System.out.println(Arrays.toString(qstns0));
//		System.out.println(Arrays.toString(ans0));
		System.out.println("tpType:" + tpType);
		
		//request.getSession().setMaxInactiveInterval(1800);
		
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		
		testPlanService.saveAnswer(user, tpId, qstns0, ans0, qstns2, ans2, qstns4, ans4);
		
		if ("3".equals(tpType)) {
			return "redirect:userplanlist3";
		} else {
			return "redirect:userplanlist0";
		}
		
	}
	
	@RequestMapping("/checkAnswer")
	public String checkAnswer(String type, String[] qstns0,String[] ans0, String[] qstns2,String[] ans2, String[] qstns4,String[] ans4, HttpServletRequest request, Model model) {
		
//		System.out.println(Arrays.toString(qstns0));
//		System.out.println(Arrays.toString(ans0));

		Map<String, Object> map = testPlanService.checkAnswer(type, qstns0, ans0, qstns2, ans2, qstns4, ans4);

		Question qstn = testPlanService.queryQstnById(((Question)map.get("qstn")).getQstnId());
		model.addAttribute("qstn", qstn);
		
		List<Answer> ansList = testPlanService.queryAnswersByQstnId(((Question)map.get("qstn")).getQstnId());
		model.addAttribute("ansList", ansList);
		
		model.addAttribute("myanswer", map.get("answer"));
		model.addAttribute("result", map.get("result"));
		
		model.addAttribute("type", type);
		
		return "qstn/check_answer";
	}
	
	
	@RequestMapping("/setPage")
	public String setPage(String tpId, Model model) {
		
		TestPlan plan = testPlanService.queryById(tpId);
		model.addAttribute("plan", plan);	
		
		
		
		List<QstnFromType> qstnFromList = testPlanService.queryQstnFrom2(tpId);
		model.addAttribute("qstnFromList", qstnFromList);
		List<QuestionType> qstnTypeList = testPlanService.queryQstnType2(tpId);
		model.addAttribute("qstnTypeList", qstnTypeList);
		
		List<SubjectCourse> subjList = testPlanService.querySubj(tpId);
		model.addAttribute("subjList", subjList);
		List<SubjUnit> subjUnitList = testPlanService.querySubjUnit(tpId);
		model.addAttribute("subjUnitList", subjUnitList);
		List<SubjSection> subjSctnList = testPlanService.querySubjSctn(tpId);
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
	
	/**
	 * 以班级为单位的每次考试总成绩
	 * @return
	 */
	@RequestMapping("/classplanlist")
	@ResponseBody
	public Map<String, Object> classplanlist(String mcId) {

		Map<String, Object> map = testPlanService.classplanlist(mcId);
		
		return map;
	}
	
	/**
	 * 以班级为单位的每次考试总成绩
	 * @return
	 */
	@RequestMapping("/classTestlist")
	public String classTestlist(String mcId, Model model) {
		
		List<Map<String, Object>> list = testPlanService.clasTestlist(mcId);
		System.out.println(list);
		model.addAttribute("list", list);
		
		List<TestPlan> tp3list = testPlanService.queryByUserClass3(mcId);
		System.out.println(tp3list);
		model.addAttribute("tp3list", tp3list);
		
		return "worklist/list_stu_test";
	}
	
	//----------------------------------------------------------
	
	@RequestMapping("/userplanlist0")
	public String userplanlist0(HttpSession session, Model model) {
		
		SysUser user = (SysUser) session.getAttribute("user");
	
		List<TestPlan> planlist = testPlanService.queryByUserClass(user,"0");
		model.addAttribute("planlist", planlist);	
	
		return "testplan/list_plan_userclass";
	}
	
	@RequestMapping("/userplanlist3")
	public String userplanlist3(HttpSession session, Model model) {
		
		SysUser user = (SysUser) session.getAttribute("user");
		
		List<TestPlan> planlist = testPlanService.queryByUserClass(user,"3");
		model.addAttribute("planlist", planlist);	
		
		return "testplan/list_plan_userclass";
	}
	
	@RequestMapping("/userAnsList")
	public String userAnsList(String tpId, String userId, HttpSession session, Model model) {
		SysUser user = null;
		if(userId == null ||  "".equals(userId)) {
			user = (SysUser) session.getAttribute("user");
			userId = user.getUserId();
		}else {
			user = testPlanService.queryUserById(userId);
		}
		model.addAttribute("user", user);	
		
		List<UserTestList> list = testPlanService.queryByUserAndTp(userId, tpId);
		model.addAttribute("list", list);	
		return "testplan/list_userans_plan";
	}
	

	
	
}
