package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.SearchHistory;
import com.haitaotao.mapper.SearchHistoryMapper;
import com.haitaotao.service.ISearchHistoryService;

/**
 * 搜索历史表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class SearchHistoryServiceImpl implements ISearchHistoryService {

    @Autowired
    private SearchHistoryMapper searchHistoryMapper;

    @Override
    public PageInfo<SearchHistory> pageList(Integer pageNum, Integer pageSize, Long userId, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<SearchHistory> list = searchHistoryMapper.listByCondition(userId, keyword);
        return PageInfo.of(list);
    }

}
