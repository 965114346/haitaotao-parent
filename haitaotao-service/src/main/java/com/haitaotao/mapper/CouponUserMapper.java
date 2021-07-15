package com.haitaotao.mapper;

import com.haitaotao.entity.CouponUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 优惠券用户使用表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
@Repository
public interface CouponUserMapper {

    /**
    * 根据id查询优惠券用户使用表
    * @param id
    * @return
    */
    CouponUser getById(Long id);

    /**
     * 条件查询优惠券用户使用表列表
     * @param userId 用户id
     * @param couponId 优惠券id
     * @param status 状态
     * @return
     */
    List<CouponUser> listByCondition(@Param("userId") Integer userId,
                                     @Param("couponId") Long couponId,
                                     @Param("status") Integer status);

    /**
    * 插入优惠券用户使用表
    * @param couponUser
    * @return
    */
    boolean insert(CouponUser couponUser);

    /**
    * 更新优惠券用户使用表
    * @param couponUser
    * @return
    */
    boolean updateById(CouponUser couponUser);

    /**
    * 根据id删除优惠券用户使用表
    * @param id
    * @return
    */
    boolean removeById(Long id);
}