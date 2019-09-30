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

	List<StuCrseList> queryByCrseAndMcAndQstn(@Param("crseId")String crseId, @Param("mcId")String mcId,  @Param("qstnId")String qstnId);

	List<StuCrseList> queryByCrseAndMc(@Param("crseId")String crseId, @Param("mcId")String mcId);
	

	List<String> queryUnitIdsByCrseAndMc(@Param("crseId")String crseId, @Param("mcId")String mcId);
	
	Integer totalUnitCount(@Param("crseId")String crseId, @Param("mcId")String mcId, @Param("unitId")String unitId);

	Integer totalUnitYes(@Param("crseId")String crseId, @Param("mcId")String mcId,  @Param("unitId")String unitId);

	Integer totalUnitNo(@Param("crseId")String crseId, @Param("mcId")String mcId,  @Param("unitId")String unitId);
	

	List<String> querySctnIdsByCrseAndMc(@Param("crseId")String crseId, @Param("mcId")String mcId);

	Integer totalSctnCount(@Param("crseId")String crseId, @Param("mcId")String mcId, @Param("sctnId")String sctnId);

	Integer totalSctnYesByMc(@Param("crseId")String crseId, @Param("mcId")String mcId, @Param("sctnId")String sctnId);

	Integer totalSctnNo(@Param("crseId")String crseId, @Param("mcId")String mcId, @Param("sctnId")String sctnId);
}