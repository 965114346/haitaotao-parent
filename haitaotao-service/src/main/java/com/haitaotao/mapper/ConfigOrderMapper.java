package com.haitaotao.mapper;

import com.haitaotao.entity.ConfigOrder;
import org.springframework.stereotype.Repository;

/**
 * 订单配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
@Repository
public interface ConfigOrderMapper {

    ConfigOrder get();

    boolean updateById(ConfigOrder configOrder);
}