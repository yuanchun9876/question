package com.yuzo.question.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.StuCrseList;
import com.yuzo.question.entity.StuCrseTest;
import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.StudyCourseQuestion;
import com.yuzo.question.entity.StudyCourseSection;
import com.yuzo.question.entity.StudyPeriod;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.TestPlanDetailed;
import com.yuzo.question.entity.UserAnswerList;
import com.yuzo.question.entity.UserTestList;
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
import com.yuzo.question.service.IStuCrseService;
import com.yuzo.question.service.IStudyCourseService;

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
}
