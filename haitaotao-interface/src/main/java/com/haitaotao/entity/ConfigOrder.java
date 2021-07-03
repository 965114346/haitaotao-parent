package com.haitaotao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
@Data
@Accessors(chain = true)
public class ConfigOrder implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户未付款，则订单自动取消(分钟)
     */
    private Integer autoCancel;

    /**
     * 未确认收货，则订单自动确认收货(天)
     */
    private Integer autoConfirm;

    /**
     * 未评价商品，则取消评价资格(天)
     */
    private Integer expireComment;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;
}