package com.yuzo.question.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.yuzo.question.entity.TestplanClassteam;
import com.yuzo.question.entity.UserAnswerList;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.entity.UserTestList;
import com.yuzo.question.mapper.AnswerMapper;
import com.yuzo.question.mapper.QstnFromTypeMapper;
import com.yuzo.question.mapper.QuestionMapper;
import com.yuzo.question.mapper.QuestionTypeMapper;
import com.yuzo.question.mapper.SubjSectionMapper;
import com.yuzo.question.mapper.SubjUnitMapper;
import com.yuzo.question.mapper.SubjectCourseMapper;
import com.yuzo.question.mapper.SysUserMapper;
import com.yuzo.question.mapper.TestPlanDetailedMapper;
import com.yuzo.question.mapper.TestPlanMapper;
import com.yuzo.question.mapper.TestplanClassteamMapper;
import com.yuzo.question.mapper.UserAnswerListMapper;
import com.yuzo.question.mapper.UserMyclassMapper;
import com.yuzo.question.mapper.UserTeamMapper;
import com.yuzo.question.mapper.UserTestListMapper;
import com.yuzo.question.page.QuestionPage;
import com.yuzo.question.service.ITestPlanService;

@Service
public class TestPlanServiceImpl implements ITestPlanService {

	@Autowired
	private TestPlanMapper planMapper;
	
	@Autowired
	private TestPlanDetailedMapper planDtdMapper;

	@Autowired
	private QuestionMapper qstnMapper;
	
	@Autowired
	private QstnFromTypeMapper qstnFromMapper;
	
	@Autowired
	private QuestionTypeMapper qstnTypeMapper;
	
	@Autowired
	private SubjSectionMapper sctnMapper;
	
	@Autowired
	private SubjUnitMapper unitMapper;
	
	@Autowired
	private SubjectCourseMapper subjMapper;
	
	@Autowired
	private UserAnswerListMapper ualMapper;
	
	@Autowired
	private UserTestListMapper utlMapper;
	
	@Autowired
	private AnswerMapper ansMapper;
	
	@Autowired
	private UserMyclassMapper userMyclassMapper;
	
	@Autowired
	private UserTeamMapper  tmMapper;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private TestplanClassteamMapper tpctMapper;

	@Override
	public List<QstnFromType> queryQstnFrom2(String tpId) {
		// TODO Auto-generated method stub
		List<QstnFromType> list = qstnFromMapper.queryAll();
		List<TestPlanDetailed> tpdList = planDtdMapper.queryWhere(tpId, "2");
		for (QstnFromType qstnFromType : list) {
			qstnFromType.setQstnFromSelected("false");
			for (TestPlanDetailed testPlanDetailed : tpdList) {
//				System.out.println("qstnFromType:" + qstnFromType.getQstnFromTypeId());
//				System.out.println("testPlanDetailed:" + testPlanDetailed.getQstnFromTypeId());
//				System.out.println(qstnFromType.getQstnFromTypeId().equals(testPlanDetailed.getQstnFromTypeId()));
				if(qstnFromType.getQstnFromTypeId().equals(testPlanDetailed.getQstnFromTypeId())) {
					qstnFromType.setQstnFromSelected("checked");
					break;
				}
			}
		}
//		System.out.println("QstnFromType:" + list);
		return list;
	}

	@Override
	public List<QuestionType> queryQstnType2(String tpId) {
		// TODO Auto-generated method stub
		List<QuestionType> list =  qstnTypeMapper.queryAll();
		List<TestPlanDetailed> tpdList = planDtdMapper.queryWhere(tpId, "1");
		for (QuestionType qstnType : list) {
			qstnType.setQstnTypeSelected("false");
			for (TestPlanDetailed testPlanDetailed : tpdList) {
				if(qstnType.getQstnTypeId().equals(testPlanDetailed.getQstnTypeId())) {
					qstnType.setQstnTypeSelected("checked");
					break;
				}
			}
		}
		return list;
	}

	@Override
	public List<SubjSection> querySubjSctn(String tpId) {
		// TODO Auto-generated method stub
		List<SubjSection> list = sctnMapper.queryAll(null);
		List<TestPlanDetailed> tpdList = planDtdMapper.queryWhere(tpId, "5");
		for (SubjSection sctn : list) {
			sctn.setSctnSelected("false");
			for (TestPlanDetailed testPlanDetailed : tpdList) {
				if(sctn.getSubjSctnId().equals(testPlanDetailed.getSubjSctnId())) {
					sctn.setSctnSelected("checked");
					break;
				}
			}
		}
		return list;
	}

