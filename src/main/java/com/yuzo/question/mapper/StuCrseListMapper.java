package com.yuzo.question.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.StuCrseList;

public interface StuCrseListMapper {
    int deleteByPrimaryKey(String sclId);

    int insert(StuCrseList record);

    int insertSelective(StuCrseList record);

    StuCrseList selectByPrimaryKey(String sclId);

    int updateByPrimaryKeySelective(StuCrseList record);

    int updateByPrimaryKey(StuCrseList record);

	List<StuCrseList> queryStuCrseListByType(@Param("sctId")String sctId, @Param("type")String type);

	List<StuCrseList> queryByCrseAndUser(@Param("crseId")String crseId, @Param("userId")String userId);
	
	List<Map<String, Object>> queryCountByCrseAndUser(@Param("crseId")String crseId, @Param("userId")String userId);

	Integer totalSctnYes(@Param("crseId")String crseId, @Param("userId")String userId, @Param("sctnId")String sctnId);

	
	Integer queryCountByCrseAndUser(@Param("crseId")String crseId, @Param("qstnId")String qstnId, @Param("mcId")String mcId);

	Integer queryYesCountByCrseAndUser(@Param("crseId")String crseId, @Param("qstnId")String qstnId, @Param("mcId")String mcId);

	Integer queryNoCountByCrseAndUser(@Param("crseId")String crseId, @Param("qstnId")String qstnId, @Param("mcId")String mcId);
}