package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Goods;
import com.haitaotao.mapper.GoodsMapper;
import com.haitaotao.service.IGoodsService;

/**
 * 商品基本信息表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Long count() {
        return goodsMapper.count();
    }

    @Override
    public PageInfo<Goods> pageList(Integer pageNum, Integer pageSize, Long id, String goodsNo, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list = goodsMapper.listByCondition(id, goodsNo, name);
        return PageInfo.of(list);
    }

    @Override
    public boolean add(Goods goods) {
        return false;
    }

    @Override
    public boolean updateById(Goods goods) {
        return false;
    }

    @Override
    public boolean removeById(Long id) {
        return false;
    }

    @Override
    public Goods getById(Long id) {
        return goodsMapper.getById(id);
    }
}
