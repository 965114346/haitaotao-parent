package com.haitaotao.service;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Ad;

/**
 * 广告表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:12
 */
public interface IAdService {

    /**
     * 分页查询广告
     *
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param title    标题
     * @param content  内容
     * @return
     */
    PageInfo<Ad> pageList(Integer pageNum, Integer pageSize, String title, String content);

    /**
     * 新增广告
     *
     * @param ad
     * @return
     */
    boolean add(Ad ad);

    /**
     * 更新广告
     *
     * @param ad
     * @return
     */
    boolean updateById(Ad ad);

    /**
     * 删除广告
     *
     * @param id 广告id
     * @return
     */
    boolean removeById(Long id);
}
