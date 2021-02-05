package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Comment;

/**
 * 评论表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface ICommentService {

    /**
    * 根据id查询评论表
    * @param id
    * @return
    */
    Comment selectByPrimaryKey(Long id);

    /**
    * 分页查询评论表
    * @param comment
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Comment> selectByPage(Comment comment, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询评论表
    * @param comment
    * @return
    */
    List<Comment> selectByCondition(Comment comment);

    /**
    * 添加评论表
    * @param comment
    * @return
    */
    boolean insert(Comment comment);

    /**
    * 根据id更新评论表
    * @param comment
    * @return
    */
    boolean updateByPrimaryKey(Comment comment);

    /**
    * 单个删除评论表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除评论表(也可单个删除评论表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
