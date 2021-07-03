package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yangyang
 * @date 2021/4/26 17:11
 */
@Data
public class AdUpdateDTO {

    @NotNull
    private Long id;

    /**
     * 广告标题
     */
    private String name;

    /**
     * 所广告的商品页面或者活动页面链接地址
     */
    private String link;

    /**
     * 广告宣传图片
     */
    private String url;

    /**
     * 广告位置：1则是首页
     */
    private Integer position;

    /**
     * 活动内容
     */
    private String content;

    /**
     * 是否启动（0：禁用 1：启用）
     */
    private Integer enabled;
}
