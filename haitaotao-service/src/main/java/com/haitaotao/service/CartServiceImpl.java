package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Cart;
import com.haitaotao.mapper.CartMapper;
import com.haitaotao.service.ICartService;

/**
 * 购物车商品表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper mapper;

    @Override
    public Cart selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Cart> selectByPage(Cart cart, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Cart> list = mapper.selectByCondition(cart);
        return new PageInfo<>(list);
    }

    @Override
    public List<Cart> selectByCondition(Cart cart){
        return mapper.selectByCondition(cart);
    }

    @Override
    public boolean insert(Cart cart){
        return mapper.insertSelective(cart);
    }

    @Override
    public boolean updateByPrimaryKey(Cart cart){
        return mapper.updateByPrimaryKey(cart);
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean batchDeleteByPrimaryKey(List<Long> ids) {
        return mapper.batchDeleteByPrimaryKey(ids);
    }

}
