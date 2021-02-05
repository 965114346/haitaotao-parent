package com.haitaotao.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Set<String> listNameByIds(List<Integer> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) {
            return new HashSet<>();
        }
        return roleMapper.listNameByIds(roleIds);
    }
}
