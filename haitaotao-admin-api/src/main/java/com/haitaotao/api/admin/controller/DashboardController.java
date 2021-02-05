package com.haitaotao.api.admin.controller;

import com.haitaotao.api.admin.vo.DashboardVO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.service.IGoodsProductService;
import com.haitaotao.service.IGoodsService;
import com.haitaotao.service.IOrderService;
import com.haitaotao.service.IUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyang
 * @date 2021/1/21 9:46
 */
@RestController
@RequestMapping("/api")
public class DashboardController {

    @DubboReference
    private IUserService userService;

    @DubboReference
    private IGoodsService goodsService;

    @DubboReference
    private IGoodsProductService goodsProductService;

    @DubboReference
    private IOrderService orderService;

    @GetMapping("/dashboard")
    public Object dashboard() {
        Long userCount = userService.count();
        Long goodsCount = goodsService.count();
        Long goodsProductCount = goodsProductService.count();
        Long orderCount = orderService.count();

        return ResponseUtil.ok(new DashboardVO()
                .setUserTotal(userCount)
                .setGoodsTotal(goodsCount)
                .setProductTotal(goodsProductCount)
                .setOrderTotal(orderCount));
    }
}
