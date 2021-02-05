package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 类目表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Category implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类目关键字，以JSON数组格式
     */
    private String keywords;

    /**
     * 类目广告语介绍
     */
    private String desc;

    /**
     * 父类目ID
     */
    private Long parentId;

    /**
     * 类目图标
     */
    private String iconUrl;

    /**
     * 类目图片
     */
    private String picUrl;

    /**
     * 
     */
    private String level;

    /**
     * 排序
     */
    private Integer sortOrder;

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

    //-----------------------------拓展属性

    private boolean hasChildren;
}