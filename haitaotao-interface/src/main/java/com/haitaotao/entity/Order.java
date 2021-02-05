package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Order implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 用户表的用户ID
     */
    private Long userId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 售后状态，0是可申请，1是用户已申请，2是管理员审核通过，3是管理员退款成功，4是管理员审核拒绝，5是用户已取消
     */
    private Integer afterSaleStatus;

    /**
     * 收货人名称
     */
    private String consignee;

    /**
     * 收货人手机号
     */
    private String mobile;

    /**
     * 收货具体地址
     */
    private String address;

    /**
     * 用户订单留言
     */
    private String message;

    /**
     * 商品总费用
     */
    private BigDecimal goodsPrice;

    /**
     * 配送费用
     */
    private BigDecimal freightPrice;

    /**
     * 优惠券减免
     */
    private BigDecimal couponPrice;

    /**
     * 用户积分减免
     */
    private BigDecimal integralPrice;

    /**
     * 团购优惠价减免
     */
    private BigDecimal grouponPrice;

    /**
     * 订单费用， = goods_price + freight_price - coupon_price
     */
    private BigDecimal orderPrice;

    /**
     * 实付费用， = order_price - integral_price
     */
    private BigDecimal actualPrice;

    /**
     * 微信付款编号
     */
    private String payId;

    /**
     * 微信付款时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;

    /**
     * 发货编号
     */
    private String shipNo;

    /**
     * 发货快递公司
     */
    private String shipChannel;

    /**
     * 发货开始时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date shipTime;

    /**
     * 实际退款金额，（有可能退款金额小于实际支付金额）
     */
    private BigDecimal refundAmount;

    /**
     * 退款方式
     */
    private String refundType;

    /**
     * 退款备注
     */
    private String refundContent;

    /**
     * 退款时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date refundTime;

    /**
     * 用户确认收货时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date confirmTime;

    /**
     * 待评价订单商品数量
     */
    private Integer comments;

    /**
     * 订单关闭时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

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

    //-------------额外字段---------------

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;
}