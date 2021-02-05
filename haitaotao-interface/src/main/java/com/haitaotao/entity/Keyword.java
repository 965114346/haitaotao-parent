package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 关键字表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Keyword implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 关键字的跳转链接
     */
    private String url;

    /**
     * 是否是热门关键字
     */
    private Integer isHot;

    /**
     * 是否是默认关键字
     */
    private Integer isDefault;

    /**
     * 排序
     */
    private Long sortOrder;

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