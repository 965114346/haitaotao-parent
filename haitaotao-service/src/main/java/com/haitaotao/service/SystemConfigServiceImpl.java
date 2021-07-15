package com.haitaotao.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author yangyang
 * @date 2021/6/30 14:54
 */
@Slf4j
@Service
@DubboService
public class SystemConfigServiceImpl implements SystemConfigService, ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public JSONObject get(Long merchantId, String configName) {
        ConfigRouter bean = applicationContext.getBean(configName, ConfigRouter.class);
        return bean.get(merchantId);
    }

    @Override
    public boolean updateById(JSONObject jsonObject, String configName) {
        ConfigRouter bean = applicationContext.getBean(configName, ConfigRouter.class);
        return bean.updateById(jsonObject);
    }
}
