package com.haitaotao.api.admin.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * 验证码配置
 * @author yangyang
 * @date 2021/1/18 14:59
 */
@Slf4j
@Configuration
public class KaptchaConfiguration {

    @Bean
    public Cache<String, String> stringCache() {
        return CacheBuilder.newBuilder()
                // 使用后有效时长，30秒没有访问删除
                .expireAfterAccess(30L, TimeUnit.SECONDS)
                // 写入后有效时长
                .expireAfterWrite(1L, TimeUnit.MINUTES)
                // 同时并发操作数6
                .concurrencyLevel(6)
                // 初始化容量100
                .initialCapacity(100)
                // 缓存对象个数，最大容量1000
                .maximumSize(1000)
                .removalListener((RemovalListener<String, String>) notification -> {
                    log.warn("kaptcha Cache remove, key[{}], value[{}]", notification.getKey(), notification.getValue());
                })
                .softValues()
                .build();
    }

    @Bean
    public Producer producer() {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", "100");
        properties.setProperty("kaptcha.image.height", "40");
        properties.setProperty("kaptcha.textproducer.font.size", "32");
        properties.setProperty("kaptcha.textproducer.font.color", "0,0,0");
        properties.setProperty("kaptcha.textproducer.char.string", "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");

        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
