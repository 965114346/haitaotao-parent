package com.haitaotao.mapper;

import com.haitaotao.entity.Admin;

import java.util.List;

/**
 * 管理员表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface AdminMapper {

    /**
    * 根据id查询管理员表
    * @param id
    * @return
    */
    Admin selectByPrimaryKey(Long id);

    /**
    * 条件查询管理员表列表
    * @param admin
    * @return
    */
    List<Admin> selectByCondition(Admin admin);

    /**
    * 插入管理员表
    * @param admin
    * @return
    */
    boolean insertSelective(Admin admin);

    /**
    * 更新管理员表
    * @param admin
    * @return
    */
    boolean updateByPrimaryKey(Admin admin);

    /**
    * 根据id删除管理员表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除管理员表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);

    /**
     * 根据用户名匹配一个管理员
     * @param username 用户名
     * @return 管理员信息
     */
    Admin getByUsername(String username);
}