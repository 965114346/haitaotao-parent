package com.haitaotao.mapper;

import com.haitaotao.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
@Repository
public interface AdminMapper {

    /**
    * 根据id查询管理员表
    * @param id
    * @return
    */
    Admin getById(Long id);

    /**
     * 根据用户名匹配一个管理员
     * @param username 用户名
     * @return 管理员信息
     */
    Admin getByUsername(String username);

    /**
    * 条件查询管理员表列表
    * @param username 用户名
    * @return
    */
    List<Admin> listByCondition(@Param("username") String username);

    /**
    * 插入管理员表
    * @param admin
    * @return
    */
    boolean insert(Admin admin);

    /**
    * 更新管理员表
    * @param admin
    * @return
    */
    boolean updateById(Admin admin);

    /**
     * 更新管理员登录信息
     * @param id 管理员id
     * @param ip 登录ip
     * @return
     */
    boolean updateLoginInfo(@Param("id") Long id, @Param("ip") String ip);

    /**
    * 根据id删除管理员表
    * @param id
    * @return
    */
    boolean removeById(Long id);
}