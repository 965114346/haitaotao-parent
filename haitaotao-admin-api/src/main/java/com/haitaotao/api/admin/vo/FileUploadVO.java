package com.haitaotao.api.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yangyang
 * @date 2021/2/3 11:19
 */
@Data
@AllArgsConstructor
public class FileUploadVO {

    /**
     * 原始文件名称
     */
    private String originalFilename;

    /**
     * 对象存储名称
     */
    private String objectName;

    /**
     * 对象url地址
     */
    private String url;

    /**
     * 文件类型
     */
    private String contentType;

    /**
     * 文件大小
     */
    private Long size;
}
