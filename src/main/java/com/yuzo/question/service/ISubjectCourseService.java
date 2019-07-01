package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.SubjectCourse;



public interface ISubjectCourseService {

	int save(SubjectCourse subj);

	SubjectCourse queryById(String subjSctnId);

	List<SubjectCourse> query();

	int dels(String[] ids);

}
