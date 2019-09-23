package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.StudyPeriod;

public interface IStudyCourseService {

	List<StudyCourse> queryAll();

	List<StudyPeriod> queryPeriod();

	int save(StudyCourse crse);

	StudyCourse queryById(String crseId);

	int update(StudyCourse crse);

	int dels(String[] ids);

}
