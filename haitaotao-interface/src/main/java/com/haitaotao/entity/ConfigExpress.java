package com.haitaotao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 运费配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
@Data
@Accessors(chain = true)
public class ConfigExpress implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 运费满减所需最低消费
     */
    private BigDecimal freightMin;

    /**
     * 运费满减不足所需运费
     */
    private BigDecimal freightValue;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;
}