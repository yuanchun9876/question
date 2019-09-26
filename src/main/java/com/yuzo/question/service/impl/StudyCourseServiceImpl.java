package com.yuzo.question.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.StudyCourseQuestion;
import com.yuzo.question.entity.StudyCourseSection;
import com.yuzo.question.entity.StudyPeriod;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.mapper.AnswerMapper;
import com.yuzo.question.mapper.QuestionMapper;
import com.yuzo.question.mapper.StudyCourseMapper;
import com.yuzo.question.mapper.StudyCourseQuestionMapper;
import com.yuzo.question.mapper.StudyCourseSectionMapper;
import com.yuzo.question.mapper.StudyPeriodMapper;
import com.yuzo.question.mapper.SubjSectionMapper;
import com.yuzo.question.mapper.SubjUnitMapper;
import com.yuzo.question.mapper.SubjectCourseMapper;
import com.yuzo.question.service.IStudyCourseService;

@Service
public class StudyCourseServiceImpl implements IStudyCourseService {

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
	
	
	
	
	@Override
	public List<StudyCourse> queryAll() {
		// TODO Auto-generated method stub
		return mapper.query();
	}

	@Override
	public List<StudyPeriod> queryPeriod() {
		// TODO Auto-generated method stub
		return pdMapper.query();
	}

	@Override
	public int save(StudyCourse crse) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(crse);
	}

	@Override
	public StudyCourse queryById(String crseId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(crseId);
	}

	@Override
	public int update(StudyCourse crse) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(crse);
	}

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += mapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}
	
	@Override
	public List<SubjSection> querySubjSctn() {
		// TODO Auto-generated method stub
		return sctnMapper.queryAll(null);
	}

	@Override
	public List<SubjectCourse> querySubj() {
		// TODO Auto-generated method stub
		return subjMapper.queryAll();
	}

	@Override
	public List<SubjUnit> querySubjUnit() {
		// TODO Auto-generated method stub
		return unitMapper.queryAll();
	}

	@Override
	public int setCrseSctn(String crseId, String[] sctnIds) {
		// TODO Auto-generated method stub
		int delCount = crseSctnMapper.delsByCrseId(crseId);
		int count = 0;
		for (String sctnId : sctnIds) {
			StudyCourseSection cs = new StudyCourseSection();
			cs.setCrseSctnId(UUID.randomUUID().toString());
			cs.setCrseId(crseId);
			cs.setSubjSctnId(sctnId);
			count += crseSctnMapper.insertSelective(cs);
		}
		return count;
	}

	@Override
	public int setCrseQstn(String crseId, String[] qstns) {
		// TODO Auto-generated method stub
		int delCount = crseQstnMapper.delsByCrseId(crseId);
		
		Set<String> qstnIds = new HashSet<>(Arrays.asList(qstns));
		int q0=0;
		int q1=0;
		int q2=0;
		int q3=0;
		int q4=0;
		int count = 0;
		for (String qstnId : qstnIds) {
			StudyCourseQuestion scq = new StudyCourseQuestion();
			scq.setCrseQstnId(UUID.randomUUID().toString());
			scq.setCrseId(crseId);
			scq.setQstnId(qstnId);
			Question qstn = qstnMapper.selectByPrimaryKey(qstnId);
			scq.setQstnTypeId(qstn.getQstnTypeId());
			scq.setSubjSctnId(qstn.getSubjSctnId());
			switch (qstn.getQstnTypeId()) {
			case "0":
				q0++;
				break;
			case "1":
				q1++;
				break;
			case "2":
				q2++;
				break;
			case "3":
				q3++;
				break;
			case "4":
				q4++;
				break;
			default:
				break;
			}
			count += crseQstnMapper.insertSelective(scq);
		}
		StudyCourse crse = mapper.selectByPrimaryKey(crseId);
		crse.setQstnCount0(q0);
		crse.setQstnCount1(q1);
		crse.setQstnCount2(q2);
		crse.setQstnCount3(q3);
		crse.setQstnCount4(q4);
		mapper.updateByPrimaryKeySelective(crse);
		return count;
	}

	@Override
	public List<StudyCourseQuestion> queryScqByCrseId(String crseId) {
		// TODO Auto-generated method stub
		return crseQstnMapper.queryScqByCrseId(crseId) ;
	}

	@Override
	public Question queryQstnById(String qstnId) {
		// TODO Auto-generated method stub
		return qstnMapper.selectByPrimaryKey(qstnId);
	}

	@Override
	public List<Question> addAnswerByQstn(List<Question> qstnList) {
		// TODO Auto-generated method stub
		for (Question question : qstnList) {
			List<Answer> ansList = ansMapper.queryByQstnId(question.getQstnId());
			Collections.shuffle(ansList);	
			question.setAnsList(ansList);
		}
		return qstnList;
	}

	@Override
	public SubjUnit queryUnitBySctnId(String subjSctnId) {
		// TODO Auto-generated method stub
		return unitMapper.queryUnitBySctnId(subjSctnId);
	}

	@Override
	public Integer totalUnitCount(String crseId, String subjUnitId) {
		// TODO Auto-generated method stub
		return crseQstnMapper.totalUnitCount(crseId, subjUnitId);
	}

	@Override
	public SubjUnit queryUnitById(String unitId) {
		// TODO Auto-generated method stub
		return unitMapper.selectByPrimaryKey(unitId);
	}

	@Override
	public List<SubjSection> querySctnsByUnit(String unitId) {
		// TODO Auto-generated method stub
		return sctnMapper.queryByUnit(unitId);
	}

	@Override
	public Integer totalSctnCount(String crseId, String subjSctnId) {
		// TODO Auto-generated method stub
		return crseQstnMapper.totalSctnCount(crseId, subjSctnId);
	}

}
