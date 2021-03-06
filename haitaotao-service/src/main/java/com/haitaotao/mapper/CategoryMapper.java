package com.haitaotao.mapper;

import com.haitaotao.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类目表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
@Repository
public interface CategoryMapper {

    /**
     * 根据父级查询列表
     * @param parentId 父级id
     * @return 子集品类列表
     */
    List<Category> listByParentId(Long parentId);

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

    /**
     *
     * 根据id获取品类信息
     * @param id 品类id
     * @return
     */
    Category getById(Long id);
}