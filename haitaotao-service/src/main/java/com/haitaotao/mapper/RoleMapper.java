package com.haitaotao.mapper;

import com.haitaotao.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 角色表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
@Repository
public interface RoleMapper {

    /**
     * 根据id查询角色表
     *
     * @param id
     * @return
     */
    Role getById(Long id);

    /**
     * 条件查询角色表列表
     *
     * @param name 角色名称
     * @return
     */
    List<Role> listByCondition(@Param("name") String name);

    /**
     * 角色列表
     *
     * @param roleIdList
     * @return
     */
    List<Role> listRoleByIdList(@Param("roleIdList") List<Long> roleIdList);

    /**
     * 插入角色表
     *
     * @param role
     * @return
     */
    boolean insert(Role role);

    /**
     * 更新角色表
     *
     * @param role
     * @return
     */
    boolean updateById(Role role);

    /**
     * 根据id删除角色表
     *
     * @param id
     * @return
     */
    boolean removeById(Long id);
}