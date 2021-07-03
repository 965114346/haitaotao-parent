package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.CouponUser;

/**
 * 优惠券用户使用表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface ICouponUserService {

    /**
     * 分页查询优惠券用户使用表
     * @param pageNum
     * @param pageSize
     * @param userId
     * @param couponId
     * @param status
     * @return
     */
    PageInfo<CouponUser> pageList(Integer pageNum, Integer pageSize, Integer userId, Long couponId, Integer status);
}
