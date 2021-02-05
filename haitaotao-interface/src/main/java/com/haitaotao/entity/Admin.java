package com.haitaotao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Admin implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 管理员名称
     */
    private String username;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 最近一次登录IP地址
     */
    private String lastLoginIp;

    /**
     * 最近一次登录时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /**
     * 头像图片
     */
    private String avatar;

    /**
     * 角色列表
     */
    private String roleIds;

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

    //-----------------------------拓展

    /**
     * 签发的凭证
     */
    private String token;
}