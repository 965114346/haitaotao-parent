package com.haitaotao.mapper;

import com.haitaotao.entity.GoodsAttribute;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品参数表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
@Repository
public interface GoodsAttributeMapper {

    /**
    * 根据id查询商品参数表
    * @param id
    * @return
    */
    GoodsAttribute selectByPrimaryKey(Long id);

    /**
    * 条件查询商品参数表列表
    * @param goodsAttribute
    * @return
    */
    List<GoodsAttribute> selectByCondition(GoodsAttribute goodsAttribute);

    /**
    * 插入商品参数表
    * @param goodsAttribute
    * @return
    */
    boolean insertSelective(GoodsAttribute goodsAttribute);

    /**
    * 更新商品参数表
    * @param goodsAttribute
    * @return
    */
    boolean updateByPrimaryKey(GoodsAttribute goodsAttribute);

    /**
    * 根据id删除商品参数表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除商品参数表
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