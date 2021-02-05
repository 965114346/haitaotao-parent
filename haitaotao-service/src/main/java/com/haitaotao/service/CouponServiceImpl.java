package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Coupon;
import com.haitaotao.mapper.CouponMapper;
import com.haitaotao.service.ICouponService;

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
    private CouponMapper mapper;

    @Override
    public Coupon selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Coupon> selectByPage(Coupon coupon, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Coupon> list = mapper.selectByCondition(coupon);
        return new PageInfo<>(list);
    }

    @Override
    public List<Coupon> selectByCondition(Coupon coupon){
        return mapper.selectByCondition(coupon);
    }

    @Override
    public boolean insert(Coupon coupon){
        return mapper.insertSelective(coupon);
    }

    @Override
    public boolean updateByPrimaryKey(Coupon coupon){
        return mapper.updateByPrimaryKey(coupon);
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean batchDeleteByPrimaryKey(List<Long> ids) {
        return mapper.batchDeleteByPrimaryKey(ids);
    }

}
