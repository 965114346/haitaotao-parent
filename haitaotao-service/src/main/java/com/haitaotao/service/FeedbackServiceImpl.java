package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Feedback;
import com.haitaotao.mapper.FeedbackMapper;
import com.haitaotao.service.IFeedbackService;

/**
 * 意见反馈表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class FeedbackServiceImpl implements IFeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public PageInfo<Feedback> pageList(Integer pageNum, Integer pageSize, String username, Long id) {
        PageHelper.startPage(pageNum, pageSize);
        List<Feedback> list = feedbackMapper.listByCondition(username, id);
        return PageInfo.of(list);
    }

}
