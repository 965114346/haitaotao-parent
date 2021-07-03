package com.haitaotao.entity;

import lombok.Data;

/**
 * @author yangyang
 * @date 2021/5/13 14:48
 */
@Data
public class MapAdminRole {

    private Long id;

    /**
     * 管理员id
     */
    private Long adminId;

    /**
     * 角色id
     */
    private Long roleId;
}
