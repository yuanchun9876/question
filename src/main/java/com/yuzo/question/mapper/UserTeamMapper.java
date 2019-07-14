package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.page.UserTeamPage;

public interface UserTeamMapper {
    int deleteByPrimaryKey(String tmId);

    int insert(UserTeam record);

    int insertSelective(UserTeam record);

    UserTeam selectByPrimaryKey(String tmId);

    int updateByPrimaryKeySelective(UserTeam record);

    int updateByPrimaryKey(UserTeam record);

	List<UserTeam> queryAll();
	
	List<UserTeam> queryByMc(UserTeamPage page);

	List<UserTeam> queryTmByMcId(String mcId);
	
}