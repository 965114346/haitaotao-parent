package com.haitaotao.api.admin;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yangyang
 * @date 2021/1/11 10:40
 */
@EnableDubbo
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        // 指定项目中dubbo使用的日志框架
        System.setProperty("dubbo.application.logger", "slf4j");
        SpringApplication.run(AdminApplication.class, args);
    }
}
