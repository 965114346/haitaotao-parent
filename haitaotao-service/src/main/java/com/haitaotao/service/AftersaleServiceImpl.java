package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Aftersale;
import com.haitaotao.mapper.AftersaleMapper;
import com.haitaotao.service.IAftersaleService;

/**
 * 售后表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class AftersaleServiceImpl implements IAftersaleService {

    @Autowired
    private AftersaleMapper mapper;

    @Override
    public Aftersale selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Aftersale> selectByPage(Aftersale aftersale, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Aftersale> list = mapper.selectByCondition(aftersale);
        return new PageInfo<>(list);
    }

    @Override
    public List<Aftersale> selectByCondition(Aftersale aftersale){
        return mapper.selectByCondition(aftersale);
    }

    @Override
    public boolean insert(Aftersale aftersale){
        return mapper.insertSelective(aftersale);
    }

    @Override
    public boolean updateByPrimaryKey(Aftersale aftersale){
        return mapper.updateByPrimaryKey(aftersale);
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
