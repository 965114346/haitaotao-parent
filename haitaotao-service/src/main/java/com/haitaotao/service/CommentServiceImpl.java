package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Comment;
import com.haitaotao.mapper.CommentMapper;
import com.haitaotao.service.ICommentService;

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
    private CommentMapper mapper;

    @Override
    public Comment selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Comment> selectByPage(Comment comment, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Comment> list = mapper.selectByCondition(comment);
        return new PageInfo<>(list);
    }

    @Override
    public List<Comment> selectByCondition(Comment comment){
        return mapper.selectByCondition(comment);
    }

    @Override
    public boolean insert(Comment comment){
        return mapper.insertSelective(comment);
    }

    @Override
    public boolean updateByPrimaryKey(Comment comment){
        return mapper.updateByPrimaryKey(comment);
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean batchDeleteByPrimaryKey(List<Long> ids) {
        return mapper.batchDeleteByPrimaryKey(ids);
    }

}
