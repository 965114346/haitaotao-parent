package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Address;

/**
 * 收货地址表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:12
 */
public interface IAddressService {

    /**
     * 分页查询收货地址表
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @param userId 用户id
     * @param name 收货人名称
     * @return
     */
    PageInfo<Address> pageList(Integer pageNum, Integer pageSize, Long userId, String name);
}
