package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知管理员表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class NoticeAdmin implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 通知ID
     */
    private Long noticeId;

    /**
     * 通知标题
     */
    private String noticeTitle;

    /**
     * 接收通知的管理员ID
     */
    private Long adminId;

    /**
     * 阅读时间，如果是NULL则是未读状态
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date readTime;

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