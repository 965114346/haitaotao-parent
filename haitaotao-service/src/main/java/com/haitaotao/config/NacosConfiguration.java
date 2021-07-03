package com.haitaotao.config;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

/**
 * nacos 远程配置中心
 * @author yangyang
 * @date 2021/1/8 13:50
 */
@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "localhost:8848", namespace = "dev"))
@NacosPropertySource(dataId = "haitaotao_db.properties", autoRefreshed = true)
public class NacosConfiguration {

    @NacosConfigListener(dataId = "haitaotao_db.properties")
    public void onChange(String properties) {
    }

}
