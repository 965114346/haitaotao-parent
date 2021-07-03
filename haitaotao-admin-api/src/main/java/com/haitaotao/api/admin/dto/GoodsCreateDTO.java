package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yangyang
 * @date 2021/4/10 14:08
 */
@Data
public class GoodsCreateDTO {

    @NotNull
    private GoodsDTO goods;

    private List<GoodsProductDTO> goodsProductList;

    private List<GoodsAttributeDTO> goodsAttributeList;

    private List<GoodsSpecificationDTO> goodsSpecificationList;
}
