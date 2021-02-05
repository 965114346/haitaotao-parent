package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.GoodsProduct;
import com.haitaotao.mapper.GoodsProductMapper;
import com.haitaotao.service.IGoodsProductService;

/**
 * 商品货品表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class GoodsProductServiceImpl implements IGoodsProductService {

    @Autowired
    private GoodsProductMapper goodsProductMapper;

    @Override
    public Long count() {
        return goodsProductMapper.count();
    }
}
