package com.haitaotao.service;

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
     * 分页查询专题
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param title 专题标题
     * @param subtitle 专题子标题
     * @return
     */
    PageInfo<Topic> pageList(Integer pageNum, Integer pageSize, String title, String subtitle);

    /**
     * 根据id获取专题信息
     * @param id 专题id
     * @return
     */
    Topic getById(Long id);

    /**
     * 新增专题
     * @param topic
     * @return
     */
    boolean add(Topic topic);

    /**
     * 更新专题
     * @param topic
     * @return
     */
    boolean updateById(Topic topic);

    /**
     * 删除专题
     * @param id 专题id
     * @return
     */
    boolean removeById(Long id);
}
