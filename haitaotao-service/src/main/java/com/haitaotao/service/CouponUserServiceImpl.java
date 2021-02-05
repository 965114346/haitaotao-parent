package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.CouponUser;
import com.haitaotao.mapper.CouponUserMapper;
import com.haitaotao.service.ICouponUserService;

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
    private CouponUserMapper mapper;

    @Override
    public CouponUser selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<CouponUser> selectByPage(CouponUser couponUser, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<CouponUser> list = mapper.selectByCondition(couponUser);
        return new PageInfo<>(list);
    }

    @Override
    public List<CouponUser> selectByCondition(CouponUser couponUser){
        return mapper.selectByCondition(couponUser);
    }

    @Override
    public boolean insert(CouponUser couponUser){
        return mapper.insertSelective(couponUser);
    }

    @Override
    public boolean updateByPrimaryKey(CouponUser couponUser){
        return mapper.updateByPrimaryKey(couponUser);
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
