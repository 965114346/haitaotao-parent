package com.haitaotao.mapper;

import com.haitaotao.entity.ConfigExpress;
import org.springframework.stereotype.Repository;

/**
 * 运费配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
@Repository
public interface ConfigExpressMapper {

    ConfigExpress get();

    boolean updateById(ConfigExpress configExpress);
}