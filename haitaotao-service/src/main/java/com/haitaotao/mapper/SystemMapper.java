package com.haitaotao.mapper;

import com.haitaotao.entity.System;

import java.util.List;

/**
 * 系统配置表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface SystemMapper {

    /**
    * 根据id查询系统配置表
    * @param id
    * @return
    */
    System selectByPrimaryKey(Long id);

    /**
    * 条件查询系统配置表列表
    * @param system
    * @return
    */
    List<System> selectByCondition(System system);

    /**
    * 插入系统配置表
    * @param system
    * @return
    */
    boolean insertSelective(System system);

    /**
    * 更新系统配置表
    * @param system
    * @return
    */
    boolean updateByPrimaryKey(System system);

    /**
    * 根据id删除系统配置表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除系统配置表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}