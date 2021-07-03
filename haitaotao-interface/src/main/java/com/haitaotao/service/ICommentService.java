package com.haitaotao.service;

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
     * 分页查询评论
     *
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param userId   用户id
     * @param type     评论类型
     * @param valueId  如果type=0，则是商品评论；如果是type=1，则是专题评论。
     * @return
     */
    PageInfo<Comment> pageList(Integer pageNum, Integer pageSize, Long userId, Integer type, Long valueId);

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    boolean add(Comment comment);

    boolean updateById(Comment comment);

    /**
     * 单个删除评论
     *
     * @param id 评论id
     * @return
     */
    boolean removeById(Long id);
}
