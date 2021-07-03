package com.haitaotao.mapper;

import com.haitaotao.entity.Comment;
import org.apache.ibatis.annotations.Param;

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
    Comment getById(Long id);

    /**
     * 条件查询评论表列表
     * @param userId   用户id
     * @param type     评论类型
     * @param valueId  如果type=0，则是商品评论；如果是type=1，则是专题评论。
     * @return
     */
    List<Comment> listByCondition(@Param("userId") Long userId,
                                  @Param("type") Integer type,
                                  @Param("valueId") Long valueId);

    /**
    * 插入评论表
    * @param comment
    * @return
    */
    boolean insert(Comment comment);

    /**
    * 更新评论表
    * @param comment
    * @return
    */
    boolean updateById(Comment comment);

    /**
    * 根据id删除评论表
    * @param id
    * @return
    */
    boolean removeById(Long id);
}