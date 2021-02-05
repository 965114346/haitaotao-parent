package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.BrandCreateDTO;
import com.haitaotao.api.admin.dto.BrandUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Brand;
import com.haitaotao.service.IBrandService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 品牌
 * @author yangyang
 * @date 2021/1/27 19:22
 */
@RestController
@RequestMapping("/api/brand")
public class BrandController {

    @DubboReference
    private IBrandService brandService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Long id,
                       String name) {
        PageInfo<Brand> pageInfo = brandService.pageList(pageNum, pageSize, id, name);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody BrandCreateDTO dto) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(dto, brand);
        boolean success = brandService.add(brand);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody BrandUpdateDTO dto) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(dto, brand);

        boolean success = brandService.updateById(brand);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = brandService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
