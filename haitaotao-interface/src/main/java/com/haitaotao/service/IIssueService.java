package com.haitaotao.service;

import java.util.List;

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
    * @param id
    * @return
    */
    Issue selectByPrimaryKey(Long id);

    /**
    * 分页查询常见问题表
    * @param issue
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Issue> selectByPage(Issue issue, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询常见问题表
    * @param issue
    * @return
    */
    List<Issue> selectByCondition(Issue issue);

    /**
    * 添加常见问题表
    * @param issue
    * @return
    */
    boolean insert(Issue issue);

    /**
    * 根据id更新常见问题表
    * @param issue
    * @return
    */
    boolean updateByPrimaryKey(Issue issue);

    /**
    * 单个删除常见问题表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除常见问题表(也可单个删除常见问题表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
