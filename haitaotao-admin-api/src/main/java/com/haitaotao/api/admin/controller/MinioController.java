package com.haitaotao.api.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.haitaotao.api.admin.config.MinioProperties;
import com.haitaotao.api.admin.vo.FileUploadVO;
import com.haitaotao.common.util.IDUtils;
import com.haitaotao.common.util.ResponseUtil;
import io.minio.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yangyang
 * @date 2021/2/3 10:39
 */
@Slf4j
@RestController
@RequestMapping("/api/minio")
public class MinioController {

    @Autowired
    private MinioProperties properties;

    @Autowired
    private MinioClient minioClient;

    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file) {
        try {
            String bucketName = properties.getBucketName();
            // Make bucket if not exist.
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                // Make a new bucket called.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                //创建存储桶并设置只读权限
                String bucketPolicy = "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetBucketLocation\"],\"Resource\":[\"arn:aws:s3:::bucketName\"]},{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:ListBucket\"],\"Resource\":[\"arn:aws:s3:::bucketName\"],\"Condition\":{\"StringEquals\":{\"s3:prefix\":[\"*.*\"]}}},{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetObject\"],\"Resource\":[\"arn:aws:s3:::bucketName/*.**\"]}]}";
                String config = bucketPolicy.replace("bucketName", bucketName);
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName).config(config).build());
            } else {
//                获取只读配置
//                String bucketPolicy = minioClient.getBucketPolicy(GetBucketPolicyArgs.builder().bucket(bucketName).build());
//                log.info(bucketPolicy);
                log.debug("Bucket '{}' already exists.", bucketName);
            }

            // 原始文件名称
            String originalFilename = file.getOriginalFilename();
            log.debug("文件上传 ====> {}", originalFilename);

            // 设置存储对象名称
            String objectName = IDUtils.genImageName();
            if (StringUtils.isNotEmpty(originalFilename)) {
                objectName = objectName.concat(originalFilename.substring(originalFilename.lastIndexOf(".")));
            }

            // 使用putObject上传一个文件到存储桶中
            ObjectWriteResponse object = minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .build());
            log.info("文件上传成功!, objectWriteResponse: [{}]", JSONObject.toJSONString(object));
            String url = StringUtils.join(properties.getEndpoint(), "/", bucketName, "/", objectName);
            return ResponseUtil.ok(new FileUploadVO(originalFilename, objectName, url, file.getContentType(), file.getSize()));
        } catch (Exception e) {
            log.info("上传发生错误: {}！", e.getMessage());
            return ResponseUtil.error(e.getMessage());
        }
    }
}
