package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.System;

/**
 * 系统配置表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface ISystemService {

    /**
    * 根据id查询系统配置表
    * @param id
    * @return
    */
    System selectByPrimaryKey(Long id);

    /**
    * 分页查询系统配置表
    * @param system
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<System> selectByPage(System system, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询系统配置表
    * @param system
    * @return
    */
    List<System> selectByCondition(System system);

    /**
    * 添加系统配置表
    * @param system
    * @return
    */
    boolean insert(System system);

    /**
    * 根据id更新系统配置表
    * @param system
    * @return
    */
    boolean updateByPrimaryKey(System system);

    /**
    * 单个删除系统配置表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除系统配置表(也可单个删除系统配置表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
