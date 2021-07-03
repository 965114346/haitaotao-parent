package com.haitaotao.mapper;

import com.haitaotao.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作日志表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface LogMapper {

    /**
    * 条件查询操作日志表列表
    * @param username 管理员名称
    * @return
    */
    List<Log> listByCondition(@Param("username") String username);

    /**
    * 插入操作日志表
    * @param log
    * @return
    */
    boolean insert(Log log);
}