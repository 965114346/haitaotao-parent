package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.GoodsSpecification;
import com.haitaotao.mapper.GoodsSpecificationMapper;
import com.haitaotao.service.IGoodsSpecificationService;

/**
 * 商品规格表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class GoodsSpecificationServiceImpl implements IGoodsSpecificationService {

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Override
    public GoodsSpecification selectByPrimaryKey(Long id) {
        return goodsSpecificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<GoodsSpecification> selectByPage(GoodsSpecification goodsSpecification, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<GoodsSpecification> list = goodsSpecificationMapper.selectByCondition(goodsSpecification);
        return new PageInfo<>(list);
    }

    @Override
    public List<GoodsSpecification> selectByCondition(GoodsSpecification goodsSpecification){
        return goodsSpecificationMapper.selectByCondition(goodsSpecification);
    }

    @Override
    public boolean insert(GoodsSpecification goodsSpecification){
        return goodsSpecificationMapper.insertSelective(goodsSpecification);
    }

    @Override
    public boolean updateByPrimaryKey(GoodsSpecification goodsSpecification){
        return goodsSpecificationMapper.updateByPrimaryKey(goodsSpecification);
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return goodsSpecificationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean batchDeleteByPrimaryKey(List<Long> ids) {
        return goodsSpecificationMapper.batchDeleteByPrimaryKey(ids);
    }

    @Override
    public List<GoodsSpecification> listByGoodsId(Long goodsId) {
        return goodsSpecificationMapper.listByGoodsId(goodsId);
    }
}