	@Override
	public List<SubjectCourse> querySubj(String tpId) {
		// TODO Auto-generated method stub
		List<SubjectCourse> list = subjMapper.queryAll();
		List<TestPlanDetailed> tpdList = planDtdMapper.queryWhere(tpId, "3");
		for (SubjectCourse subj : list) {
			subj.setSubjSelected("false");
			for (TestPlanDetailed testPlanDetailed : tpdList) {
				if(subj.getSubjId().equals(testPlanDetailed.getSubjId())) {
					subj.setSubjSelected("checked");
					break;
				}
			}
		}
		return list;
	}

	@Override
	public List<SubjUnit> querySubjUnit(String tpId) {
		// TODO Auto-generated method stub
		List<SubjUnit> list = unitMapper.queryAll();
		List<TestPlanDetailed> tpdList = planDtdMapper.queryWhere(tpId, "4");
		for (SubjUnit unit : list) {
			unit.setUnitSelected("false");
			for (TestPlanDetailed testPlanDetailed : tpdList) {
				if(unit.getSubjUnitId().equals(testPlanDetailed.getSubjUnitId())) {
					unit.setUnitSelected("checked");
					break;
				}
			}
		}
		return list;
	}
	
	@Override
	public List<TestPlan> queryAll() {
		// TODO Auto-generated method stub
		return planMapper.queryAll();
	}

	@Override
	public int save(TestPlan plan) {
		// TODO Auto-generated method stub
		return planMapper.insertSelective(plan);
	}

	@Override
	public TestPlan queryById(String tpId) {
		// TODO Auto-generated method stub
		return planMapper.selectByPrimaryKey(tpId);
	}

