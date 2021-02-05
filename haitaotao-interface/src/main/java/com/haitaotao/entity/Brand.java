package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 品牌商表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Brand implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 品牌商名称
     */
    private String name;

    /**
     * 品牌商简介
     */
    private String desc;

    /**
     * 品牌商页的品牌商图片
     */
    private String picUrl;

    /**
     * 
     */
    private Integer sortOrder;

    /**
     * 品牌商的商品低价，仅用于页面展示
     */
    private BigDecimal floorPrice;

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