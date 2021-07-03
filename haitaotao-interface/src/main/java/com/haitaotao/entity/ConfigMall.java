package com.haitaotao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 商场配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
@Data
@Accessors(chain = true)
public class ConfigMall implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 商场名称
     */
    private String name;

    /**
     * 商场地址
     */
    private String address;

    /**
     * 精度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * QQ
     */
    private String qq;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;
}