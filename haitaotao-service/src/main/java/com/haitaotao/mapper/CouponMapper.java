package com.haitaotao.mapper;

import com.haitaotao.entity.Coupon;
import org.apache.ibatis.annotations.Param;

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
     *
     * @param id
     * @return
     */
    Coupon getById(Long id);

    /**
     * 条件查询优惠券信息及规则表列表
     *
     * @param name   优惠券名称
     * @param type   优惠券赠送类型，如果是0则通用券，用户领取；如果是1，则是注册赠券；如果是2，则是优惠券码兑换；
     * @param status 优惠券状态，如果是0则是正常可用；如果是1则是过期; 如果是2则是下架
     * @return
     */
    List<Coupon> listByCondition(@Param("name") String name,
                                 @Param("type") Integer type,
                                 @Param("status") Integer status);

    /**
     * 插入优惠券信息及规则表
     *
     * @param coupon
     * @return
     */
    boolean insert(Coupon coupon);

    /**
     * 更新优惠券信息及规则表
     *
     * @param coupon
     * @return
     */
    boolean updateById(Coupon coupon);

    /**
     * 根据id删除优惠券信息及规则表
     *
     * @param id
     * @return
     */
    boolean removeById(Long id);
}