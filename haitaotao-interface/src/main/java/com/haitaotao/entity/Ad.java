package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Ad implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 广告标题
     */
    private String name;

    /**
     * 所广告的商品页面或者活动页面链接地址
     */
    private String link;

    /**
     * 广告宣传图片
     */
    private String url;

    /**
     * 广告位置：1则是首页
     */
    private Integer position;

    /**
     * 活动内容
     */
    private String content;

    /**
     * 广告开始时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 广告结束时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 是否启动（0：禁用 1：启用）
     */
    private Integer enabled;

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