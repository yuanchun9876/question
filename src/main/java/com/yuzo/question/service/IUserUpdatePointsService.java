package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.UserReplyList;
import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.UserUpdatePointsType;

public interface IUserUpdatePointsService {

	int save(UserUpdatePointsType uupt);

	UserUpdatePointsType queryById(String uuptId);

	int update(UserUpdatePointsType uupt);

	int dels(String[] ids);

	List<UserReplyList> queryReplyByUserId(String userId);

	List<UserUpdatePoints> queryUupByUserId(String userId);

	List<UserUpdatePointsType> queryUupt();

	int save(UserUpdatePoints uup);

	UserUpdatePoints queryUupById(String uupId);

}
