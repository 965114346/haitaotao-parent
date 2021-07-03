package com.haitaotao.mapper;

import com.haitaotao.entity.Issue;

import java.util.List;

/**
 * 常见问题表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface IssueMapper {

    /**
     * 根据id查询常见问题表
     *
     * @param id
     * @return
     */
    Issue selectById(Long id);

    /**
     * 条件查询常见问题表列表
     *
     * @param question
     * @return
     */
    List<Issue> listByCondition(String question);

    /**
     * 插入常见问题表
     *
     * @param issue
     * @return
     */
    boolean insert(Issue issue);

    /**
     * 更新常见问题表
     *
     * @param issue
     * @return
     */
    boolean updateById(Issue issue);

    /**
     * 根据id删除常见问题表
     *
     * @param id
     * @return
     */
    boolean removeById(Long id);
}