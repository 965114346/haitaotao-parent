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
    * @param id
    * @return
    */
    Issue selectByPrimaryKey(Long id);

    /**
    * 条件查询常见问题表列表
    * @param issue
    * @return
    */
    List<Issue> selectByCondition(Issue issue);

    /**
    * 插入常见问题表
    * @param issue
    * @return
    */
    boolean insertSelective(Issue issue);

    /**
    * 更新常见问题表
    * @param issue
    * @return
    */
    boolean updateByPrimaryKey(Issue issue);

    /**
    * 根据id删除常见问题表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除常见问题表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}