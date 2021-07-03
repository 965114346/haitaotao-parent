package com.haitaotao.mapper;

import com.haitaotao.entity.ConfigExpress;

/**
 * 运费配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
public interface ConfigExpressMapper {

    ConfigExpress get();

    boolean updateById(ConfigExpress configExpress);
}