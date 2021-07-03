package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.GoodsCreateDTO;
import com.haitaotao.api.admin.dto.GoodsUpdateDTO;
import com.haitaotao.api.admin.vo.GoodsDetailVO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.*;
import com.haitaotao.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yangyang
 * @date 2021/4/10 13:58
 */
@Slf4j
@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    
    @DubboReference
    private IGoodsService goodsService;

    @DubboReference
    private IGoodsProductService goodsProductService;

    @DubboReference
    private IGoodsSpecificationService goodsSpecificationService;

    @DubboReference
    private IGoodsAttributeService goodsAttributeService;

    @DubboReference
    private ICategoryService categoryService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Long id,
                       String goodsNo,
                       String name) {
        PageInfo<Goods> pageInfo = goodsService.pageList(pageNum, pageSize, id, goodsNo, name);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/detail")
    public Object detail(@RequestParam Long id) {
        Goods goods = goodsService.getById(id);
        List<GoodsProduct> products = goodsProductService.listByGoodsId(id);
        List<GoodsSpecification> specifications = goodsSpecificationService.listByGoodsId(id);
        List<GoodsAttribute> attributes = goodsAttributeService.listByGoodsId(id);

        List<Long> categoryIds = new ArrayList<>();
        if (Objects.nonNull(goods) && Objects.nonNull(goods.getCategoryId())) {
            Category category = categoryService.getById(goods.getCategoryId());
            categoryIds.add(category.getParentId());
            categoryIds.add(category.getId());
        }
        return ResponseUtil.ok(new GoodsDetailVO(goods, products, attributes, specifications, categoryIds));
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody GoodsCreateDTO dto) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(dto, goods);
        boolean success = goodsService.add(goods);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody GoodsUpdateDTO dto) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(dto, goods);

        boolean success = goodsService.updateById(goods);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = goodsService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
