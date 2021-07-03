package com.haitaotao.api.admin.vo;

import com.haitaotao.entity.Goods;
import com.haitaotao.entity.GoodsAttribute;
import com.haitaotao.entity.GoodsProduct;
import com.haitaotao.entity.GoodsSpecification;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author yangyang
 * @date 2021/4/19 16:44
 */
@Data
@AllArgsConstructor
public class GoodsDetailVO {

    private Goods goods;

    private List<GoodsProduct> products;

    private List<GoodsAttribute> attributes;

    private List<GoodsSpecification> specifications;

    private List<Long> categoryIds;
}
