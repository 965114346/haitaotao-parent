package com.haitaotao.service;

import com.alibaba.fastjson.JSONObject;
import com.haitaotao.entity.ConfigMall;
import com.haitaotao.mapper.ConfigMallMapper;
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
@Service("config-mall")
public class ConfigMallServiceImpl implements ConfigRouter {

    @Autowired
    private ConfigMallMapper configMallMapper;

    @Override
    public JSONObject get(Long merchantId) {
        ConfigMall configMall = configMallMapper.get();
        return JSONObject.parseObject(JSONObject.toJSONString(configMall));
    }

    @Override
    public boolean updateById(JSONObject jsonObject) {
        ConfigMall configMall = JSONObject.parseObject(jsonObject.toJSONString(), ConfigMall.class);
        Assert.isTrue(Objects.nonNull(configMall.getId()), "id不能为空");
        return configMallMapper.updateById(configMall);
    }
}
