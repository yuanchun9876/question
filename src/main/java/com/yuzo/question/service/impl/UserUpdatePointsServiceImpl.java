package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.UserReplyList;
import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.UserUpdatePointsType;
import com.yuzo.question.mapper.UserReplyListMapper;
import com.yuzo.question.mapper.UserUpdatePointsMapper;
import com.yuzo.question.service.IUserUpdatePointsService;

@Service
public class UserUpdatePointsServiceImpl implements IUserUpdatePointsService {

	@Autowired
	private UserReplyListMapper urMapper;
	
	@Autowired
	private UserUpdatePointsMapper uupMapper;
	
	@Override
	public int save(UserUpdatePointsType uupt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserUpdatePointsType queryById(String uuptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(UserUpdatePointsType uupt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserReplyList> queryReplyByUserId(String userId) {
		// TODO Auto-generated method stub
		return urMapper.queryByUser(userId);
	}

	@Override
	public List<UserUpdatePoints> queryUupByUserId(String userId) {
		// TODO Auto-generated method stub
		return uupMapper.queryByUser(userId);
	}

}
