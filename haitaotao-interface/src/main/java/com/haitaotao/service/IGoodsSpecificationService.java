package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.GoodsSpecification;

/**
 * 商品规格表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IGoodsSpecificationService {

    /**
    * 根据id查询商品规格表
    * @param id
    * @return
    */
    GoodsSpecification selectByPrimaryKey(Long id);

    /**
    * 分页查询商品规格表
    * @param goodsSpecification
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<GoodsSpecification> selectByPage(GoodsSpecification goodsSpecification, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询商品规格表
    * @param goodsSpecification
    * @return
    */
    List<GoodsSpecification> selectByCondition(GoodsSpecification goodsSpecification);

    /**
    * 添加商品规格表
    * @param goodsSpecification
    * @return
    */
    boolean insert(GoodsSpecification goodsSpecification);

    /**
    * 根据id更新商品规格表
    * @param goodsSpecification
    * @return
    */
    boolean updateByPrimaryKey(GoodsSpecification goodsSpecification);

    /**
    * 单个删除商品规格表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除商品规格表(也可单个删除商品规格表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
