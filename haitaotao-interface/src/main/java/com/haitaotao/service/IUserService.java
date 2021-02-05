package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.User;

/**
 * 用户表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IUserService {

    /**
     * 用户数量
     * @return
     */
    Long count();

    /**
     * 根据用户名匹配一个用户
     * @param username 用户名
     * @return 用户信息
     */
    User selectByUsername(String username);

    /**
     * 管理后台 用户列表分页
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @param username 用户名
     * @param userId 用户Id
     * @param mobile 手机号
     * @return
     */
    PageInfo<User> pageList(Integer pageNum, Integer pageSize, String username, Long userId, String mobile);

    /**
     * 更新用户表
     * @param user
     * @return
     */
    boolean updateById(User user);

}
