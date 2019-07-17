package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.UserUpdatePointsType;

public interface IUserUpdateTypeService {

	List<UserUpdatePoints> query();

	int dels(String[] ids);

	int update(UserUpdatePointsType uupt);

	UserUpdatePointsType queryById(String uuptId);

	int save(UserUpdatePointsType uupt);

}
