package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Storage;
import com.haitaotao.mapper.StorageMapper;
import com.haitaotao.service.IStorageService;

/**
 * 文件存储表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class StorageServiceImpl implements IStorageService {

    @Autowired
    private StorageMapper mapper;

    @Override
    public Storage selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Storage> selectByPage(Storage storage, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Storage> list = mapper.selectByCondition(storage);
        return new PageInfo<>(list);
    }

    @Override
    public List<Storage> selectByCondition(Storage storage){
        return mapper.selectByCondition(storage);
    }

    @Override
    public boolean insert(Storage storage){
        return mapper.insertSelective(storage);
    }

    @Override
    public boolean updateByPrimaryKey(Storage storage){
        return mapper.updateByPrimaryKey(storage);
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
