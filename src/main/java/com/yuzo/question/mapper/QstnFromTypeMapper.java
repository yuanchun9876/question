package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.yuzo.question.entity.QstnFromType;



public interface QstnFromTypeMapper {
    int deleteByPrimaryKey(String qstnFromTypeId);

    int insert(QstnFromType record);

    int insertSelective(QstnFromType record);

    QstnFromType selectByPrimaryKey(String qstnFromTypeId);

    int updateByPrimaryKeySelective(QstnFromType record);

    int updateByPrimaryKey(QstnFromType record);

    @Select("select qstn_from_type_id, qstn_from_type_code, qstn_from_type_info from qstn_from_type")
	@ResultMap("BaseResultMap")
    List<QstnFromType> queryAll();
}