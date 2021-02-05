package com.haitaotao.api.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yangyang
 */
@Component
@ConfigurationProperties(prefix = "minio")
@Data
public class MinioProperties {

    private String bucketName;

    private String accessKey;

    private String secretKey;

    private String endpoint;
}
