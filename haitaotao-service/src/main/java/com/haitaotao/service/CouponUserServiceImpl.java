package com.haitaotao.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.CouponUser;
import com.haitaotao.mapper.CouponUserMapper;

/**
 * 优惠券用户使用表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class CouponUserServiceImpl implements ICouponUserService {

    @Autowired
    private CouponUserMapper couponUserMapper;

    @Override
    public PageInfo<CouponUser> pageList(Integer pageNum, Integer pageSize, Integer userId, Long couponId, Integer status) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> couponUserMapper.listByCondition(userId, couponId, status));
    }
}
