package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Topic;

/**
 * 专题表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface ITopicService {

    /**
    * 根据id查询专题表
    * @param id
    * @return
    */
    Topic selectByPrimaryKey(Long id);

    /**
    * 分页查询专题表
    * @param topic
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Topic> selectByPage(Topic topic, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询专题表
    * @param topic
    * @return
    */
    List<Topic> selectByCondition(Topic topic);

    /**
    * 添加专题表
    * @param topic
    * @return
    */
    boolean insert(Topic topic);

    /**
    * 根据id更新专题表
    * @param topic
    * @return
    */
    boolean updateByPrimaryKey(Topic topic);

    /**
    * 单个删除专题表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除专题表(也可单个删除专题表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
