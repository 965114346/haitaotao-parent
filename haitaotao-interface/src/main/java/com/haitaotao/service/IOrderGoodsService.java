package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.OrderGoods;

/**
 * 订单商品表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IOrderGoodsService {

    /**
    * 根据id查询订单商品表
    * @param id
    * @return
    */
    OrderGoods selectByPrimaryKey(Long id);

    /**
    * 分页查询订单商品表
    * @param orderGoods
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<OrderGoods> selectByPage(OrderGoods orderGoods, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询订单商品表
    * @param orderGoods
    * @return
    */
    List<OrderGoods> selectByCondition(OrderGoods orderGoods);

    /**
    * 添加订单商品表
    * @param orderGoods
    * @return
    */
    boolean insert(OrderGoods orderGoods);

    /**
    * 根据id更新订单商品表
    * @param orderGoods
    * @return
    */
    boolean updateByPrimaryKey(OrderGoods orderGoods);

    /**
    * 单个删除订单商品表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除订单商品表(也可单个删除订单商品表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
