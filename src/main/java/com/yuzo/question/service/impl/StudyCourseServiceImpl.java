package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.StudyPeriod;
import com.yuzo.question.mapper.StudyCourseMapper;
import com.yuzo.question.mapper.StudyPeriodMapper;
import com.yuzo.question.service.IStudyCourseService;

@Service
public class StudyCourseServiceImpl implements IStudyCourseService {

	@Autowired
	private StudyCourseMapper mapper;
	@Autowired
	private StudyPeriodMapper pdMapper;
	
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

}
