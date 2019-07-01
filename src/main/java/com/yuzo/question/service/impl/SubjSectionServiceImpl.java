package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.mapper.SubjSectionMapper;
import com.yuzo.question.mapper.SubjUnitMapper;
import com.yuzo.question.service.ISubjSectionService;



@Service
public class SubjSectionServiceImpl implements ISubjSectionService{

	@Autowired
	private SubjSectionMapper sctnMapper;
	
	@Autowired
	private SubjUnitMapper unitMapper;

	@Override
	public List<SubjSection> queryByTchId(String tchId) {
		// TODO Auto-generated method stub
		return sctnMapper.queryAllByTchId(tchId);
	}

	@Override
	public List<SubjUnit> queryUnit() {
		// TODO Auto-generated method stub
		return unitMapper.queryAll();
	}

	@Override
	public List<SubjUnit> queryUnitByTchId(String tchId) {
		// TODO Auto-generated method stub
		return unitMapper.queryByTchId(tchId);
	}

	@Override
	public int save(SubjSection sctn) {
		// TODO Auto-generated method stub
		
		return sctnMapper.insertSelective(sctn);
	}

	@Override
	public SubjSection queryById(String subjSctnId) {
		// TODO Auto-generated method stub
		return sctnMapper.selectByPrimaryKey(subjSctnId);
	}
	
	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += sctnMapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}

	@Override
	public List<SubjSection> querySctnByUnit(String unitId) {
		// TODO Auto-generated method stub
		return sctnMapper.queryByUnit(unitId);
	}
}
