package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠券用户使用表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class CouponUser implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 优惠券ID
     */
    private Long couponId;

    /**
     * 使用状态, 如果是0则未使用；如果是1则已使用；如果是2则已过期；如果是3则已经下架；
     */
    private Integer status;

    /**
     * 使用时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date usedTime;

    /**
     * 有效期开始时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 有效期截至时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 逻辑删除（0：未删除 1：删除）
     */
    private Integer deleted;
}