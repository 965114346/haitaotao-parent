package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Category;
import com.haitaotao.mapper.CategoryMapper;
import com.haitaotao.service.ICategoryService;

/**
 * 类目表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> listAll() {
        List<Category> list = categoryMapper.listByParentId(0L);
        for (Category category : list) {
            treeList(category);
        }
        return list;
    }

    @Override
    public Category getById(Long id) {
        return categoryMapper.getById(id);
    }

    @Override
    public PageInfo<Category> listByParentId(Integer pageNum, Integer pageSize, Long parentId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> list = categoryMapper.listByParentId(parentId);
        return PageInfo.of(list);
    }

    @Override
    public boolean add(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public boolean updateById(Category category) {
        return categoryMapper.updateById(category);
    }

    @Override
    public boolean removeById(Long id) {
        return categoryMapper.removeById(id);
    }

    private void treeList(Category category) {
        if (!category.isHasChildren()) {
            return;
        }

        List<Category> children = categoryMapper.listByParentId(category.getId());
        category.setChildren(children);

        for (Category child : children) {
            treeList(child);
        }
    }
}
