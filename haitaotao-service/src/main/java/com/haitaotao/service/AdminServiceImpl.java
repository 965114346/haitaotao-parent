package com.haitaotao.service;

import com.haitaotao.mapper.AdminMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Admin;

/**
 * 管理员表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getByUsername(String username) {
        return adminMapper.getByUsername(username);
    }

    @Override
    public Admin getById(Long id) {
        return adminMapper.getById(id);
    }

    @Override
    public PageInfo<Admin> pageList(Integer pageNum, Integer pageSize, String username) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> adminMapper.listByCondition(username));
    }

    @Override
    public boolean add(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public boolean updateById(Admin admin) {
        return adminMapper.updateById(admin);
    }

    @Override
    public boolean updateLoginInfo(Long id, String ip) {
        return adminMapper.updateLoginInfo(id, ip);
    }

    @Override
    public boolean removeById(Long id) {
        return adminMapper.removeById(id);
    }
}
