package com.haitaotao.api.admin.controller;

import com.haitaotao.api.admin.dto.CategoryCreateDTO;
import com.haitaotao.api.admin.dto.CategoryUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Category;
import com.haitaotao.service.ICategoryService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangyang
 * @date 2021/2/3 13:39
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @DubboReference
    private ICategoryService categoryService;

    @GetMapping("/listByParentId")
    public Object listByParentId(@RequestParam Long parentId) {
        List<Category> list = categoryService.listByParentId(parentId);
        return ResponseUtil.ok(list);
    }

    @GetMapping("/l1")
    public Object listL1() {
        List<Category> list = categoryService.listL1();
        return ResponseUtil.ok(list);
    }

    @PostMapping("/create")
    public Object create(@RequestBody CategoryCreateDTO dto) {
        Category category = new Category();
        BeanUtils.copyProperties(dto, category);
        boolean success = categoryService.add(category);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@RequestBody CategoryUpdateDTO dto) {
        Category category = new Category();
        BeanUtils.copyProperties(dto, category);
        boolean success = categoryService.updateById(category);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = categoryService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
