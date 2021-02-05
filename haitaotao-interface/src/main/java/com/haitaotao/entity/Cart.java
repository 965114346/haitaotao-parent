package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车商品表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Cart implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 用户表的用户ID
     */
    private Long userId;

    /**
     * 商品表的商品ID
     */
    private Long goodsId;

    /**
     * 商品编号
     */
    private String goodsSn;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品货品表的货品ID
     */
    private Long productId;

    /**
     * 商品货品的价格
     */
    private BigDecimal price;

    /**
     * 商品货品的数量
     */
    private Long number;

    /**
     * 商品规格值列表，采用JSON数组格式
     */
    private String specifications;

    /**
     * 购物车中商品是否选择状态
     */
    private Integer checked;

    /**
     * 商品图片或者商品货品图片
     */
    private String picUrl;

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