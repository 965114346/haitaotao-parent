package com.haitaotao.service;

import java.util.List;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Role;

/**
 * 角色表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IRoleService {

    /**
     * 角色id查询角色名称列表
     * @param roleIds
     * @return
     */
    Set<String> listNameByIds(List<Integer> roleIds);
}
