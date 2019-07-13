package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.UserMyclass;

public interface IUserClassService {

	List<UserMyclass> querymc();

	int save(UserMyclass mc);

	UserMyclass queryById(String mcId);

	int update(UserMyclass mc);

	int dels(String[] ids);

}
