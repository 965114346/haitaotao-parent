package com.haitaotao.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Topic;
import com.haitaotao.mapper.TopicMapper;

/**
 * 专题表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public PageInfo<Topic> pageList(Integer pageNum, Integer pageSize, String title, String subtitle) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> topicMapper.listByCondition(title, subtitle));
    }

    @Override
    public Topic getById(Long id) {
        return topicMapper.getById(id);
    }

    @Override
    public boolean add(Topic topic) {
        return topicMapper.insert(topic);
    }

    @Override
    public boolean updateById(Topic topic) {
        return topicMapper.updateById(topic);
    }

    @Override
    public boolean removeById(Long id) {
        return topicMapper.removeById(id);
    }
}
