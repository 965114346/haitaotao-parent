package com.haitaotao.service;

import java.util.List;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Permission;

/**
 * 权限表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IPermissionService {

    /**
     * 角色权限名称列表
     * @param roleIds 角色id列表
     * @return 权限名称列表
     */
    Set<String> listNameByRoleIds(List<Integer> roleIds);
}
