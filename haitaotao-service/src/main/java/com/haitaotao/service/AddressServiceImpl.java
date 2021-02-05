package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Address;
import com.haitaotao.mapper.AddressMapper;

/**
 * 收货地址表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public PageInfo<Address> pageList(Integer pageNum, Integer pageSize, Long userId, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Address> list = addressMapper.listByCondition(userId, name);
        return PageInfo.of(list);
    }
}
