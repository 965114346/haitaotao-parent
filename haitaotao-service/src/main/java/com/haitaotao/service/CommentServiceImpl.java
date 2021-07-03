package com.haitaotao.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Comment;
import com.haitaotao.mapper.CommentMapper;

/**
 * 评论表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public PageInfo<Comment> pageList(Integer pageNum, Integer pageSize, Long userId, Integer type, Long valueId) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
            commentMapper.listByCondition(userId, type, valueId);
        });
    }

    @Override
    public boolean add(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public boolean updateById(Comment comment) {
        return commentMapper.updateById(comment);
    }

    @Override
    public boolean removeById(Long id) {
        return commentMapper.removeById(id);
    }
}
