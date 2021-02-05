package com.haitaotao.mapper;

import com.haitaotao.entity.CouponUser;

import java.util.List;

/**
 * 优惠券用户使用表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface CouponUserMapper {

    /**
    * 根据id查询优惠券用户使用表
    * @param id
    * @return
    */
    CouponUser selectByPrimaryKey(Long id);

    /**
    * 条件查询优惠券用户使用表列表
    * @param couponUser
    * @return
    */
    List<CouponUser> selectByCondition(CouponUser couponUser);

    /**
    * 插入优惠券用户使用表
    * @param couponUser
    * @return
    */
    boolean insertSelective(CouponUser couponUser);

    /**
    * 更新优惠券用户使用表
    * @param couponUser
    * @return
    */
    boolean updateByPrimaryKey(CouponUser couponUser);

    /**
    * 根据id删除优惠券用户使用表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除优惠券用户使用表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}