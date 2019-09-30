package com.yuzo.question.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.StuCrseList;
import com.yuzo.question.entity.StuCrseTest;
import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.mapper.AnswerMapper;
import com.yuzo.question.mapper.QuestionMapper;
import com.yuzo.question.mapper.StuCrseListMapper;
import com.yuzo.question.mapper.StuCrseTestMapper;
import com.yuzo.question.mapper.StudyCourseMapper;
import com.yuzo.question.mapper.StudyCourseQuestionMapper;
import com.yuzo.question.mapper.StudyCourseSectionMapper;
import com.yuzo.question.mapper.StudyPeriodMapper;
import com.yuzo.question.mapper.SubjSectionMapper;
import com.yuzo.question.mapper.SubjUnitMapper;
import com.yuzo.question.mapper.SubjectCourseMapper;
import com.yuzo.question.mapper.SysUserMapper;
import com.yuzo.question.service.IStuCrseService;

@Service
public class StuCrseServiceImpl implements IStuCrseService {

	@Autowired
	private StudyCourseMapper mapper;
	@Autowired
	private StudyPeriodMapper pdMapper;
	
	@Autowired
	private SubjSectionMapper sctnMapper;
	
	@Autowired
	private SubjUnitMapper unitMapper;
	
	@Autowired
	private SubjectCourseMapper subjMapper;
	
	@Autowired
	private QuestionMapper qstnMapper;
	
	@Autowired
	private AnswerMapper ansMapper;
	
	@Autowired
	private StudyCourseSectionMapper crseSctnMapper;
	
	@Autowired
	private StudyCourseQuestionMapper crseQstnMapper;
	
	@Autowired
	private StudyCourseMapper crseMapper;
	
	@Autowired
	private StuCrseTestMapper sctMapper;
	
	@Autowired
	private StuCrseListMapper sclMapper;
	
	@Autowired
	private SysUserMapper userMapper;
	
	
	@Override
	public List<StudyCourse> queryStudyCourse() {
		// TODO Auto-generated method stub
		return mapper.query();
	}




	@Override
	public StudyCourse queryCrseById(String crseId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(crseId);
	}




