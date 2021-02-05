package com.haitaotao.mapper;

import com.haitaotao.entity.Goods;

import java.util.List;

/**
 * 商品基本信息表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface GoodsMapper {

    /**
    * 根据id查询商品基本信息表
    * @param id
    * @return
    */
    Goods selectByPrimaryKey(Long id);

    /**
    * 条件查询商品基本信息表列表
    * @param goods
    * @return
    */
    List<Goods> selectByCondition(Goods goods);

    /**
    * 插入商品基本信息表
    * @param goods
    * @return
    */
    boolean insertSelective(Goods goods);

    /**
    * 更新商品基本信息表
    * @param goods
    * @return
    */
    boolean updateByPrimaryKey(Goods goods);

    /**
    * 根据id删除商品基本信息表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除商品基本信息表
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