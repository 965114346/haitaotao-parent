package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yangyang
 * @date 2021/2/4 9:54
 */
@Data
public class CategoryCreateDTO {

    /**
     * 类目名称
     */
    @NotBlank(message = "品类名称不能为空")
    private String name;

    /**
     * 类目关键字，以JSON数组格式
     */
    private String keywords;

    /**
     * 类目广告语介绍
     */
    private String desc;

    /**
     * 父类目ID
     */
    private Long parentId;

    /**
     * 类目图标
     */
    private String iconUrl;

    /**
     * 类目图片
     */
    private String picUrl;

    /**
     *
     */
    private String level;

    /**
     * 排序
     */
    private Integer sortOrder;
}
