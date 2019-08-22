package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.Topic;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer topicId);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer topicId);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);
    
    List<Topic> queryBySub(String subjId);
}