package com.haitaotao.service;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Admin;

/**
 * 管理员表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:12
 */
public interface IAdminService {

    /**
     * 根据用户名匹配一个管理员
     * @param username 用户名
     * @return 管理员信息
     */
    Admin getByUsername(String username);

    /**
    * 根据id查询管理员表
    * @param id 管理员id
    * @return
    */
    Admin getById(Long id);

    /**
     * 分页查询管理员
     *
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param username     名称
     * @return {@link Admin}
     */
    PageInfo<Admin> pageList(Integer pageNum, Integer pageSize, String username);

    /**
     * 新增管理员
     *
     * @param admin {@link Admin}
     * @return
     */
    boolean add(Admin admin);

    /**
     * 更新管理员
     *
     * @param admin {@link Admin}
     * @return
     */
    boolean updateById(Admin admin);

    /**
     * 更新管理员登录信息
     * @param id 管理员id
     * @param ip 登录ip
     * @return
     */
    boolean updateLoginInfo(Long id, String ip);

    /**
     * 删除管理员
     *
     * @param id 管理员id
     * @return
     */
    boolean removeById(Long id);
}
