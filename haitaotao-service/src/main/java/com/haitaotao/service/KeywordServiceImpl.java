package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Keyword;
import com.haitaotao.mapper.KeywordMapper;
import com.haitaotao.service.IKeywordService;

/**
 * 关键字表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class KeywordServiceImpl implements IKeywordService {

    @Autowired
    private KeywordMapper mapper;

    @Override
    public Keyword selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Keyword> selectByPage(Keyword keyword, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Keyword> list = mapper.selectByCondition(keyword);
        return new PageInfo<>(list);
    }

    @Override
    public List<Keyword> selectByCondition(Keyword keyword){
        return mapper.selectByCondition(keyword);
    }

    @Override
    public boolean insert(Keyword keyword){
        return mapper.insertSelective(keyword);
    }

    @Override
    public boolean updateByPrimaryKey(Keyword keyword){
        return mapper.updateByPrimaryKey(keyword);
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
