package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.StudyCourse;

public interface IStuCrseService {

	List<StudyCourse> queryStudyCourse();

	StudyCourse queryCrseById(String crseId);

}
