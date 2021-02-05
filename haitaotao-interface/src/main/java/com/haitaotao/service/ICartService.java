package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Cart;

/**
 * 购物车商品表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface ICartService {

    /**
    * 根据id查询购物车商品表
    * @param id
    * @return
    */
    Cart selectByPrimaryKey(Long id);

    /**
    * 分页查询购物车商品表
    * @param cart
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Cart> selectByPage(Cart cart, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询购物车商品表
    * @param cart
    * @return
    */
    List<Cart> selectByCondition(Cart cart);

    /**
    * 添加购物车商品表
    * @param cart
    * @return
    */
    boolean insert(Cart cart);

    /**
    * 根据id更新购物车商品表
    * @param cart
    * @return
    */
    boolean updateByPrimaryKey(Cart cart);

    /**
    * 单个删除购物车商品表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除购物车商品表(也可单个删除购物车商品表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
