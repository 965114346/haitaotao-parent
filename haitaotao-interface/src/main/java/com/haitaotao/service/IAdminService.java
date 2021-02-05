package com.haitaotao.service;

import java.util.List;

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
    * @param id
    * @return
    */
    Admin selectByPrimaryKey(Long id);

    /**
    * 分页查询管理员表
    * @param admin
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Admin> selectByPage(Admin admin, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询管理员表
    * @param admin
    * @return
    */
    List<Admin> selectByCondition(Admin admin);

    /**
    * 添加管理员表
    * @param admin
    * @return
    */
    boolean insert(Admin admin);

    /**
    * 根据id更新管理员表
    * @param admin
    * @return
    */
    boolean updateByPrimaryKey(Admin admin);

    /**
    * 单个删除管理员表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除管理员表(也可单个删除管理员表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
