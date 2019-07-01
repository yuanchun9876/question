package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.yuzo.question.entity.SubjSection;



public interface SubjSectionMapper {
    int deleteByPrimaryKey(String subjSctnId);

    int insert(SubjSection record);

    int insertSelective(SubjSection record);

    SubjSection selectByPrimaryKey(String subjSctnId);

    int updateByPrimaryKeySelective(SubjSection record);

    int updateByPrimaryKey(SubjSection record);

	List<SubjSection> queryByUnit(String subjUnitId);

	List<SubjSection> queryAllByTchId(String tchId);

	@Select("    select \r\n" + 
			"    SUBJ_SCTN_ID, SUBJ_UNIT_ID, SUBJ_SCTN_TITLE, SUBJ_SCTN_NUM, SUBJ_SCTN_CODE, SUBJ_SCTN_INFO, \r\n" + 
			"    SUBJ_SCTN_LOGO_URL, SUBJ_SCTN_VIDEO_URL, SUBJ_SCTN_PIC_TEXT, SUBJ_SCTN_VIDEO_LEN\r\n" + 
			"    from subj_section")
	@ResultMap("BaseResultMap")
	List<SubjSection> queryAll();
}