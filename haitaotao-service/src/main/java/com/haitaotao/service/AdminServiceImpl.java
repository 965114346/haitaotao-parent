package com.haitaotao.service;

import java.util.List;

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
    public Admin selectByPrimaryKey(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Admin> selectByPage(Admin admin, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Admin> list = adminMapper.selectByCondition(admin);
        return new PageInfo<>(list);
    }

    @Override
    public List<Admin> selectByCondition(Admin admin){
        return adminMapper.selectByCondition(admin);
    }

    @Override
    public boolean insert(Admin admin){
        return adminMapper.insertSelective(admin);
    }

    @Override
    public boolean updateByPrimaryKey(Admin admin){
        return adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean batchDeleteByPrimaryKey(List<Long> ids) {
        return adminMapper.batchDeleteByPrimaryKey(ids);
    }

}
