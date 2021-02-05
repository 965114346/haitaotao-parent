package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author yangyang
 * @date 2021/1/28 15:11
 */
@Data
public class BrandCreateDTO {

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
