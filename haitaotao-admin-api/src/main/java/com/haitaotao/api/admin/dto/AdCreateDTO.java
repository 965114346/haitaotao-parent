package com.haitaotao.api.admin.dto;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yangyang
 * @date 2021/4/26 17:11
 */
@Data
public class AdCreateDTO {

    /**
     * 广告标题
     */
    @NotBlank
    private String name;

    /**
     * 所广告的商品页面或者活动页面链接地址
     */
    private String link;

    /**
     * 广告宣传图片
     */
    @NotBlank
    @URL
    private String url;

    /**
     * 广告位置：1则是首页
     */
    @NotNull
    private Integer position;

    /**
     * 活动内容
     */
    @NotBlank
    private String content;

    /**
     * 是否启动（0：禁用 1：启用）
     */
    @NotNull
    private Integer enabled;
}
