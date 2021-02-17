package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Order;
import com.haitaotao.service.IOrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author yangyang
 * @date 2021/2/5 10:46
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @DubboReference
    private IOrderService orderService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @RequestParam(value = "orderStatusList", required = false) List<Integer> orderStatusList,
                       String nickname,
                       String consignee,
                       String orderNo,
                       Date start,
                       Date end) {
        PageInfo<Order> pageInfo = orderService.pageList(pageNum, pageSize, nickname, orderStatusList, consignee, orderNo, start, end);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/{orderNo}")
    public Object detail(@PathVariable String orderNo) {
        Order order = orderService.getByOrderNo(orderNo);
        return ResponseUtil.ok(order);
    }
}