	@Override
	public List<Question> queryQstnFlag(String crseId, String type, String flag) {
		// TODO Auto-generated method stub
		return qstnMapper.queryQstnByCrse(crseId, type, flag);
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
	public void saveAnswer(SysUser user, String crseId, String[] qstns0, String[] ans0, String[] qstns2,String[] ans2) {
		
		StudyCourse crse = crseMapper.selectByPrimaryKey(crseId);
		
		int points0 = 5;
		int points2 = 5;

		
		
		
		int total = 0;
		
		StuCrseTest sct = new StuCrseTest();
		String sctId = UUID.randomUUID().toString();
		sct.setSctId(sctId);
		sct.setCrseId(crseId);
		sct.setUserId(user.getUserId());
		sct.setSctTime(new Date());
		// 时长
		
		
		// 序号
		Integer maxNum = sctMapper.querySctMaxNum(crseId, user.getUserId());
		sct.setSctNum(maxNum==null?1:(maxNum + 1));
		sctMapper.insertSelective(sct);
	
		// 记录 0.单选题
		if(qstns0!=null  &&  qstns0.length>0) {
			for (int i = 0; i < qstns0.length; i++) {
				StuCrseList scl = new StuCrseList();
				scl.setSclId(UUID.randomUUID().toString());
				scl.setQstnId(qstns0[i]);
				scl.setSctId(sctId);
				
				// ----------------------------
				if(ans0!=null && ans0.length>i) {
					scl.setSclContent(ans0[i]);
				}				

				double result = 0.0;
				// ----------------------------
				if(ans0!=null && ans0.length>i) {
					result = this.checkAnswer0(qstns0[i], ans0[i]);
				}else {
					result = this.checkAnswer0(qstns0[i], "");
				}
				
				int result0 =  (int) Math.round(points0 * result);
				
				total += result0;
				
				scl.setSclResult(result0 + "");
				
				sclMapper.insertSelective(scl);
			}
		}
	
		
		
		// 记录 2.填空题
		if(qstns2!=null  &&  qstns2.length>0) {
			for (int i = 0; i < qstns2.length; i++) {
				
				StuCrseList scl = new StuCrseList();
				scl.setSclId(UUID.randomUUID().toString());
				scl.setQstnId(qstns2[i]);
				scl.setSctId(sctId);
							
				scl.setSclContent(ans2[i]);

				
				double result = this.checkAnswer2(qstns2[i], ans2[i]);
				int result2 =  (int) Math.round(points2 * result);
				
				total += result2;
				
				scl.setSclResult(result2+"");
				
				sclMapper.insertSelective(scl);
			}
		}

		
		// 合计分数
		
		sct.setSctTotal(total);
		sctMapper.updateByPrimaryKeySelective(sct);
		
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


	// 填空题判断
	private double checkAnswer2(String qstnId, String answer) {
		// TODO Auto-generated method stub
		List<Answer> ansList = ansMapper.queryByQstnId(qstnId);
		
		int total = 0;
		for (Answer ans : ansList) {
			System.err.println("ans:" + ans);
			String anscontent = this.getStr(ans.getAnsContent()).trim().toLowerCase();
			anscontent = anscontent.replaceAll("&lt;", "<");
			anscontent = anscontent.replaceAll("&gt;", ">");
			anscontent = anscontent.replaceAll("&amp;", "&");
//			System.out.println(answer.trim().toLowerCase());
			System.err.println("anscontent:" + anscontent);
			System.err.println(answer.trim().toLowerCase());
			if(anscontent.equals(answer.trim().toLowerCase())) {
				
				total = 1;		
				break;
			}
		}		
		return total/1.0;
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
	public List<StuCrseTest> queryStuCrseTest(String crseId, String userId) {
		// TODO Auto-generated method stub
		System.out.println(crseId + ":" + userId);
		return sctMapper.querySctByCrseAndUser(crseId, userId);
	}




	@Override
	public List<StuCrseList> queryStuCrseListByType(String sctId, String type) {
		// TODO Auto-generated method stub
		return sclMapper.queryStuCrseListByType(sctId, type);
	}




	@Override
	public List<StuCrseList> addAnswerByQstnForScl0(List<StuCrseList> sclList0) {
		// TODO Auto-generated method stub
		for (StuCrseList scl : sclList0) {
			List<Answer> ansList = ansMapper.queryByQstnId(scl.getQstnId());
			scl.setAnsList(ansList);
			if (scl.getSclContent()!=null  &&  !"".equals(scl.getSclContent())) {
				Answer ans = ansMapper.selectByPrimaryKey(scl.getSclContent());
				System.out.println("ans.getAnsContent():" + ans.getAnsContent());
				scl.setAnsContent(ans.getAnsContent());
			} else {
				scl.setAnsContent("");
			}
			
		}
		return sclList0;
	}




	@Override
	public List<StuCrseList> addAnswerByQstnForScl2(List<StuCrseList> sclList2) {
		// TODO Auto-generated method stub
		for (StuCrseList scl : sclList2) {
			List<Answer> ansList = ansMapper.queryByQstnId(scl.getQstnId());
			scl.setAnsList(ansList);	
		}
		return sclList2;
	}




	@Override
	public StuCrseTest queryById(String sctId) {
		// TODO Auto-generated method stub
		return sctMapper.selectByPrimaryKey(sctId);
	}




	@Override
	public List<StuCrseTest> querySctByCrseId(String crseId, String userId) {
		// TODO Auto-generated method stub
		return sctMapper.querySctByCrseAndUser(crseId, userId);
	}




	@Override
	public List<StuCrseList> querySclByCrseAndUser(String crseId, String userId) {
		// TODO Auto-generated method stub
		return sclMapper.queryByCrseAndUser(crseId, userId);
	}




	@Override
	public List<Map<String, Object>> querySclCountByCrseAndUser(String crseId, String userId) {
		// TODO Auto-generated method stub
		return sclMapper.queryCountByCrseAndUser(crseId, userId);
	}


	@Override
	public Integer totalSctnYes(String crseId, String userId, String sctnId) {
		// TODO Auto-generated method stub
		return sclMapper.totalSctnYes( crseId, userId, sctnId);
	}



	@Override
	public List<Map<String, Object>> queryMcSclList(String crseId, String mcId) {
		// TODO Auto-generated method stub
		List<SysUser> userList = userMapper.queryByMcId(mcId);
		
		Set<String> qstnIds = new HashSet<>();
//		List<StuCrseList> list = new ArrayList<>();
		for (SysUser sysUser : userList) {
			List<StuCrseList> sclList = sclMapper.queryByCrseAndUser(crseId, sysUser.getUserId());
//			list.addAll(sclList);
			for (StuCrseList stuCrseList : sclList) {
				qstnIds.add(stuCrseList.getQstnId());
			}
		}
		
		List<Map<String, Object>> list = new ArrayList<>();
		// qstnId
		// qstnTitle
		// sctnId
		// sctnTitle
		// qstnCount
		// qstn_yes
		// qstn_no
		for (String qstnId : qstnIds) {
			Map<String, Object> map = new HashMap<>();
			map.put("qstnId", qstnId);
			Question qstn = qstnMapper.selectByPrimaryKey(qstnId);
			map.put("qstnTitle", qstn.getQstnTitle());
			map.put("qstnCode", qstn.getQstnCode());
			map.put("sctnId", qstn.getSubjSctnId());
			map.put("sctnTitle", qstn.getSubjSctnTitle());
			
			Integer qstnCount = sclMapper.queryCountByCrseAndUser(crseId, qstnId, mcId);
			System.out.println("qstnCount:" + qstnCount);
			map.put("qstnCount", qstnCount);
			
			Integer qstn_yes = sclMapper.queryYesCountByCrseAndUser(crseId, qstnId, mcId);
			System.out.println("qstn_yes:" + qstn_yes);
			map.put("qstn_yes", qstn_yes);
			
			Integer qstn_no = sclMapper.queryNoCountByCrseAndUser(crseId, qstnId, mcId);
			System.out.println("qstn_no:" + qstn_no);
			map.put("qstn_no", qstn_no);
			
			int yes_count =  (int) Math.round(qstn_yes/1.0/qstnCount*100);			
			map.put("qstn_yes_count", yes_count);
			if (yes_count >= 80 ) {
				map.put("qstn_ratio", "<button type=\"button\" class=\"btn btn-primary btn-xs\">" + yes_count + "%</button>");
			} else if (yes_count >= 60  &&  yes_count < 80) {
				map.put("qstn_ratio", "<button type=\"button\" class=\"btn btn-info btn-xs\">" + yes_count + "%</button>");
			} else if (yes_count >= 30  &&  yes_count < 60) {
				map.put("qstn_ratio", "<button type=\"button\" class=\"btn btn-warning btn-xs\">" + yes_count + "%</button>");
			} else {
				map.put("qstn_ratio", "<button type=\"button\" class=\"btn btn-danger btn-xs\">" + yes_count + "%</button>");
			}
			
			list.add(map);
		}
		
		
		Collections.sort(list, new Comparator<Map>() {
			@Override
			public int compare(Map u1, Map u2) {
				int diff = (int)u1.get("qstn_yes_count") - (int)u2.get("qstn_yes_count");
				if (diff > 0) {
					return 1;
				} else if (diff < 0) {
					return -1;
				}
				return 0; // 相等为0
			}
		}); // 排序
		
		return list;
	}
}
