package com.haitaotao.service;

import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Coupon;
import com.haitaotao.mapper.CouponMapper;

/**
 * 优惠券信息及规则表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class CouponServiceImpl implements ICouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public PageInfo<Coupon> pageList(Integer pageNum, Integer pageSize, String name, Integer type, Integer status) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> couponMapper.listByCondition(name, type, status));
    }

    @Override
    public Coupon getById(Long id) {
        return couponMapper.getById(id);
    }

    @Override
    public boolean add(Coupon coupon) {
        return couponMapper.insert(coupon);
    }

    @Override
    public boolean updateById(Coupon coupon) {
        return couponMapper.updateById(coupon);
    }

    @Override
    public boolean removeById(Long id) {
        return couponMapper.removeById(id);
    }
}
