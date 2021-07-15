package com.haitaotao.mapper;

import com.haitaotao.entity.OrderGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单商品表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
@Repository
public interface OrderGoodsMapper {

    /**
     * 订单商品列表
     * @param orderNo 订单编码
     * @return 订单的商品信息
     */
    List<OrderGoods> listGoodsByOrderNo(String orderNo);
}