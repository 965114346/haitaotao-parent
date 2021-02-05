package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 品牌更新dto
 * @author yangyang
 * @date 2021/2/1 15:48
 */
@Data
public class BrandUpdateDTO {

    @NotNull(message = "品牌id不能为空")
    private Long id;

    /**
     * 品牌商名称
     */
    @NotBlank(message = "品牌名称不能为空")
    private String name;

    /**
     * 品牌商简介
     */
    private String desc;

    /**
     * 品牌商页的品牌商图片
     */
    private String picUrl;

    /**
     * 品牌商的商品低价，仅用于页面展示
     */
    private BigDecimal floorPrice;
}
