package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Groupon;
import com.haitaotao.mapper.GrouponMapper;
import com.haitaotao.service.IGrouponService;

/**
 * 团购活动表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class GrouponServiceImpl implements IGrouponService {

    @Autowired
    private GrouponMapper mapper;

    @Override
    public Groupon selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Groupon> selectByPage(Groupon groupon, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Groupon> list = mapper.selectByCondition(groupon);
        return new PageInfo<>(list);
    }

    @Override
    public List<Groupon> selectByCondition(Groupon groupon){
        return mapper.selectByCondition(groupon);
    }

    @Override
    public boolean insert(Groupon groupon){
        return mapper.insertSelective(groupon);
    }

    @Override
    public boolean updateByPrimaryKey(Groupon groupon){
        return mapper.updateByPrimaryKey(groupon);
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
