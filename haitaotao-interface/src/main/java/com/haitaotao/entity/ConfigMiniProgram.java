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
public class ConfigMiniProgram implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 新品首发栏目商品显示数量
     */
    private Integer countGoodsNew;

    /**
     * 人气推荐栏目商品显示数量
     */
    private Integer countGoodsHot;

    /**
     * 品牌制造商直供栏目品牌商显示数量
     */
    private Integer countBrand;

    /**
     * 专题精选栏目显示数量
     */
    private Integer countTopic;

    /**
     * 分类栏目显示数量
     */
    private Integer countCategory;

    /**
     * 分类栏目商品显示数量
     */
    private Integer countCategoryGoods;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;
}