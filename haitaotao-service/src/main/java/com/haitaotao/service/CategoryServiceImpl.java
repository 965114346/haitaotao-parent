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
    public List<Category> listByParentId(Long parentId) {
        return categoryMapper.listByParentId(parentId);
    }

    @Override
    public List<Category> listL1() {
        return categoryMapper.listByLevel("L1");
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
}
