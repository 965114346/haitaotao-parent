package com.haitaotao.mapper;

import com.haitaotao.entity.Permission;

import java.util.List;
import java.util.Set;

/**
 * 权限表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface PermissionMapper {

    /**
    * 根据id查询权限表
    * @param id
    * @return
    */
    Permission selectByPrimaryKey(Long id);

    /**
    * 条件查询权限表列表
    * @param permission
    * @return
    */
    List<Permission> selectByCondition(Permission permission);

    /**
    * 插入权限表
    * @param permission
    * @return
    */
    boolean insertSelective(Permission permission);

    /**
    * 更新权限表
    * @param permission
    * @return
    */
    boolean updateByPrimaryKey(Permission permission);

    /**
    * 根据id删除权限表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除权限表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);

    /**
     * 角色权限名称列表
     * @param roleIds 角色id列表
     * @return 权限名称列表
     */
    Set<String> listNameByRoleIds(List<Integer> roleIds);
}