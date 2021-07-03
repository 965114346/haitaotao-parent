package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yangyang
 * @date 2021/5/13 11:18
 */
@Data
public class RoleUpdateDTO {

    /**
     *
     */
    @NotNull
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String desc;
}
