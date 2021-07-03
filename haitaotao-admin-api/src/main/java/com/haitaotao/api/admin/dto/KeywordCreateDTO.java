package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yangyang
 * @date 2021/4/10 9:57
 */
@Data
public class KeywordCreateDTO {
    /**
     * 关键字
     */
    @NotBlank
    private String keyword;

    /**
     * 关键字的跳转链接
     */
    private String url;

    /**
     * 是否是热门关键字
     */
    private Integer isHot;

    /**
     * 是否是默认关键字
     */
    private Integer isDefault;
}
