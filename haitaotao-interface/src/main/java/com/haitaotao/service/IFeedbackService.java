package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Feedback;

/**
 * 意见反馈表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IFeedbackService {

    /**
     * 分页查询用户意见反馈列表
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @param username 用户名
     * @param id 反馈id
     * @return 用户意见反馈列表
     */
    PageInfo<Feedback> pageList(Integer pageNum, Integer pageSize, String username, Long id);
}
