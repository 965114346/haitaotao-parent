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
     * 管理员角色列表
     * @param adminId 管理员id
     * @return {@link Role}
     */
    List<Role> listRoleByAdminId(Long adminId);

    /**
     * 分页查询角色
     *
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param name     角色名称
     * @return {@link Role}
     */
    PageInfo<Role> pageList(Integer pageNum, Integer pageSize, String name);

    /**
     * 添加角色
     * @param role {@link Role}
     * @return
     */
    boolean add(Role role);

    /**
     * 更新角色信息
     * @param role {@link Role}
     * @return
     */
    boolean updateById(Role role);

    /**
     * 根据角色id删除角色
     * @param id 角色id
     * @return
     */
    boolean removeById(Long id);
}
