package com.haitaotao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.haitaotao.entity.OrderGoods;
import com.haitaotao.entity.User;
import com.haitaotao.enums.OrderStatusEnum;
import com.haitaotao.mapper.OrderGoodsMapper;
import com.haitaotao.mapper.UserMapper;
import com.haitaotao.util.OrderUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Order;
import com.haitaotao.mapper.OrderMapper;

/**
 * 订单表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long count() {
        return orderMapper.count();
    }

    @Override
    public PageInfo<Order> pageList(Integer pageNum, Integer pageSize, String nickname, List<Integer> orderStatusList, String consignee, String orderNo, Date start, Date end) {
        List<Long> userIdList = null;
        if (StringUtils.isNotBlank(nickname)) {
            userIdList = userMapper.getUserIdLikeNickname(nickname);
            if (CollectionUtils.isEmpty(userIdList)) {
                return PageInfo.of(new ArrayList<>());
            }
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Order> list = orderMapper.listByCondition(userIdList, orderStatusList, consignee, orderNo, start, end);

        for (Order order : list) {
            // 订单用户信息
            User user = userMapper.getByUserId(order.getUserId());
            if (Objects.nonNull(user)) {
                order.setNickname(user.getNickname()).setAvatar(user.getAvatar());
            }

            // 订单商品信息
            List<OrderGoods> goodsList = orderGoodsMapper.listGoodsByOrderNo(order.getOrderNo());
            order.setOrderGoodsList(goodsList);
        }
        return PageInfo.of(list);
    }

    @Override
    public Order getByOrderNo(String orderNo) {
        return orderMapper.getByOrderNo(orderNo);
    }

    @Override
    public boolean grouponExpiredRefund(String orderNo) {
        Order order = orderMapper.getByOrderNo(orderNo);
        if (!OrderUtil.isPayStatus(order)) {
            return false;
        }
        return orderMapper.updateStatusByOrderNoAndVersion(OrderStatusEnum.STATUS_REFUND_GROUPON.getValue(), orderNo, order.getVersion());
    }
}
