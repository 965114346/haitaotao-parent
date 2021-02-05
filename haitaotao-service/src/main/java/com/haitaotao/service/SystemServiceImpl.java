package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.System;
import com.haitaotao.mapper.SystemMapper;
import com.haitaotao.service.ISystemService;

/**
 * 系统配置表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class SystemServiceImpl implements ISystemService {

    @Autowired
    private SystemMapper mapper;

    @Override
    public System selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<System> selectByPage(System system, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<System> list = mapper.selectByCondition(system);
        return new PageInfo<>(list);
    }

    @Override
    public List<System> selectByCondition(System system){
        return mapper.selectByCondition(system);
    }

    @Override
    public boolean insert(System system){
        return mapper.insertSelective(system);
    }

    @Override
    public boolean updateByPrimaryKey(System system){
        return mapper.updateByPrimaryKey(system);
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
