package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 意见反馈表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Feedback implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 用户表的用户ID
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 反馈类型
     */
    private String feedType;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 状态
     */
    private Long status;

    /**
     * 是否含有图片
     */
    private Integer hasPicture;

    /**
     * 图片地址列表，采用JSON数组格式
     */
    private String picUrls;

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