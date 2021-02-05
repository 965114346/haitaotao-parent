package com.haitaotao.mapper;

import com.haitaotao.entity.Coupon;

import java.util.List;

/**
 * 优惠券信息及规则表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface CouponMapper {

    /**
    * 根据id查询优惠券信息及规则表
    * @param id
    * @return
    */
    Coupon selectByPrimaryKey(Long id);

    /**
    * 条件查询优惠券信息及规则表列表
    * @param coupon
    * @return
    */
    List<Coupon> selectByCondition(Coupon coupon);

    /**
    * 插入优惠券信息及规则表
    * @param coupon
    * @return
    */
    boolean insertSelective(Coupon coupon);

    /**
    * 更新优惠券信息及规则表
    * @param coupon
    * @return
    */
    boolean updateByPrimaryKey(Coupon coupon);

    /**
    * 根据id删除优惠券信息及规则表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除优惠券信息及规则表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}