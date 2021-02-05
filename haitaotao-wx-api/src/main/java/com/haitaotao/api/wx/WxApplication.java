package com.haitaotao.api.wx;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yangyang
 * @date 2021/1/5 14:29
 */
@EnableDubbo
@SpringBootApplication
public class WxApplication {

    public static void main(String[] args) {
        // 指定项目中dubbo使用的日志框架
        System.setProperty("dubbo.application.logger", "slf4j");
        SpringApplication.run(WxApplication.class, args);
    }
}
