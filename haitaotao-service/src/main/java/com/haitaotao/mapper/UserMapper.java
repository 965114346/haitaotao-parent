package com.haitaotao.mapper;

import com.haitaotao.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface UserMapper {

    /**
    * 更新用户表
    * @param user
    * @return
    */
    boolean updateById(User user);

    /**
     * 根据用户名匹配一个用户
     * @param username 用户名
     * @return 用户信息
     */
    User selectByUsername(String username);

    /**
     * 用户统计
     * @return
     */
    Long count();

    /**
     * 管理后台 条件查询列表
     * @param username 用户名
     * @param id 用户Id
     * @param mobile 手机号
     * @return
     */
    List<User> listByCondition(@Param("username") String username,
                               @Param("id") Long id,
                               @Param("mobile") String mobile);

    /**
     * 管理后台 通过昵称模糊查询用户id
     * @param nickname 昵称
     * @return 用户id列表
     */
    List<Long> getUserIdLikeNickname(String nickname);
}