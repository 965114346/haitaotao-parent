package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yangyang
 * @date 2021/5/13 11:18
 */
@Data
public class RoleCreateDTO {

    /**
     * 角色名称
     */
    @NotBlank
    private String name;

    /**
     * 角色描述
     */
    @NotBlank
    private String desc;
}
