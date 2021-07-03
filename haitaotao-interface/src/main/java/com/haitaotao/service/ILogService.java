package com.haitaotao.service;

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
     * 分页查询操作日志表
     *
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    PageInfo<Log> pageList(Integer pageNum, Integer pageSize, String username);

    /**
     * 添加操作日志表
     *
     * @param log
     * @return
     */
    boolean add(Log log);
}
