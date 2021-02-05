package com.haitaotao.mapper;

import com.haitaotao.entity.SearchHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索历史表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface SearchHistoryMapper {

    /**
     * 条件查询用户搜索历史列表
     * @param userId 用户id
     * @param keyword 搜索关键字
     * @return 用户搜索历史列表
     */
    List<SearchHistory> listByCondition(@Param("userId") Long userId, @Param("keyword") String keyword);
}