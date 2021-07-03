package com.haitaotao.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Log;
import com.haitaotao.mapper.LogMapper;

/**
 * 操作日志表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class LogServiceImpl implements ILogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public PageInfo<Log> pageList(Integer pageNum, Integer pageSize, String username) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> logMapper.listByCondition(username));
    }

    @Override
    public boolean add(Log log) {
        return false;
    }
}
