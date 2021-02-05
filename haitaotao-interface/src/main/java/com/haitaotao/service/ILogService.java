package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Log;

/**
 * 操作日志表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface ILogService {

    /**
    * 根据id查询操作日志表
    * @param id
    * @return
    */
    Log selectByPrimaryKey(Long id);

    /**
    * 分页查询操作日志表
    * @param log
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Log> selectByPage(Log log, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询操作日志表
    * @param log
    * @return
    */
    List<Log> selectByCondition(Log log);

    /**
    * 添加操作日志表
    * @param log
    * @return
    */
    boolean insert(Log log);

    /**
    * 根据id更新操作日志表
    * @param log
    * @return
    */
    boolean updateByPrimaryKey(Log log);

    /**
    * 单个删除操作日志表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除操作日志表(也可单个删除操作日志表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
