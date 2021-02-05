package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Topic;
import com.haitaotao.mapper.TopicMapper;
import com.haitaotao.service.ITopicService;

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
    private TopicMapper mapper;

    @Override
    public Topic selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Topic> selectByPage(Topic topic, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Topic> list = mapper.selectByCondition(topic);
        return new PageInfo<>(list);
    }

    @Override
    public List<Topic> selectByCondition(Topic topic){
        return mapper.selectByCondition(topic);
    }

    @Override
    public boolean insert(Topic topic){
        return mapper.insertSelective(topic);
    }

    @Override
    public boolean updateByPrimaryKey(Topic topic){
        return mapper.updateByPrimaryKey(topic);
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
