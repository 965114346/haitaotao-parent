package com.haitaotao.mapper;

import com.haitaotao.entity.Category;

import java.util.List;

/**
 * 类目表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface CategoryMapper {

    /**
     * 根据父级查询列表
     * @param parentId 父级id
     * @return 子集品类列表
     */
    List<Category> listByParentId(Long parentId);

    /**
     * 根据等级获取品类列表
     * @param level 等级
     * @return 品类列表
     */
    List<Category> listByLevel(String level);

    /**
     * 添加品类
     * @param category 品类实体
     * @return 添加结果
     */
    boolean insert(Category category);

    /**
     * 更新品类信息
     * @param category 品类数据
     * @return 更新结果
     */
    boolean updateById(Category category);

    /**
     * 删除品类
     * @param id 品类id
     * @return 删除结果
     */
    boolean removeById(Long id);
}