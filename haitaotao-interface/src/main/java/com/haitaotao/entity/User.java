package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 性别：0 未知， 1男， 2 女
     */
    private Integer gender;

    /**
     * 生日
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    /**
     * 最近一次登录时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /**
     * 最近一次登录IP地址
     */
    private String lastLoginIp;

    /**
     * 0 普通用户，1 VIP用户，2 高级VIP用户
     */
    private Integer userLevel;

    /**
     * 用户昵称或网络名称
     */
    private String nickname;

    /**
     * 用户手机号码
     */
    private String mobile;

    /**
     * 用户头像图片
     */
    private String avatar;

    /**
     * 微信登录openid
     */
    private String weixinOpenid;

    /**
     * 微信登录会话KEY
     */
    private String sessionKey;

    /**
     * 0 可用, 1 禁用, 2 注销
     */
    private Integer status;

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