package com.haitaotao.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Order;

/**
 * 订单表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IOrderService {

    /**
     * 数量统计
     * @return 订单数
     */
    Long count();

    /**
     * 订单列表分页
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @param nickname 用户昵称
     * @param orderStatusList 订单状态列表
     * @param consignee 收货人
     * @param orderNo 订单编号
     * @param start 开始时间
     * @param end 结束时间
     * @return 订单列表
     */
    PageInfo<Order> pageList(Integer pageNum, Integer pageSize, String nickname, List<Integer> orderStatusList, String consignee, String orderNo, Date start, Date end);

    /**
     * 获取订单详情
     * @param orderNo 订单编号
     * @return 订单信息
     */
    Order getByOrderNo(String orderNo);
}
