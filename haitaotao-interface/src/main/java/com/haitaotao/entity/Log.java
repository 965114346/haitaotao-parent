package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Log implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 管理员
     */
    private String admin;

    /**
     * 管理员地址
     */
    private String ip;

    /**
     * 操作分类
     */
    private Long type;

    /**
     * 操作动作
     */
    private String action;

    /**
     * 操作状态
     */
    private Integer status;

    /**
     * 操作结果，或者成功消息，或者失败消息
     */
    private String result;

    /**
     * 补充信息
     */
    private String comment;

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