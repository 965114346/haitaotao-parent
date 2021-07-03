package com.haitaotao.service;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Issue;

/**
 * 常见问题表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IIssueService {

    /**
     * 根据id查询常见问题表
     *
     * @param id
     * @return
     */
    Issue selectById(Long id);

    /**
     * 分页查询常见问题表
     *
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param question 问题内容
     * @return
     */
    PageInfo<Issue> pageList(Integer pageNum, Integer pageSize, String question);

    /**
     * 添加常见问题表
     *
     * @param issue
     * @return
     */
    boolean add(Issue issue);

    /**
     * 根据id更新常见问题表
     *
     * @param issue
     * @return
     */
    boolean updateById(Issue issue);

    /**
     * 单个删除常见问题表
     *
     * @param id
     * @return
     */
    boolean removeById(Long id);
}
