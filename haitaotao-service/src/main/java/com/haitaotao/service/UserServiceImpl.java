package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.User;
import com.haitaotao.mapper.UserMapper;

/**
 * 用户表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long count() {
        return userMapper.count();
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public PageInfo<User> pageList(Integer pageNum, Integer pageSize, String username, Long userId, String mobile) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.listByCondition(username, userId, mobile);
        return PageInfo.of(list);
    }

    @Override
    public boolean updateById(User user) {
        return userMapper.updateById(user);
    }
}
