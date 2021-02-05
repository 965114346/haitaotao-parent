package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Log;
import com.haitaotao.mapper.LogMapper;
import com.haitaotao.service.ILogService;

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
    private LogMapper mapper;

    @Override
    public Log selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Log> selectByPage(Log log, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Log> list = mapper.selectByCondition(log);
        return new PageInfo<>(list);
    }

    @Override
    public List<Log> selectByCondition(Log log){
        return mapper.selectByCondition(log);
    }

    @Override
    public boolean insert(Log log){
        return mapper.insertSelective(log);
    }

    @Override
    public boolean updateByPrimaryKey(Log log){
        return mapper.updateByPrimaryKey(log);
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean batchDeleteByPrimaryKey(List<Long> ids) {
        return mapper.batchDeleteByPrimaryKey(ids);
    }

}
