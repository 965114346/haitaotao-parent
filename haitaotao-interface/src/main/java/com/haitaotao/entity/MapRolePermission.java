package com.haitaotao.entity;

import lombok.Data;

/**
 * @author yangyang
 * @date 2021/5/13 15:11
 */
@Data
public class MapRolePermission {

    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long permissionId;
}
