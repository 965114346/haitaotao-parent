package com.haitaotao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangyang
 * @date 2021/5/13 15:09
 */
public interface MapRolePermissionMapper {

    /**
     * 角色权限id列表
     * @param roleIdList 角色id列表
     * @return
     */
    List<Long> listPermissionIdByRoleIdList(@Param("roleIdList") List<Long> roleIdList);
}
