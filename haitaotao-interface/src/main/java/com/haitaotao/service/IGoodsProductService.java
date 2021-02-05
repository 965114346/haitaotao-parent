package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.GoodsProduct;

/**
 * 商品货品表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IGoodsProductService {

    /**
     * 数量统计
     * @return
     */
    Long count();
}
