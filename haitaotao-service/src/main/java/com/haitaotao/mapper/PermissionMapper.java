package com.haitaotao.mapper;

import com.haitaotao.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
@Repository
public interface PermissionMapper {

    /**
    * 根据id查询权限表
    * @param id
    * @return
    */
    Permission getById(Long id);

    /**
    * 条件查询权限表列表
    * @param permission
    * @return
    */
    List<Permission> listByCondition(Permission permission);

    /**
     *
     * @param permissionIdList
     * @return
     */
    List<Permission> listPermissionByIdList(@Param("permissionIdList") List<Long> permissionIdList);

    /**
    * 插入权限表
    * @param permission
    * @return
    */
    boolean insert(Permission permission);

    /**
    * 更新权限表
    * @param permission
    * @return
    */
    boolean updateById(Permission permission);

    /**
    * 根据id删除权限表
    * @param id
    * @return
    */
    boolean removeById(Long id);
}