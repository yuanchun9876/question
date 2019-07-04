package com.yuzo.question.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.mapper.AnswerMapper;
import com.yuzo.question.mapper.QstnFromTypeMapper;
import com.yuzo.question.mapper.QuestionMapper;
import com.yuzo.question.mapper.QuestionTypeMapper;
import com.yuzo.question.mapper.SubjSectionMapper;
import com.yuzo.question.mapper.SubjUnitMapper;
import com.yuzo.question.mapper.SubjectCourseMapper;
import com.yuzo.question.service.IAnswerService;
import com.yuzo.question.service.IQuestionService;


@Service
public class AnswerServiceImpl implements IAnswerService{

	
	@Autowired
	private AnswerMapper ansMapper;

	@Autowired
	private QuestionMapper qstnMapper;
	

	@Override
	public List<Answer> queryByQstnId(String qstnId) {
		return ansMapper.queryByQstnId(qstnId);
	}

	@Override
	public Question queryQstnById(String id) {
		return qstnMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(Answer ans) {		
		return ansMapper.insertSelective(ans);
	}

	@Override
	public Answer queryById(String id) {
		return ansMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Answer ans) {
		return ansMapper.updateByPrimaryKeySelective(ans);
	}

	@Override
	public int dels(String[] ids) {
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			ansMapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}

}
