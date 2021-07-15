package com.haitaotao.mapper;

import com.haitaotao.entity.ConfigMall;
import org.springframework.stereotype.Repository;

/**
 * 商场配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
@Repository
public interface ConfigMallMapper {

    ConfigMall get();

    boolean updateById(ConfigMall configMall);
}