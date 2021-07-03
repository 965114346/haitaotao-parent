package com.haitaotao.mapper;

import com.haitaotao.entity.Topic;
import org.apache.ibatis.annotations.Param;

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
     *
     * @param id
     * @return
     */
    Topic getById(Long id);

    /**
     * 条件查询专题表列表
     *
     * @param title    专题标题
     * @param subtitle 专题子标题
     * @return
     */
    List<Topic> listByCondition(@Param("title") String title, @Param("subtitle") String subtitle);

    /**
     * 插入专题表
     *
     * @param topic
     * @return
     */
    boolean insert(Topic topic);

    /**
     * 更新专题表
     *
     * @param topic
     * @return
     */
    boolean updateById(Topic topic);

    /**
     * 根据id删除专题表
     *
     * @param id
     * @return
     */
    boolean removeById(Long id);
}