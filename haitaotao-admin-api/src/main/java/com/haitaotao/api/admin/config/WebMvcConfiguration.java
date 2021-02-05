package com.haitaotao.api.admin.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.haitaotao.api.admin.filter.CurrentAdminMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

/**
 * @author yangyang
 * @date 2021/1/11 14:43
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private CurrentAdminMethodArgumentResolver currentAdminMethodArgumentResolver;


    /**
     * 配置阿里巴巴FastJson
     * @return FastJsonHttpMessageConverter
     */
    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        // 1.创建FastJsonHttpMessageConverter对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        // 2.创建FastJsonConfig配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect);

        // 3.将FastJsonConfig配置设置到converter中
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        //解决乱码问题
        List<MediaType> mediaTypes = Collections.singletonList(MediaType.APPLICATION_JSON);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);

        return fastJsonHttpMessageConverter;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentAdminMethodArgumentResolver);
    }

}
