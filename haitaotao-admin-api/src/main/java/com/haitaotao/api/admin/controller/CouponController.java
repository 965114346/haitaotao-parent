package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.CouponCreateDTO;
import com.haitaotao.api.admin.dto.CouponUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Coupon;
import com.haitaotao.entity.CouponUser;
import com.haitaotao.service.ICouponService;
import com.haitaotao.service.ICouponUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author yangyang
 * @date 2021/4/27 15:18
 */
@Slf4j
@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @DubboReference
    private ICouponService couponService;

    @DubboReference
    private ICouponUserService couponUserService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Integer type,
                       Integer status) {
        PageInfo<Coupon> pageInfo = couponService.pageList(pageNum, pageSize, name, type, status);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/user/list")
    public Object userList(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           Integer userId,
                           Long couponId,
                           Integer status) {
        PageInfo<CouponUser> pageInfo = couponUserService.pageList(pageNum, pageSize, userId, couponId, status);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/detail")
    public Object detail(@RequestParam Long id) {
        Coupon coupon = couponService.getById(id);
        return ResponseUtil.ok(coupon);
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody CouponCreateDTO dto) {
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(dto, coupon);
        boolean success = couponService.add(coupon);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody CouponUpdateDTO dto) {
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(dto, coupon);

        boolean success = couponService.updateById(coupon);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = couponService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
