package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Coupon;

/**
 * 优惠券信息及规则表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface ICouponService {

    /**
    * 根据id查询优惠券信息及规则表
    * @param id
    * @return
    */
    Coupon selectByPrimaryKey(Long id);

    /**
    * 分页查询优惠券信息及规则表
    * @param coupon
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Coupon> selectByPage(Coupon coupon, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询优惠券信息及规则表
    * @param coupon
    * @return
    */
    List<Coupon> selectByCondition(Coupon coupon);

    /**
    * 添加优惠券信息及规则表
    * @param coupon
    * @return
    */
    boolean insert(Coupon coupon);

    /**
    * 根据id更新优惠券信息及规则表
    * @param coupon
    * @return
    */
    boolean updateByPrimaryKey(Coupon coupon);

    /**
    * 单个删除优惠券信息及规则表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除优惠券信息及规则表(也可单个删除优惠券信息及规则表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
