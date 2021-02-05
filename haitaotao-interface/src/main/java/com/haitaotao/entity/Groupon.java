package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 团购活动表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Groupon implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 关联的订单ID
     */
    private Long orderId;

    /**
     * 如果是开团用户，则groupon_id是0；如果是参团用户，则groupon_id是团购活动ID
     */
    private Long grouponId;

    /**
     * 团购规则ID，关联haitaotao_groupon_rules表ID字段
     */
    private Long rulesId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 团购分享图片地址
     */
    private String shareUrl;

    /**
     * 开团用户ID
     */
    private Long creatorUserId;

    /**
     * 开团时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date creatorUserTime;

    /**
     * 团购活动状态，开团未支付则0，开团中则1，开团失败则2
     */
    private Integer status;

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