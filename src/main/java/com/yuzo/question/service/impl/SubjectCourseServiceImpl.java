package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.mapper.SubjectCourseMapper;
import com.yuzo.question.service.ISubjectCourseService;



@Service
public class SubjectCourseServiceImpl implements ISubjectCourseService{

	@Autowired
	private SubjectCourseMapper subjMapper;
	

	@Override
	public int save(SubjectCourse subj) {
		// TODO Auto-generated method stub
		subj.setSubjCode(subj.getSubjCode().toLowerCase());
		return subjMapper.insertSelective(subj);
	}

	@Override
	public SubjectCourse queryById(String subjId) {
		// TODO Auto-generated method stub
		return subjMapper.selectByPrimaryKey(subjId);
	}

	@Override
	public List<SubjectCourse> query() {
		// TODO Auto-generated method stub
		return subjMapper.queryAll();
	}

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += subjMapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}

	@Override
	public int update(SubjectCourse subj) {
		// TODO Auto-generated method stub
		subj.setSubjCode(subj.getSubjCode().toLowerCase());
		return subjMapper.updateByPrimaryKeySelective(subj);
	}

	@Override
	public List<SubjectCourse> queryByCode(String subjCode) {
		// TODO Auto-generated method stub
		return subjMapper.queryByCode(subjCode);
	}
}
