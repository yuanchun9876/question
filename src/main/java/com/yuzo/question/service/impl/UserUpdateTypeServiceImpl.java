package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.UserUpdatePointsType;
import com.yuzo.question.mapper.UserUpdatePointsTypeMapper;
import com.yuzo.question.service.IUserUpdateTypeService;

@Service
public class UserUpdateTypeServiceImpl implements IUserUpdateTypeService {

	@Autowired
	private UserUpdatePointsTypeMapper uuptMapper;

	@Override
	public List<UserUpdatePointsType> query() {
		// TODO Auto-generated method stub
		return uuptMapper.queryAll();
	}

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += uuptMapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}

	@Override
	public int update(UserUpdatePointsType uupt) {
		// TODO Auto-generated method stub
		return uuptMapper.updateByPrimaryKeySelective(uupt);
	}

	@Override
	public UserUpdatePointsType queryById(String uuptId) {
		// TODO Auto-generated method stub
		return uuptMapper.selectByPrimaryKey(uuptId);
	}

	@Override
	public int save(UserUpdatePointsType uupt) {
		// TODO Auto-generated method stub
		return uuptMapper.insertSelective(uupt);
	}
}