	@Override
	public int update(TestPlan plan) {
		// TODO Auto-generated method stub
		plan.setTpDate(new Date());
		return planMapper.updateByPrimaryKeySelective(plan);
	}

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			planDtdMapper.delsByPlan(ids[i]);
			count += planMapper.deleteByPrimaryKey(ids[i]);
			
		}
		return count;
	}

	@Override
	public int saveSet(String tpId, String[] typeIds, Integer[] typeNums, Integer[] typePns, String[] fromIds,
			Integer[] fromNums, String[] subjIds, Integer[] subjNums, String[] unitIds, Integer[] unitNums,
			String[] sctnIds, Integer[] sctnNums) {
		// 先删除原来的记录 再 保存新的记录
		
		planDtdMapper.delsByPlan(tpId);
		
		int count = 0;
		
		for (int i = 0; i < typeIds.length; i++) {
			TestPlanDetailed planDtd = new TestPlanDetailed();
			planDtd.setTpDtdId(UUID.randomUUID().toString());
			planDtd.setTpId(tpId);
			planDtd.setQstnTypeId(typeIds[i]);
			if (typeNums[Integer.parseInt(typeIds[i])]==null) {
				planDtd.setTypeNum(100);
			} else {
				planDtd.setTypeNum(typeNums[Integer.parseInt(typeIds[i])]);
			}
			if (typePns[Integer.parseInt(typeIds[i])]==null) {
				planDtd.setTypePoints(5);
			} else {
				planDtd.setTypePoints(typePns[Integer.parseInt(typeIds[i])]);
			}
			planDtd.setTpDtdType("1");
			count += planDtdMapper.insertSelective(planDtd);
		}
		
		for (int i = 0; i < fromIds.length; i++) {
			TestPlanDetailed planDtd = new TestPlanDetailed();
			planDtd.setTpDtdId(UUID.randomUUID().toString());
			planDtd.setTpId(tpId);
			planDtd.setQstnFromTypeId(fromIds[i]);
//			if (fromNums[i]==null) {
//				planDtd.setFromNum(100);
//			} else {
//				planDtd.setFromNum(fromNums[i]);
//			}
			planDtd.setTpDtdType("2");
			count += planDtdMapper.insertSelective(planDtd);
		}
		
		for (int i = 0; i < subjIds.length; i++) {
			TestPlanDetailed planDtd = new TestPlanDetailed();
			planDtd.setTpDtdId(UUID.randomUUID().toString());
			planDtd.setTpId(tpId);
			planDtd.setSubjId(subjIds[i]);
//			if (subjNums[i]==null) {
//				planDtd.setSubjNum(100);
//			} else {
//				planDtd.setSubjNum(subjNums[i]);
//			}
			planDtd.setTpDtdType("3");
			count += planDtdMapper.insertSelective(planDtd);
		}
		
		if(unitIds!=null) {
			
			for (int i = 0; i < unitIds.length; i++) {
				TestPlanDetailed planDtd = new TestPlanDetailed();
				planDtd.setTpDtdId(UUID.randomUUID().toString());
				planDtd.setTpId(tpId);
				planDtd.setSubjUnitId(unitIds[i]);
//				if (unitNums[i] == null) {
//					planDtd.setUnitNum(100);
//				} else {
//					planDtd.setUnitNum(unitNums[i]);
//				}
				planDtd.setTpDtdType("4");
				count += planDtdMapper.insertSelective(planDtd);
			}
		}else {
			for (int i = 0; i < subjIds.length; i++) {
				List<SubjUnit> unitList = unitMapper.queryBySubj(subjIds[i]);
				for (SubjUnit subjUnit : unitList) {
					TestPlanDetailed planDtd = new TestPlanDetailed();
					planDtd.setTpDtdId(UUID.randomUUID().toString());
					planDtd.setTpId(tpId);
					planDtd.setSubjUnitId(subjUnit.getSubjUnitId());
					
//					planDtd.setUnitNum(100); // ***
					
					planDtd.setTpDtdType("4");
					count += planDtdMapper.insertSelective(planDtd);
				}
			}
		}
		
		if(sctnIds!=null) {
			
			for (int i = 0; i < sctnIds.length; i++) {
				TestPlanDetailed planDtd = new TestPlanDetailed();
				planDtd.setTpDtdId(UUID.randomUUID().toString());
				planDtd.setTpId(tpId);
				planDtd.setSubjSctnId(sctnIds[i]);
//				if (sctnNums[i]==null) {
//					planDtd.setSctnNum(100);
//				} else {
//					planDtd.setSctnNum(sctnNums[i]);
//				}
				planDtd.setTpDtdType("5");
				count += planDtdMapper.insertSelective(planDtd);
			}
		}else {
			if(unitIds!=null) {
			
				for (int i = 0; i < unitIds.length; i++) {
					List<SubjSection> sctnList = sctnMapper.queryByUnit(unitIds[i]);
					for (SubjSection subjSection : sctnList) {
						TestPlanDetailed planDtd = new TestPlanDetailed();
						planDtd.setTpDtdId(UUID.randomUUID().toString());
						planDtd.setTpId(tpId);
						planDtd.setSubjSctnId(subjSection.getSubjSctnId());
						
//							planDtd.setSctnNum(100);//***
						
						planDtd.setTpDtdType("5");
						count += planDtdMapper.insertSelective(planDtd);
					}
				}
			}else {
				for (int i = 0; i < subjIds.length; i++) {
					List<SubjUnit> unitList = unitMapper.queryBySubj(subjIds[i]);
					for (SubjUnit subjUnit : unitList) {
						List<SubjSection> sctnList = sctnMapper.queryByUnit(subjUnit.getSubjUnitId());
						for (SubjSection subjSection : sctnList) {
							TestPlanDetailed planDtd = new TestPlanDetailed();
							planDtd.setTpDtdId(UUID.randomUUID().toString());
							planDtd.setTpId(tpId);
							planDtd.setSubjSctnId(subjSection.getSubjSctnId());
							
//							planDtd.setSctnNum(100);//***
							
							planDtd.setTpDtdType("5");
							count += planDtdMapper.insertSelective(planDtd);
						}
					}
				}
			}
		}
		return count;
	}

	@Override
	public List<TestPlanDetailed> queryQstnType(String tpId) {
		// TODO Auto-generated method stub
		
		return planDtdMapper.queryWhere(tpId, "1");
	}

	@Override
	public List<TestPlanDetailed> queryQstnFrom(String tpId) {
		// TODO Auto-generated method stub
		
		return planDtdMapper.queryWhere(tpId, "2");
	}

	@Override
	public List<TestPlanDetailed> querySctn(String tpId) {
		// TODO Auto-generated method stub
		
		return planDtdMapper.queryWhere(tpId, "5");
	}

	@Override
	public List<Question> queryQuesByParams(String qstnTypeId, String qstnFromTypeId, String subjSctnId) {
		// TODO Auto-generated method stub
		return qstnMapper.queryQuesByParams(qstnTypeId, qstnFromTypeId, subjSctnId);
	}

	@Override
	public int saveAnswer(SysUser user, String tpId, String[] qstns0, String[] ans0, String[] qstns2,String[] ans2, String[] qstns4, String[] ans4) {
		// TODO Auto-generated method stub
		List<TestPlanDetailed> list = this.queryQstnType(tpId);
		int points0 = 0;
		int points1 = 0;
		int points2 = 0;
		int points3 = 0;
		int points4 = 0;
		for (TestPlanDetailed testPlanDetailed : list) {
			if("0".equals(testPlanDetailed.getQstnTypeId())) {
				points0 = testPlanDetailed.getTypePoints();
			}
			if("2".equals(testPlanDetailed.getQstnTypeId())) {
				points2 = testPlanDetailed.getTypePoints();
			}
			if("4".equals(testPlanDetailed.getQstnTypeId())) {
				points4 = testPlanDetailed.getTypePoints();
			}
		}
		
		
		int total = 0;
		
		UserTestList utl = new UserTestList();
		String utsId = UUID.randomUUID().toString();
		utl.setUtsId(utsId);
		utl.setTpId(tpId);
		utl.setUserId(user.getUserId());
		utl.setUtsTime(new Date());
		utlMapper.insertSelective(utl);
	
		// 记录 0.单选题
		if(qstns0!=null  &&  qstns0.length>0) {
			for (int i = 0; i < qstns0.length; i++) {
				UserAnswerList ual = new UserAnswerList();
				ual.setUansId(UUID.randomUUID().toString());
				ual.setQstnId(qstns0[i]);
				
				Question qstn = qstnMapper.selectByPrimaryKey(qstns0[i]);			
				ual.setSubjSctnId(qstn.getSubjSctnId());
				// ----------------------------
				if(ans0!=null && ans0.length>i) {
					ual.setUansContent(ans0[i]);
				}				
				ual.setUtsId(utsId);
				double result = 0.0;
				// ----------------------------
				if(ans0!=null && ans0.length>i) {
					result = this.checkAnswer0(qstns0[i], ans0[i]);
				}else {
					result = this.checkAnswer0(qstns0[i], "");
				}
				
				int result0 =  (int) Math.round(points0 * result);
				
				total += result0;
				
				ual.setUansResult(result0 + "");
				
				ualMapper.insertSelective(ual);
			}
		}
	
		
		
		// 记录 2.填空题
		if(qstns2!=null  &&  qstns2.length>0) {
			for (int i = 0; i < qstns2.length; i++) {
				UserAnswerList ual = new UserAnswerList();
				ual.setUansId(UUID.randomUUID().toString());
				ual.setQstnId(qstns2[i]);
				
				Question qstn = qstnMapper.selectByPrimaryKey(qstns2[i]);			
				ual.setSubjSctnId(qstn.getSubjSctnId());
				ual.setUansContent(ans2[i]);
				ual.setUtsId(utsId);
				
				double result = this.checkAnswer2(qstns2[i], ans2[i]);
				int result2 =  (int) Math.round(points2 * result);
				
				total += result2;
				
				ual.setUansResult(result2+"");
				
				ualMapper.insertSelective(ual);
			}
		}

		
		
		// 记录 4.简答题
		if(qstns4!=null  &&  qstns4.length>0) {
			for (int i = 0; i < qstns4.length; i++) {
				UserAnswerList ual = new UserAnswerList();
				ual.setUansId(UUID.randomUUID().toString());
				ual.setQstnId(qstns4[i]);
				
				Question qstn = qstnMapper.selectByPrimaryKey(qstns4[i]);			
				ual.setSubjSctnId(qstn.getSubjSctnId());
				ual.setUansContent(ans4[i]);
				ual.setUtsId(utsId);
				
				double result = this.checkAnswer4(qstns4[i], ans4[i]);
				int result4 =  (int) Math.round(points4 * result);
				
				total += result4;
				
				ual.setUansResult(result4+"");
				
				ualMapper.insertSelective(ual);
			}
		}

		
		
		// 合计分数
		
		utl.setUtsTotal(total);
		utlMapper.updateByPrimaryKeySelective(utl);
		
		return 0;
	}

	// 填空题判断
	private double checkAnswer2(String qstnId, String answer) {
		// TODO Auto-generated method stub
		List<Answer> ansList = ansMapper.queryByQstnId(qstnId);
		
		int total = 0;
		for (Answer ans : ansList) {
			//System.err.println("ans:" + ans);
			String anscontent = this.getStr(ans.getAnsContent()).trim().toLowerCase();
			anscontent = anscontent.replaceAll("&lt;", "<");
			anscontent = anscontent.replaceAll("&gt;", ">");
			anscontent = anscontent.replaceAll("&amp;", "&");
			anscontent = anscontent.replaceAll("&nbsp;", " ");
			anscontent = anscontent.replaceAll(" ", "");
			answer = answer.replaceAll(" ", "");
//			System.err.println("anscontent:" + anscontent.trim().toLowerCase());
//			System.err.println("answer:" + answer.trim().toLowerCase());
			

			if(anscontent.equals(answer.trim().toLowerCase())) {
				
				total = 1;		
				break;
			}
		}		
		return total/1.0;
	}
	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		String HTMLText="&lt;qwe&gt;&lt;/qwe&gt;";
		HTMLText = HTMLText.replaceAll("&lt;", "<");
		HTMLText = HTMLText.replaceAll("&gt;", ">");
		System.out.println(HTMLText);
	}
	

	private double checkAnswer0(String qstnId, String answer) {
		// TODO Auto-generated method stub
		List<Answer> ansList = ansMapper.queryByQstnId(qstnId);
		
		double result = 0.0;
		
		for (Answer ans : ansList) {		
			if(ans.getAnsId().equals(answer)  &&  "1".equals(ans.getAnsIsright())) {
				result = 1.0;
				break;
			}
		}
		return result;
	}

	private double checkAnswer4( String qstnId, String answer) {
	
		List<Answer> ansList = ansMapper.queryByQstnId(qstnId);
		int all = ansList.size()-1;
		int total = 0;
		for (Answer ans : ansList) {		
			if(!ans.getAnsIsright().equals("0")) {
				String ansStr = this.getStr(ans.getAnsContent());
				total += answer.contains(ansStr)?1:0;
			}
		}
		
		return total/1.0/all;
	}

	private String getStr(String str) {
		// <h1><span style="">3.S</span></h1><p><br></p><hr><h1>tring的<b>last<span style="color: rgb(227, 55, 55);">Ind</span>exO</b>f("x"), charAt(x) 是<u>什么</u>意思,<i>返回什么</i><strike>样值&nbsp;</strike> &nbsp;2</h1><pre><code class="lang-java">charAt(x)<br></code></pre><p style="margin-left: 40px;">4.有哪些<b>可见性</b>,可见范围是<a href="http://www.baidu.com" target="_blank">什么&nbsp; &nbsp;</a></p><table><colgroup><col width="49.883720930232556%"><col width="50.116279069767444%"></colgroup><thead><tr><th>1</th><th>角色</th></tr></thead><tbody><tr><td>2</td><td>村</td></tr></tbody></table><p><span style="">5.什么是反射</span></p><p><span style=""><img alt="avatar5.png" src="/upload/qstn_title/1563711832284avatar5.png" width="215" height="215"><br></span></p><p><span style="">,可以作什么用</span></p>
		// <p><span style="">为什么Mybatis叫半映射?</span><br></p>
		// <p>为什么没有信息</p>
		if(str.startsWith("<p><span style=\"\">")) {
			if (str.lastIndexOf("</span><br></p>") != -1) {
				return str.substring(18, str.lastIndexOf("</span><br></p>")).trim();
			} else {
				return str.substring(18, str.lastIndexOf("</span></p>")).trim();
			}
		
		}else {
			if (str.lastIndexOf("<br></p>") != -1) {
				return str.substring(3, str.lastIndexOf("<br></p>")).trim();
			} else {
				return str.substring(3, str.lastIndexOf("</p>")).trim();
			}
			
		}
		
		
	}

	@Override
	public List<UserMyclass> queryMc() {
		// TODO Auto-generated method stub
		return userMyclassMapper.queryAll();
	}

	@Override
	public List<TestPlan> queryByUserClass(SysUser user, String type) {
		// TODO Auto-generated method stub
		UserTeam tm = tmMapper.selectByPrimaryKey(user.getTmId());
		return planMapper.queryByUserClass(tm.getMcId(), type);
	}

	@Override
	public List<UserTestList> queryByUserAndTp(String userId, String tpId) {
		// TODO Auto-generated method stub
		return utlMapper.queryByUserAndTp(userId, tpId);
	}

	@Override
	public List<UserAnswerList> queryUalBy(String utsId, String type) {
		// TODO Auto-generated method stub
		
		return ualMapper.queryUalBy(utsId, type);
	}

	@Override
	public List<Question> addAnswerByQstn(List<Question> subList) {
		// TODO Auto-generated method stub
		for (Question question : subList) {
			List<Answer> ansList = ansMapper.queryByQstnId(question.getQstnId());
			Collections.shuffle(ansList);	
			question.setAnsList(ansList);
		}
		return subList;
	}

	@Override
	public List<UserAnswerList> addAnswerByQstnForUal0(List<UserAnswerList> ualList0) {
		// TODO Auto-generated method stub
		for (UserAnswerList userAnswerList : ualList0) {
			List<Answer> ansList = ansMapper.queryByQstnId(userAnswerList.getQstnId());
			userAnswerList.setAnsList(ansList);
			if (userAnswerList.getUansContent()!=null  &&  !"".equals(userAnswerList.getUansContent())) {
				Answer ans = ansMapper.selectByPrimaryKey(userAnswerList.getUansContent());
				System.out.println("ans.getAnsContent():" + ans.getAnsContent());
				userAnswerList.setAnsContent(ans.getAnsContent());
			} else {
				userAnswerList.setAnsContent("");
			}
			
		}
		return ualList0;
	}

	@Override
	public List<UserAnswerList> addAnswerByQstnForUal2(List<UserAnswerList> ualList2) {
		// TODO Auto-generated method stub
		for (UserAnswerList userAnswerList : ualList2) {
			List<Answer> ansList = ansMapper.queryByQstnId(userAnswerList.getQstnId());
			userAnswerList.setAnsList(ansList);
			
		}
		return ualList2;
	}

	@Override
	public Map<String, Object> queryAnswer(String mcId, String tpId) {
		// TODO Auto-generated method stub
		UserMyclass userClass = userMyclassMapper.selectByPrimaryKey(mcId);
		TestPlan plan = planMapper.selectByPrimaryKey(tpId);
		
		Map<String, Object>  map = new HashMap<>();		
		// title 
		// namelist
		// testlist
		map.put("title", userClass.getMcCode() + plan.getTpTitle() + "成绩统计");
		
		
		List<SysUser> userList = userMapper.queryByMcId(mcId);
		String[] names = new String[userList.size()];
		
		Integer[] tests = new Integer[userList.size()];
		
		for (int i = 0; i < userList.size(); i++) {
			SysUser user = userList.get(i);
			names[i] = user.getNickName();
			List<UserTestList> utlList = utlMapper.queryByUserAndTp(user.getUserId(), tpId);
			if (utlList!=null && utlList.size()>0) {
				tests[i] = utlList.get(0).getUtsTotal();
			} else {
				tests[i] = 0;
			}
		}
		map.put("namelist",names);
		map.put("testlist",tests);
		
		return map;
	}

	@Override
	public int setScore(String tpId, String[] userIds, String[] points) {
		// TODO Auto-generated method stub  utlMapper
		int count = 0;
		for (int i = 0; i < points.length; i++) {
			UserTestList utl = new UserTestList();
			utl.setUtsId(UUID.randomUUID().toString());
			utl.setTpId(tpId);
			utl.setUserId(userIds[i]);
			utl.setUtsTime(new Date());
			utl.setUtsTotal(Integer.parseInt(points[i]));
			count += utlMapper.insertSelective(utl);
		}
		
		return count;
	}

	@Override
	public UserTestList queryUtlById(String utsId) {
		// TODO Auto-generated method stub
		return utlMapper.selectByPrimaryKey(utsId);
	}

	@Override
	public Map<String, Object> classplanlist(String mcId) {
		// TODO Auto-generated method stub
	
		// 取得基本信息
		
		List<TestPlan> tpList = planMapper.queryByUserClassNotType(mcId);
		System.out.println(tpList);
		List<SysUser> userList = userMapper.queryByMcId(mcId);
		System.out.println(userList);
		UserMyclass mc = userMyclassMapper.selectByPrimaryKey(mcId);
		
		
		// 总容器
		Map<String, Object> map = new HashMap<>();
		// tpNames 测试名称
		List<String> tpNames = new ArrayList<String>();
		// userNames  学生名称
		List<String> userNames = new ArrayList<String>();
		
		for (int i = 0; i < userList.size(); i++) {
			userNames.add( userList.get(i).getNickName() );
		}
		
		// 成绩 tplist  里面装 第一个人的成绩
		
		List<Map<String, Object>> tpProintsList = new ArrayList<>();
//		  name:'蒸发量',
//	        type:'bar',
//	        data:
		for (int i = 0; i < tpList.size(); i++) {
			Map<String, Object> mm = new HashMap<String, Object>();
			TestPlan tp = tpList.get(i);
			tpNames.add( tp.getTpTitle() );
			mm.put("name", tp.getTpTitle());
			mm.put("type", "bar");
			List<Integer> data = new ArrayList<>();
			for (int j = 0; j < userList.size(); j++) {
				SysUser user = userList.get(j);
				List<UserTestList> utlList = utlMapper.queryByUserAndTp(user.getUserId(), tp.getTpId());
			//	System.err.println(utlList);
				if (utlList!=null  && utlList.size()>0) {
					data.add( utlList.get(0).getUtsTotal() );
				} else {
					data.add( 0 );
				}
				
			}
			mm.put("data", data);
			tpProintsList.add(mm);
		}
		
		map.put("tpNames", tpNames);
		map.put("userNames", userNames);
		map.put("tpProintsList", tpProintsList);
		map.put("mc", mc.getMcCode());
		

		
		return map;
	}

	@Override
	public List<Map<String, Object>> clasTestlist(String mcId) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<>();
		List<TestPlan> tpList = planMapper.queryByUserClass(mcId, "3");
		System.out.println(tpList);
		List<SysUser> userList = userMapper.queryByMcId(mcId);
		System.out.println(userList);
		
		for (SysUser sysUser : userList) {
			Map<String, Object> map = new HashMap<>();
			map.put("userId", sysUser.getUserId());
			map.put("nickName", sysUser.getNickName());
			List<Map<String, Object>> levels = new ArrayList<>(); // 次数/平均分
			for (int i = 0; i < tpList.size(); i++) {
				Map<String, Object> mm = new HashMap<String, Object>();
				TestPlan tp = tpList.get(i);
				mm.put("tpId", tp.getTpId());				
				List<UserTestList> utlList = utlMapper.queryByUserAndTp(sysUser.getUserId(), tp.getTpId());
				if (utlList!=null && utlList.size()>0) {
					double tt = 0.0;
					for (int j = 0; j < utlList.size(); j++) {
						UserTestList utl = utlList.get(j);
						tt += utl.getUtsTotal();
					}
					double pjf = tt/utlList.size()/1.0;
					pjf = (double) Math.round(pjf * 100) / 100;
					String btn = "";
					if (pjf > 80) {
						btn = "<button type=\"button\" class=\"btn btn-primary btn-xs\"  onclick=\"ansList('" + tp.getTpId() + "','" + sysUser.getUserId() + "')\" >" + utlList.size() + "次(" + pjf + "分)" + "</button>";
					} else if(pjf > 60) {
						btn = "<button type=\"button\" class=\"btn btn-info btn-xs\"    onclick=\"ansList('" + tp.getTpId() + "','" + sysUser.getUserId() + "')\">" + utlList.size() + "次(" + pjf + "分)" + "</button>";
					} else if(pjf > 30) {
						btn = "<button type=\"button\" class=\"btn btn-warning btn-xs\"   onclick=\"ansList('" + tp.getTpId() + "','" + sysUser.getUserId() + "')\">" + utlList.size() + "次(" + pjf + "分)" + "</button>";
					} else  {
						btn = "<button type=\"button\" class=\"btn btn-danger btn-xs\"    onclick=\"ansList('" + tp.getTpId() + "','" + sysUser.getUserId() + "')\">" + utlList.size() + "次(" + pjf + "分)" + "</button>";
					}

					mm.put("info",btn);
				} else {
					mm.put("info","<button type=\"button\" class=\"btn  btn-xs\">0次(0.0分)</button>");
				}
				levels.add(mm);
			}
			map.put("levels", levels);
			
			list.add(map);
		}
		System.out.println( list );
		
		return list;
	}

	@Override
	public List<TestPlan> queryByUserClass3(String mcId) {
		// TODO Auto-generated method stub
		return planMapper.queryByUserClass(mcId, "3");
	}

	@Override
	public SysUser queryUserById(String userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public Map<String, Object> checkAnswer(String type, String[] qstns0, String[] ans0, String[] qstns2, String[] ans2,
			String[] qstns4, String[] ans4) {
	//	System.err.println(type);
		Map<String, Object> map = new HashMap<String, Object>();
		// map .answer  / qstn  /  result
		if ("0".equals(type)) {
			Question qstn = qstnMapper.selectByPrimaryKey(qstns0[0]);			
			map.put("qstn", qstn);
			if(ans0!=null && ans0.length>0) {
				//ual.setUansContent(ans0[i]);
				Answer ans = ansMapper.selectByPrimaryKey(ans0[0]);
				map.put("answer", ans.getAnsContent());
			}							
			double result = 0.0;
			// ----------------------------
			if(ans0!=null && ans0.length>0) {
				result = this.checkAnswer0(qstns0[0], ans0[0]);
			}else {
				result = this.checkAnswer0(qstns0[0], "");
			}
			map.put("result", result);
			
		} else if ("2".equals(type)){
			
			Question qstn = qstnMapper.selectByPrimaryKey(qstns2[0]);
			map.put("qstn", qstn);
			map.put("answer", ans2[0]);			
			double result = this.checkAnswer2(qstns2[0], ans2[0]);				
			map.put("result", result);
			
		} else if ("4".equals(type)){
			Question qstn = qstnMapper.selectByPrimaryKey(qstns4[0]);			
			map.put("qstn", qstn);
			map.put("answer", ans4[0]);		
			
			double result = this.checkAnswer4(qstns4[0], ans4[0]);
			map.put("result", result);
		}else {
			map = null;
		}
		return map;
	}

	@Override
	public List<Answer> queryAnswersByQstnId(String qstnId) {
		// TODO Auto-generated method stub
		return ansMapper.queryByQstnId(qstnId);
	}

	@Override
	public Question queryQstnById(String qstnId) {
		// TODO Auto-generated method stub
		return qstnMapper.selectByPrimaryKey(qstnId);
	}

	@Override
	public int setPlanTarget(TestPlan plan) {
		// TODO Auto-generated method stub
		planMapper.updateByPrimaryKeySelective(plan);
		//tpctMapper
		TestplanClassteam tpct = new TestplanClassteam();
		tpct.setTpctId(UUID.randomUUID().toString());
		tpct.setTpId(plan.getTpId());
		tpct.setMcId(plan.getTpTarget());
		
		return tpctMapper.insertSelective(tpct);
	}

	@Override
	public List<UserAnswerList> queryQstnPlanMc(String tpId, String mcId) {
		// TODO Auto-generated method stub
		List<SysUser> userList = userMapper.queryByMcId(mcId);
		
		List<UserAnswerList> ansList = new ArrayList<>();
		
		for (SysUser sysUser : userList) {
			List<UserAnswerList> aList = ualMapper.queryList(sysUser.getUserId(), tpId);
			ansList.addAll(aList);
		}
		System.out.println(ansList.size());
		
		return ansList;
	}

	@Override
	public Integer totalCount(String tpId, String mcId, String qstnId) {
		// TODO Auto-generated method stub
		return ualMapper.totalCount(qstnId, tpId);
	}
	@Override
	public Integer totalYes(String tpId, String mcId, String qstnId) {
		// TODO Auto-generated method stub
		return ualMapper.totalYes(qstnId, tpId);
	}
	@Override
	public Integer totalNo(String tpId, String mcId, String qstnId) {
		// TODO Auto-generated method stub
		return ualMapper.totalNo(qstnId, tpId);
	}

	@Override
	public SubjSection querySctnById(String sctnId) {
		// TODO Auto-generated method stub
		return sctnMapper.selectByPrimaryKey(sctnId);
	}

	@Override
	public Integer totalSctnCount(String tpId, String mcId, String sctnId) {
		// TODO Auto-generated method stub
		return ualMapper.totalSctnCount(sctnId, tpId);
	}

	@Override
	public Integer totalSctnYes(String tpId, String mcId, String sctnId) {
		// TODO Auto-generated method stub
		return ualMapper.totalSctnYes(sctnId, tpId);
	}

	@Override
	public Integer totalSctnNo(String tpId, String mcId, String sctnId) {
		// TODO Auto-generated method stub
		return ualMapper.totalSctnNo(sctnId, tpId);
	}

	@Override
	public SubjUnit queryUnitById(String unitId) {
		// TODO Auto-generated method stub
		return unitMapper.selectByPrimaryKey(unitId);
	}

	@Override
	public Integer totalUnitCount(String tpId, String mcId, String unitId) {
		// TODO Auto-generated method stub
		return ualMapper.totalUnitCount(unitId, tpId);
	}

	@Override
	public Integer totalUnitYes(String tpId, String mcId, String unitId) {
		// TODO Auto-generated method stub
		return ualMapper.totalUnitYes(unitId, tpId);
	}

	@Override
	public Integer totalUnitNo(String tpId, String mcId, String unitId) {
		// TODO Auto-generated method stub
		return ualMapper.totalUnitNo(unitId, tpId);
	}

	@Override
	public List<Answer> queryByQstnId(String qstnId) {
		// TODO Auto-generated method stub
		return ansMapper.queryByQstnId(qstnId);
	}

	@Override
	public List<UserAnswerList> totalUal(String tpId, String qstnId) {
		// TODO Auto-generated method stub
		List<UserAnswerList> list = ualMapper.totalUal(qstnId, tpId);
		for (UserAnswerList ual : list) {
			if ("0".equals(ual.getQstnTypeId())) {
				if (ual.getUansContent()==null  ||  "".equals(ual.getUansContent().trim())) {
					ual.setShowContent("");
				} else {
					Answer ans = ansMapper.selectByPrimaryKey(ual.getUansContent().trim());
					ual.setShowContent(ans.getAnsContent());
				}
				
			} else {
				ual.setShowContent(ual.getUansContent());
			}
		}
		return list;
	}

	

	
}
