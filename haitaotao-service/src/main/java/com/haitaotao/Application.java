package com.haitaotao;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 开启基于注解的dubbo功能（主要是包扫描@DubboComponentScan）
 * @author yangyang
 * @date 2021/1/6 16:43
 */
@EnableDubbo
@MapperScan("com.haitaotao.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // 指定项目中dubbo使用的日志框架
        System.setProperty("dubbo.application.logger", "slf4j");
        SpringApplication.run(Application.class, args);
    }
}
