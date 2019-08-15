package com.yuzo.question.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.page.QuestionPage;




public interface IQuestionService {

	List<QstnFromType> queryQstnFrom();

	List<QuestionType> queryQstnType();

	List<SubjSection> querySubjSctn();
	
	List<SubjectCourse> querySubj();

	List<SubjUnit> querySubjUnit();

	JSONObject uploadSimditorImg(MultipartFile file, String type );

	int save(Question qstn);

	List<Question> queryAll(QuestionPage page);

	Question queryById(String id);



	SubjSection querySctnBySctnId(String subjSctnId);

	SubjUnit queryUnitByUnitId(String subjUnitId);

	List<Answer> queryAnswersByQstnId(String id);

	int update(Question qstn);

	int dels(String[] ids);

	List<Answer> queryAnswer4(String qstnId);

	int addCode();

	void totalCount();

}
