package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品货品表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class GoodsProduct implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 商品表的商品ID
     */
    private Long goodsId;

    /**
     * 商品规格值列表，采用JSON数组格式
     */
    private String specifications;

    /**
     * 商品货品价格
     */
    private BigDecimal price;

    /**
     * 商品货品数量
     */
    private Long number;

    /**
     * 商品货品图片
     */
    private String url;

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