package com.yuzo.question.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.mapper.UserMyclassMapper;
import com.yuzo.question.service.IUserClassService;

@Service
public class UserClassServiceImpl implements IUserClassService {
	
	@Autowired
	private UserMyclassMapper userMyclassMapper;

	@Override
	public List<UserMyclass> querymc() {
		// TODO Auto-generated method stub
		return userMyclassMapper.queryAll();
	}

	@Override
	public int save(UserMyclass mc) {
		// TODO Auto-generated method stub
		mc.setMcId(UUID.randomUUID().toString());
		return userMyclassMapper.insertSelective(mc);
	}

	@Override
	public UserMyclass queryById(String mcId) {
		// TODO Auto-generated method stub
		return userMyclassMapper.selectByPrimaryKey(mcId);
	}

	@Override
	public int update(UserMyclass mc) {
		// TODO Auto-generated method stub
		return userMyclassMapper.updateByPrimaryKeySelective(mc);
	}

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += userMyclassMapper.deleteByPrimaryKey(ids[0]);
		}
		return count;
	} 

}
