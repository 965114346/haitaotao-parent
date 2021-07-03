package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.GoodsAttribute;
import com.haitaotao.mapper.GoodsAttributeMapper;
import com.haitaotao.service.IGoodsAttributeService;

/**
 * 商品参数表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class GoodsAttributeServiceImpl implements IGoodsAttributeService {

    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;

    @Override
    public GoodsAttribute selectByPrimaryKey(Long id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<GoodsAttribute> selectByPage(GoodsAttribute goodsAttribute, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<GoodsAttribute> list = goodsAttributeMapper.selectByCondition(goodsAttribute);
        return new PageInfo<>(list);
    }

    @Override
    public List<GoodsAttribute> selectByCondition(GoodsAttribute goodsAttribute){
        return goodsAttributeMapper.selectByCondition(goodsAttribute);
    }

    @Override
    public boolean insert(GoodsAttribute goodsAttribute){
        return goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    @Override
    public boolean updateByPrimaryKey(GoodsAttribute goodsAttribute){
        return goodsAttributeMapper.updateByPrimaryKey(goodsAttribute);
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return goodsAttributeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean batchDeleteByPrimaryKey(List<Long> ids) {
        return goodsAttributeMapper.batchDeleteByPrimaryKey(ids);
    }

    @Override
    public List<GoodsAttribute> listByGoodsId(Long goodsId) {
        return goodsAttributeMapper.listByGoodsId(goodsId);
    }
}
