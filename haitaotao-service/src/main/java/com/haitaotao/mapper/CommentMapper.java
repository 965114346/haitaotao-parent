package com.haitaotao.mapper;

import com.haitaotao.entity.Comment;

import java.util.List;

/**
 * 评论表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface CommentMapper {

    /**
    * 根据id查询评论表
    * @param id
    * @return
    */
    Comment selectByPrimaryKey(Long id);

    /**
    * 条件查询评论表列表
    * @param comment
    * @return
    */
    List<Comment> selectByCondition(Comment comment);

    /**
    * 插入评论表
    * @param comment
    * @return
    */
    boolean insertSelective(Comment comment);

    /**
    * 更新评论表
    * @param comment
    * @return
    */
    boolean updateByPrimaryKey(Comment comment);

    /**
    * 根据id删除评论表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除评论表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}