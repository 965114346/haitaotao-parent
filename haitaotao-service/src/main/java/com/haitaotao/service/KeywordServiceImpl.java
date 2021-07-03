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
    private KeywordMapper keywordMapper;

    @Override
    public Keyword selectById(Long id) {
        return keywordMapper.selectById(id);
    }

    @Override
    public PageInfo<Keyword> pageList(Integer pageNum, Integer pageSize, String keyword, String url){
        PageHelper.startPage(pageNum, pageSize);
        List<Keyword> list = keywordMapper.listByCondition(keyword, url);
        return new PageInfo<>(list);
    }

    @Override
    public boolean add(Keyword keyword){
        return keywordMapper.insert(keyword);
    }

    @Override
    public boolean updateById(Keyword keyword){
        return keywordMapper.updateById(keyword);
    }

    @Override
    public boolean removeById(Long id) {
        return keywordMapper.removeById(id);
    }

}
