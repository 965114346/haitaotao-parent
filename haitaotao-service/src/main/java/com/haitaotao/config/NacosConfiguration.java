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
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "localhost:8848", namespace = "4d175029-a897-43a0-a204-3014c515ebd2"))
@NacosPropertySource(dataId = "haitaotao_db.properties", autoRefreshed = false)
public class NacosConfiguration {

    @NacosConfigListener(dataId = "haitaotao_db.properties")
    public void onChange(String properties) {
    }

}
