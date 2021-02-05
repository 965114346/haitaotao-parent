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
    * 根据id查询优惠券用户使用表
    * @param id
    * @return
    */
    CouponUser selectByPrimaryKey(Long id);

    /**
    * 分页查询优惠券用户使用表
    * @param couponUser
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<CouponUser> selectByPage(CouponUser couponUser, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询优惠券用户使用表
    * @param couponUser
    * @return
    */
    List<CouponUser> selectByCondition(CouponUser couponUser);

    /**
    * 添加优惠券用户使用表
    * @param couponUser
    * @return
    */
    boolean insert(CouponUser couponUser);

    /**
    * 根据id更新优惠券用户使用表
    * @param couponUser
    * @return
    */
    boolean updateByPrimaryKey(CouponUser couponUser);

    /**
    * 单个删除优惠券用户使用表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除优惠券用户使用表(也可单个删除优惠券用户使用表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
