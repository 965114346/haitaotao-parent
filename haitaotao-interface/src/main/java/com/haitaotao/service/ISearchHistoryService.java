package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.SearchHistory;

/**
 * 搜索历史表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface ISearchHistoryService {

    /**
     * 分页查询用户搜索历史列表
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @param userId 用户id
     * @param keyword 搜索关键字
     * @return 用户搜索历史列表
     */
    PageInfo<SearchHistory> pageList(Integer pageNum, Integer pageSize, Long userId, String keyword);
}
