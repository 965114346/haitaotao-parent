package com.haitaotao.mapper;

import com.haitaotao.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收货地址表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface AddressMapper {

    /**
     * 条件查询收货地址表列表
     * @param userId 用户id
     * @param name 收货人名称
     * @return 收货地址表列表
     */
    List<Address> listByCondition(@Param("userId") Long userId, @Param("name") String name);
}