package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.GrouponRules;
import com.haitaotao.mapper.GrouponRulesMapper;
import com.haitaotao.service.IGrouponRulesService;

/**
 * 团购规则表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class GrouponRulesServiceImpl implements IGrouponRulesService {

    @Autowired
    private GrouponRulesMapper mapper;

    @Override
    public GrouponRules selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<GrouponRules> selectByPage(GrouponRules grouponRules, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<GrouponRules> list = mapper.selectByCondition(grouponRules);
        return new PageInfo<>(list);
    }

    @Override
    public List<GrouponRules> selectByCondition(GrouponRules grouponRules){
        return mapper.selectByCondition(grouponRules);
    }

    @Override
    public boolean insert(GrouponRules grouponRules){
        return mapper.insertSelective(grouponRules);
    }

    @Override
    public boolean updateByPrimaryKey(GrouponRules grouponRules){
        return mapper.updateByPrimaryKey(grouponRules);
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
