package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.UserAnswerList;

public interface UserAnswerListMapper {
    int deleteByPrimaryKey(String uansId);

    int insert(UserAnswerList record);

    int insertSelective(UserAnswerList record);

    UserAnswerList selectByPrimaryKey(String uansId);

    int updateByPrimaryKeySelective(UserAnswerList record);

    int updateByPrimaryKey(UserAnswerList record);

	List<UserAnswerList> queryUalBy(@Param("utsId")String utsId,  @Param("type")String type);

	List<UserAnswerList> queryList(@Param("userId")String userId,  @Param("tpId")String tpId);

	Integer totalCount(@Param("qstnId")String qstnId, @Param("tpId")String tpId);
	Integer totalYes(@Param("qstnId")String qstnId, @Param("tpId")String tpId);
	Integer totalNo(@Param("qstnId")String qstnId, @Param("tpId")String tpId);

	Integer totalSctnCount(@Param("sctnId")String sctnId, @Param("tpId")String tpId);

	Integer totalSctnYes(@Param("sctnId")String sctnId, @Param("tpId")String tpId);

	Integer totalSctnNo(@Param("sctnId")String sctnId, @Param("tpId")String tpId);

	Integer totalUnitCount(@Param("unitId")String unitId, @Param("tpId")String tpId);

	Integer totalUnitYes(@Param("unitId")String unitId, @Param("tpId")String tpId);

	Integer totalUnitNo(@Param("unitId")String unitId, @Param("tpId")String tpId);
}