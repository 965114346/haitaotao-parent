package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.GoodsAttribute;

/**
 * 商品参数表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IGoodsAttributeService {

    /**
    * 根据id查询商品参数表
    * @param id
    * @return
    */
    GoodsAttribute selectByPrimaryKey(Long id);

    /**
    * 分页查询商品参数表
    * @param goodsAttribute
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<GoodsAttribute> selectByPage(GoodsAttribute goodsAttribute, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询商品参数表
    * @param goodsAttribute
    * @return
    */
    List<GoodsAttribute> selectByCondition(GoodsAttribute goodsAttribute);

    /**
    * 添加商品参数表
    * @param goodsAttribute
    * @return
    */
    boolean insert(GoodsAttribute goodsAttribute);

    /**
    * 根据id更新商品参数表
    * @param goodsAttribute
    * @return
    */
    boolean updateByPrimaryKey(GoodsAttribute goodsAttribute);

    /**
    * 单个删除商品参数表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除商品参数表(也可单个删除商品参数表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);

    /**
     * 商品参数列表
     * @param goodsId 商品id
     * @return
     */
    List<GoodsAttribute> listByGoodsId(Long goodsId);
}
