package com.haitaotao.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.haitaotao.entity.MapRolePermission;
import com.haitaotao.mapper.MapRolePermissionMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Permission;
import com.haitaotao.mapper.PermissionMapper;
import com.haitaotao.service.IPermissionService;

/**
 * 权限表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private MapRolePermissionMapper mapRolePermissionMapper;

    @Override
    public List<Permission> listPermissionByRoleIdList(List<Long> roleIdList) {
        if (CollectionUtils.isEmpty(roleIdList)) {
            return Collections.emptyList();
        }

        List<Long> permissionIdList = mapRolePermissionMapper.listPermissionIdByRoleIdList(roleIdList);
        if (CollectionUtils.isEmpty(permissionIdList)) {
            return Collections.emptyList();
        }

        return permissionMapper.listPermissionByIdList(permissionIdList);
    }
}
