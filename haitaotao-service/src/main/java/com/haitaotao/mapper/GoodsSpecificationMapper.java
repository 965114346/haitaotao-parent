package com.haitaotao.mapper;

import com.haitaotao.entity.GoodsSpecification;

import java.util.List;

/**
 * 商品规格表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface GoodsSpecificationMapper {

    /**
    * 根据id查询商品规格表
    * @param id
    * @return
    */
    GoodsSpecification selectByPrimaryKey(Long id);

    /**
    * 条件查询商品规格表列表
    * @param goodsSpecification
    * @return
    */
    List<GoodsSpecification> selectByCondition(GoodsSpecification goodsSpecification);

    /**
    * 插入商品规格表
    * @param goodsSpecification
    * @return
    */
    boolean insertSelective(GoodsSpecification goodsSpecification);

    /**
    * 更新商品规格表
    * @param goodsSpecification
    * @return
    */
    boolean updateByPrimaryKey(GoodsSpecification goodsSpecification);

    /**
    * 根据id删除商品规格表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除商品规格表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}