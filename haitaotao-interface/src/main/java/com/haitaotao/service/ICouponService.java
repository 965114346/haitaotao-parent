package com.haitaotao.service;

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
     * 分页查询优惠券信息及规则表
     *
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param name     优惠券名称
     * @param type     优惠券赠送类型，如果是0则通用券，用户领取；如果是1，则是注册赠券；如果是2，则是优惠券码兑换；
     * @param status   优惠券状态，如果是0则是正常可用；如果是1则是过期; 如果是2则是下架
     * @return
     */
    PageInfo<Coupon> pageList(Integer pageNum, Integer pageSize, String name, Integer type, Integer status);

    /**
     * 新增一条优惠券
     * @param coupon
     * @return
     */
    boolean add(Coupon coupon);

    /**
     * 更新优惠券信息
     * @param coupon
     * @return
     */
    boolean updateById(Coupon coupon);

    /**
     * 删除优惠券
     * @param id 优惠券id
     * @return
     */
    boolean removeById(Long id);

    /**
     * 根据id获取优惠券信息
     * @param id 优惠券id
     * @return
     */
    Coupon getById(Long id);
}
