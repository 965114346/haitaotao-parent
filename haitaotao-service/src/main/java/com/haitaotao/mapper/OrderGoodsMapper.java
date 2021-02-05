package com.haitaotao.mapper;

import com.haitaotao.entity.OrderGoods;

import java.util.List;

/**
 * 订单商品表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface OrderGoodsMapper {

    /**
    * 根据id查询订单商品表
    * @param id
    * @return
    */
    OrderGoods selectByPrimaryKey(Long id);

    /**
    * 条件查询订单商品表列表
    * @param orderGoods
    * @return
    */
    List<OrderGoods> selectByCondition(OrderGoods orderGoods);

    /**
    * 插入订单商品表
    * @param orderGoods
    * @return
    */
    boolean insertSelective(OrderGoods orderGoods);

    /**
    * 更新订单商品表
    * @param orderGoods
    * @return
    */
    boolean updateByPrimaryKey(OrderGoods orderGoods);

    /**
    * 根据id删除订单商品表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除订单商品表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}