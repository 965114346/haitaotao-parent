package com.haitaotao.mapper;

import com.haitaotao.entity.Log;

import java.util.List;

/**
 * 操作日志表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface LogMapper {

    /**
    * 根据id查询操作日志表
    * @param id
    * @return
    */
    Log selectByPrimaryKey(Long id);

    /**
    * 条件查询操作日志表列表
    * @param log
    * @return
    */
    List<Log> selectByCondition(Log log);

    /**
    * 插入操作日志表
    * @param log
    * @return
    */
    boolean insertSelective(Log log);

    /**
    * 更新操作日志表
    * @param log
    * @return
    */
    boolean updateByPrimaryKey(Log log);

    /**
    * 根据id删除操作日志表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除操作日志表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}