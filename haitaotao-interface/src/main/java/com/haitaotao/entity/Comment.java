package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Comment implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 如果type=0，则是商品评论；如果是type=1，则是专题评论。
     */
    private Long valueId;

    /**
     * 评论类型，如果type=0，则是商品评论；如果是type=1，则是专题评论；
     */
    private Integer type;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 管理员回复内容
     */
    private String adminContent;

    /**
     * 用户表的用户ID
     */
    private Long userId;

    /**
     * 是否含有图片
     */
    private Integer hasPicture;

    /**
     * 图片地址列表，采用JSON数组格式
     */
    private String picUrls;

    /**
     * 评分， 1-5
     */
    private Integer star;

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