package com.haitaotao.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.haitaotao.mapper.MapAdminRoleMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Role;
import com.haitaotao.mapper.RoleMapper;
import com.haitaotao.service.IRoleService;

/**
 * 角色表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MapAdminRoleMapper mapAdminRoleMapper;

    @Override
    public List<Role> listRoleByAdminId(Long adminId) {
        List<Long> roleIdList = mapAdminRoleMapper.listRoleIdByAdminId(adminId);

        if (CollectionUtils.isNotEmpty(roleIdList)) {
            return roleMapper.listRoleByIdList(roleIdList);
        }
        return Collections.emptyList();
    }

    @Override
    public PageInfo<Role> pageList(Integer pageNum, Integer pageSize, String name) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> roleMapper.listByCondition(name));
    }

    @Override
    public boolean add(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public boolean updateById(Role role) {
        return roleMapper.updateById(role);
    }

    @Override
    public boolean removeById(Long id) {
        return roleMapper.removeById(id);
    }
}
