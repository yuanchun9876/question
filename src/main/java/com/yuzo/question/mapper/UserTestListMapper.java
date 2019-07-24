package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.UserTestList;

public interface UserTestListMapper {
    int deleteByPrimaryKey(String utsId);

    int insert(UserTestList record);

    int insertSelective(UserTestList record);

    UserTestList selectByPrimaryKey(String utsId);

    int updateByPrimaryKeySelective(UserTestList record);

    int updateByPrimaryKey(UserTestList record);

	List<UserTestList> queryByUserAndTp(@Param("userId")String userId, @Param("tpId")String tpId);
}