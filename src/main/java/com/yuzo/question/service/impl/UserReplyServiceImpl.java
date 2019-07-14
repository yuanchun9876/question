package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.TestPlan;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.mapper.TestPlanMapper;
import com.yuzo.question.mapper.UserMyclassMapper;
import com.yuzo.question.service.IUserReplyService;

@Service
public class UserReplyServiceImpl implements IUserReplyService{
	
	@Autowired
	private TestPlanMapper planMapper;
	
	@Autowired
	private UserMyclassMapper userMyclassMapper;

	@Override
	public List<TestPlan> querytp() {
		// TODO Auto-generated method stub
		return planMapper.queryAll();
	}

	@Override
	public List<UserMyclass> querymc() {
		// TODO Auto-generated method stub
		return userMyclassMapper.queryAll();
	}

	@Override
	public List<Question> queryQstnByTp(String tpId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
