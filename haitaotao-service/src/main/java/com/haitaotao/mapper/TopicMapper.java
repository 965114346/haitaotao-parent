package com.haitaotao.mapper;

import com.haitaotao.entity.Topic;

import java.util.List;

/**
 * 专题表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface TopicMapper {

    /**
    * 根据id查询专题表
    * @param id
    * @return
    */
    Topic selectByPrimaryKey(Long id);

    /**
    * 条件查询专题表列表
    * @param topic
    * @return
    */
    List<Topic> selectByCondition(Topic topic);

    /**
    * 插入专题表
    * @param topic
    * @return
    */
    boolean insertSelective(Topic topic);

    /**
    * 更新专题表
    * @param topic
    * @return
    */
    boolean updateByPrimaryKey(Topic topic);

    /**
    * 根据id删除专题表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除专题表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}