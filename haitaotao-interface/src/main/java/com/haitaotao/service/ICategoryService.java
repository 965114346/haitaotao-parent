package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Category;

/**
 * 类目表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface ICategoryService {

    /**
     * 根据父级查询列表
     * @param parentId 父级id
     * @return 子集品类列表
     */
    PageInfo<Category> listByParentId(Integer pageNum, Integer pageSize, Long parentId);

    /**
     * 添加品类
     * @param category 品类实体
     * @return 添加结果
     */
    boolean add(Category category);

    /**
     * 删除品类
     * @param id 品类id
     * @return 删除结果
     */
    boolean removeById(Long id);

    /**
     * 更新品类信息
     * @param category 品类信息
     * @return 更新结果
     */
    boolean updateById(Category category);

    /**
     * 所有品类树形节点列表
     * @return
     */
    List<Category> listAll();

    /**
     * 根据id获取品类信息
     * @param id 品类id
     * @return
     */
    Category getById(Long id);
}
