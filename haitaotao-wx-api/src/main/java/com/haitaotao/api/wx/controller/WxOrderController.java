package com.haitaotao.api.wx.controller;

import com.haitaotao.service.IOrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyang
 * @date 2021/1/6 16:19
 */
@RestController
@RequestMapping("/order")
public class WxOrderController {

    @DubboReference
    private IOrderService orderService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        return orderService.selectByPage(null, pageNum, pageSize);
    }
}
