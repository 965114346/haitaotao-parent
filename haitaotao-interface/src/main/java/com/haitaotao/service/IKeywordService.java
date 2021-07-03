package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Keyword;

/**
 * 关键字表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IKeywordService {

    /**
     * 根据id查询关键字表
     *
     * @param id
     * @return
     */
    Keyword selectById(Long id);

    /**
     * 分页查询关键字表
     *
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param keyword 关键字
     * @param url 跳转链接
     * @return
     */
    PageInfo<Keyword> pageList(Integer pageNum, Integer pageSize, String keyword, String url);

    /**
     * 添加关键字表
     *
     * @param keyword
     * @return
     */
    boolean add(Keyword keyword);

    /**
     * 根据id更新关键字表
     *
     * @param keyword
     * @return
     */
    boolean updateById(Keyword keyword);

    /**
     * 单个删除关键字表
     *
     * @param id
     * @return
     */
    boolean removeById(Long id);
}
