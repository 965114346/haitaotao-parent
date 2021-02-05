package com.haitaotao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author yangyang
 * @date 2021/1/6 16:43
 */
public class Application {

    public static void main(String[] args) throws IOException {
        // 指定项目中dubbo使用的日志框架
        System.setProperty("dubbo.application.logger", "slf4j");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application.xml");
        applicationContext.start();
        System.in.read();//阻塞
        applicationContext.close();
    }
}
