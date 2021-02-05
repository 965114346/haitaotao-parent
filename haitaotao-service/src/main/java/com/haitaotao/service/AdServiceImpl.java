package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Ad;
import com.haitaotao.mapper.AdMapper;
import com.haitaotao.service.IAdService;

/**
 * 广告表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class AdServiceImpl implements IAdService {

    @Autowired
    private AdMapper mapper;

    @Override
    public Ad selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Ad> selectByPage(Ad ad, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Ad> list = mapper.selectByCondition(ad);
        return new PageInfo<>(list);
    }

    @Override
    public List<Ad> selectByCondition(Ad ad){
        return mapper.selectByCondition(ad);
    }

    @Override
    public boolean insert(Ad ad){
        return mapper.insertSelective(ad);
    }

    @Override
    public boolean updateByPrimaryKey(Ad ad){
        return mapper.updateByPrimaryKey(ad);
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
