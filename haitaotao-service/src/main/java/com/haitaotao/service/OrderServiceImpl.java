package com.haitaotao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.haitaotao.mapper.UserMapper;
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
        return PageInfo.of(list);
    }
}
