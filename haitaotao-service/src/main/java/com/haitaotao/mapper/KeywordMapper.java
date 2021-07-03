package com.haitaotao.mapper;

import com.haitaotao.entity.Keyword;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 关键字表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface KeywordMapper {

    /**
     * 根据id查询关键字表
     *
     * @param id
     * @return
     */
    Keyword selectById(Long id);

    /**
     * 条件查询关键字表列表
     *
     * @param keyword 关键字
     * @param url     跳转链接
     * @return
     */
    List<Keyword> listByCondition(@Param("keyword") String keyword, @Param("url") String url);

    /**
     * 插入关键字表
     *
     * @param keyword
     * @return
     */
    boolean insert(Keyword keyword);

    /**
     * 更新关键字表
     *
     * @param keyword
     * @return
     */
    boolean updateById(Keyword keyword);

    /**
     * 根据id删除关键字表
     *
     * @param id
     * @return
     */
    boolean removeById(Long id);
}