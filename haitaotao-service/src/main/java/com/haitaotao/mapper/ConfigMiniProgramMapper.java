package com.haitaotao.mapper;

import com.haitaotao.entity.ConfigMiniProgram;
import org.springframework.stereotype.Repository;

/**
 * 商场配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
@Repository
public interface ConfigMiniProgramMapper {

    ConfigMiniProgram get();

    boolean updateById(ConfigMiniProgram configMiniProgram);
}