package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.OrderGoods;
import com.haitaotao.mapper.OrderGoodsMapper;
import com.haitaotao.service.IOrderGoodsService;

/**
 * 订单商品表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class OrderGoodsServiceImpl implements IOrderGoodsService {

    @Autowired
    private OrderGoodsMapper mapper;

    @Override
    public OrderGoods selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<OrderGoods> selectByPage(OrderGoods orderGoods, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<OrderGoods> list = mapper.selectByCondition(orderGoods);
        return new PageInfo<>(list);
    }

    @Override
    public List<OrderGoods> selectByCondition(OrderGoods orderGoods){
        return mapper.selectByCondition(orderGoods);
    }

    @Override
    public boolean insert(OrderGoods orderGoods){
        return mapper.insertSelective(orderGoods);
    }

    @Override
    public boolean updateByPrimaryKey(OrderGoods orderGoods){
        return mapper.updateByPrimaryKey(orderGoods);
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
