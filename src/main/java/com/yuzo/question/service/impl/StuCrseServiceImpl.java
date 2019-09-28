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





}
