package com.haitaotao.mapper;

import com.haitaotao.entity.GoodsProduct;

import java.util.List;

/**
 * 商品货品表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface GoodsProductMapper {

    /**
    * 根据id查询商品货品表
    * @param id
    * @return
    */
    GoodsProduct selectByPrimaryKey(Long id);

    /**
    * 条件查询商品货品表列表
    * @param goodsProduct
    * @return
    */
    List<GoodsProduct> selectByCondition(GoodsProduct goodsProduct);

    /**
    * 插入商品货品表
    * @param goodsProduct
    * @return
    */
    boolean insertSelective(GoodsProduct goodsProduct);

    /**
    * 更新商品货品表
    * @param goodsProduct
    * @return
    */
    boolean updateByPrimaryKey(GoodsProduct goodsProduct);

    /**
    * 根据id删除商品货品表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除商品货品表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);

    /**
     * 数量统计
     * @return
     */
    Long count();
}