package com.yuzo.question.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.mapper.UserMyclassMapper;
import com.yuzo.question.mapper.UserTeamMapper;
import com.yuzo.question.page.UserTeamPage;
import com.yuzo.question.service.IUserTeamService;

@Service
public class UserTeamServiceImpl implements IUserTeamService {
	
	@Autowired
	private UserTeamMapper tmMapper;
	
	@Autowired
	private UserMyclassMapper userMyclassMapper;


	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += tmMapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}

	@Override
	public int update(UserTeam tm) {
		// TODO Auto-generated method stub
		return tmMapper.updateByPrimaryKeySelective(tm);
	}

	@Override
	public UserTeam queryById(String tmId) {
		// TODO Auto-generated method stub
		return tmMapper.selectByPrimaryKey(tmId);
	}

	@Override
	public int save(UserTeam tm) {
		// TODO Auto-generated method stub
		tm.setTmId(UUID.randomUUID().toString());
		tm.setTmTotal(100);
		return tmMapper.insertSelective(tm);
	}

	@Override
	public List<UserTeam> querytm() {
		// TODO Auto-generated method stub
		return tmMapper.queryAll();
	}

	@Override
	public List<UserMyclass> querymc() {
		// TODO Auto-generated method stub
		return userMyclassMapper.queryAll();
	}

	@Override
	public List<UserTeam> querytm(UserTeamPage page) {
		// TODO Auto-generated method stub
		return tmMapper.queryByMc(page);
	}

}
