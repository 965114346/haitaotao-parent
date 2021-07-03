package com.haitaotao.service;

import com.alibaba.fastjson.JSONObject;
import com.haitaotao.entity.ConfigMiniProgram;
import com.haitaotao.mapper.ConfigMiniProgramMapper;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 商场配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
@Slf4j
@Service("config-mini-program")
public class ConfigMiniProgramServiceImpl implements ConfigRouter {

    @Autowired
    private ConfigMiniProgramMapper configMiniProgramMapper;

    @Override
    public JSONObject get(Long merchantId) {
        ConfigMiniProgram configMiniProgram = configMiniProgramMapper.get();
        return JSONObject.parseObject(JSONObject.toJSONString(configMiniProgram));
    }

    @Override
    public boolean updateById(JSONObject jsonObject) {
        ConfigMiniProgram configMiniProgram = JSONObject.parseObject(jsonObject.toJSONString(), ConfigMiniProgram.class);
        Assert.isTrue(Objects.nonNull(configMiniProgram.getId()), "id不能为空");
        return configMiniProgramMapper.updateById(configMiniProgram);
    }
}
