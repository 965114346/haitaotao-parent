package com.haitaotao.service;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Brand;

/**
 * 品牌商表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:12
 */
public interface IBrandService {

    /**
     * 品牌商分页列表
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @param id 品牌id
     * @param name 品牌名称
     * @return 品牌列表
     */
    PageInfo<Brand> pageList(Integer pageNum, Integer pageSize, Long id, String name);

    /**
     * 添加品牌商
     * @param brand 品牌商数据
     * @return 添加结果
     */
    boolean add(Brand brand);

    /**
     * 更新品牌商
     * @param brand 品牌商数据
     * @return 更新结果
     */
    boolean updateById(Brand brand);

    /**
     * 商城品牌商
     * @param id 品牌商id
     * @return 移除结果
     */
    boolean removeById(Long id);
}
