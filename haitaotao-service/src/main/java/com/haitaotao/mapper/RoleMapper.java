package com.haitaotao.mapper;

import com.haitaotao.entity.Role;

import java.util.List;
import java.util.Set;

/**
 * 角色表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface RoleMapper {

    /**
    * 根据id查询角色表
    * @param id
    * @return
    */
    Role selectByPrimaryKey(Long id);

    /**
    * 条件查询角色表列表
    * @param role
    * @return
    */
    List<Role> selectByCondition(Role role);

    /**
    * 插入角色表
    * @param role
    * @return
    */
    boolean insertSelective(Role role);

    /**
    * 更新角色表
    * @param role
    * @return
    */
    boolean updateByPrimaryKey(Role role);

    /**
    * 根据id删除角色表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除角色表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);

    /**
     * 可用角色名称列表
     * @param roleIds
     * @return
     */
    Set<String> listNameByIds(List<Integer> roleIds);
}