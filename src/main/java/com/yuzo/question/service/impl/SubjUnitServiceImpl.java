package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.mapper.SubjUnitMapper;
import com.yuzo.question.mapper.SubjectCourseMapper;
import com.yuzo.question.page.SubjUnitPage;
import com.yuzo.question.service.ISubjUnitService;



@Service
public class SubjUnitServiceImpl implements ISubjUnitService{

	@Autowired
	private SubjectCourseMapper subjMapper;
	
	@Autowired
	private SubjUnitMapper unitMapper;

	@Override
	public List<SubjUnit> queryByTchId(String tchId) {
		// TODO Auto-generated method stub
		return unitMapper.queryByTchId(tchId);
	}


	@Override
	public int save(SubjUnit unit) {
		// TODO Auto-generated method stub		
		return unitMapper.insertSelective(unit);
	}

	@Override
	public SubjUnit queryById(String subjUnitId) {
		// TODO Auto-generated method stub
		return unitMapper.selectByPrimaryKey(subjUnitId);
	}


	@Override
	public List<SubjectCourse> querySubjectCourse() {
		// TODO Auto-generated method stub
		return subjMapper.queryAll();
	}


	@Override
	public List<SubjUnit> queryAll() {
		// TODO Auto-generated method stub
		return unitMapper.queryAll();
	}


	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += unitMapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}


	@Override
	public List<SubjUnit> queryUnitBySubj(String subjId) {
		// TODO Auto-generated method stub
		return unitMapper.queryBySubj(subjId);
	}


	@Override
	public int update(SubjUnit unit) {
		// TODO Auto-generated method stub
		return unitMapper.updateByPrimaryKeySelective(unit);
	}


	@Override
	public List<SubjUnit> queryUnitsBySubjs(String[] subjIds) {
		// TODO Auto-generated method stub
		return unitMapper.queryUnitsBySubjs(subjIds);
	}


	@Override
	public List<SubjUnit> queryPage(SubjUnitPage page) {
		// TODO Auto-generated method stub
		return unitMapper.queryPage(page);
	}


	@Override
	public List<SubjUnit> queryByCode(String unitCode) {
		// TODO Auto-generated method stub
		return unitMapper.queryByCode(unitCode);
	}
}
