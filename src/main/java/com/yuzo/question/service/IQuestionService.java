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




public interface IQuestionService {

	List<QstnFromType> queryQstnFrom();

	List<QuestionType> queryQstnType();

	List<SubjSection> querySubjSctn();

	JSONObject uploadSimditorImg(MultipartFile file, String picRootPath,String type, String contextPath );

	int save(Question qstn);

	List<Question> queryAll();

	Question queryById(String id);

	List<SubjectCourse> querySubj();

	List<SubjUnit> querySubjUnit();

	SubjSection querySctnBySctnId(String subjSctnId);

	SubjUnit queryUnitByUnitId(String subjUnitId);

	List<Answer> queryAnswersByQstnId(String id);

}
