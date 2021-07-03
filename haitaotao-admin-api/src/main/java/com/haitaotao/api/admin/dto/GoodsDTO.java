package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yangyang
 * @date 2021/4/10 15:49
 */
@Data
public class GoodsDTO {

    /**
     * 商品编号
     */
    @NotBlank
    private String goodsNo;

    /**
     * 商品名称
     */
    @NotBlank
    private String name;

    /**
     * 品牌商id
     */
    @NotNull
    private Long brandId;

    /**
     * 分类id
     */
    @NotNull
    private Long categoryId;


}
