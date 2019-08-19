package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.UserReplyList;
import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.UserUpdatePointsType;
import com.yuzo.question.entity.WorkList;

public interface IUserUpdatePointsService {


	UserUpdatePointsType queryById(String uuptId);

	int update(UserUpdatePoints uup);

	int dels(String[] ids);

	List<UserReplyList> queryReplyByUserId(String userId);

	List<UserUpdatePoints> queryUupByUserId(String userId);

	List<UserUpdatePointsType> queryUupt();

	int save(UserUpdatePoints uup);

	UserUpdatePoints queryUupById(String uupId);

	List<WorkList> queryWl();

}
