package com.haitaotao.service;

import com.alibaba.fastjson.JSONObject;
import com.haitaotao.entity.ConfigExpress;
import com.haitaotao.mapper.ConfigExpressMapper;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 运费配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
@Slf4j
@Service("config-express")
public class ConfigExpressServiceImpl implements ConfigRouter {

    @Autowired
    private ConfigExpressMapper configExpressMapper;

    @Override
    public JSONObject get(Long merchantId) {
        ConfigExpress express = configExpressMapper.get();
        return JSONObject.parseObject(JSONObject.toJSONString(express));
    }

    @Override
    public boolean updateById(JSONObject jsonObject) {
        ConfigExpress express = JSONObject.parseObject(jsonObject.toJSONString(), ConfigExpress.class);
        Assert.isTrue(Objects.nonNull(express.getId()), "id不能为空");
        return configExpressMapper.updateById(express);
    }
}
