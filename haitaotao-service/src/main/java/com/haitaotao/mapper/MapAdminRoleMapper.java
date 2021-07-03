package com.haitaotao.mapper;

import java.util.List;

/**
 * @author yangyang
 * @date 2021/5/13 14:47
 */
public interface MapAdminRoleMapper {

    /**
     * 查询管理员角色id列表
     * @param adminId 管理员id
     * @return
     */
    List<Long> listRoleIdByAdminId(Long adminId);
}
