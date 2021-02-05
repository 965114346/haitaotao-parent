package com.haitaotao.mapper;

import com.haitaotao.entity.Cart;

import java.util.List;

/**
 * 购物车商品表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface CartMapper {

    /**
    * 根据id查询购物车商品表
    * @param id
    * @return
    */
    Cart selectByPrimaryKey(Long id);

    /**
    * 条件查询购物车商品表列表
    * @param cart
    * @return
    */
    List<Cart> selectByCondition(Cart cart);

    /**
    * 插入购物车商品表
    * @param cart
    * @return
    */
    boolean insertSelective(Cart cart);

    /**
    * 更新购物车商品表
    * @param cart
    * @return
    */
    boolean updateByPrimaryKey(Cart cart);

    /**
    * 根据id删除购物车商品表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除购物车商品表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}