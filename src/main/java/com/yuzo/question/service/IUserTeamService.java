package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.page.UserTeamPage;

public interface IUserTeamService {

	int dels(String[] ids);

	int update(UserTeam tm);

	UserTeam queryById(String tmId);

	int save(UserTeam tm);

	List<UserTeam> querytm();

	List<UserMyclass> querymc();

	List<UserTeam> querytm(UserTeamPage page);

	List<UserTeam> queryTmByMc(String mcId);



}
