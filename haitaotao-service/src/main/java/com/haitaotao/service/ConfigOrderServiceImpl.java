package com.haitaotao.service;

import com.alibaba.fastjson.JSONObject;
import com.haitaotao.entity.ConfigOrder;
import com.haitaotao.mapper.ConfigOrderMapper;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 订单配置表
 *
 * @author yangyang
 * @date 2021-6-29 14:43:06
 */
@Slf4j
@Service("config-order")
public class ConfigOrderServiceImpl implements ConfigRouter {

    @Autowired
    private ConfigOrderMapper configOrderMapper;

    @Override
    public JSONObject get(Long merchantId) {
        ConfigOrder configOrder = configOrderMapper.get();
        return JSONObject.parseObject(JSONObject.toJSONString(configOrder));
    }

    @Override
    public boolean updateById(JSONObject jsonObject) {
        ConfigOrder configOrder = JSONObject.parseObject(jsonObject.toJSONString(), ConfigOrder.class);
        Assert.isTrue(Objects.nonNull(configOrder.getId()), "id不能为空");
        return configOrderMapper.updateById(configOrder);
    }
}
