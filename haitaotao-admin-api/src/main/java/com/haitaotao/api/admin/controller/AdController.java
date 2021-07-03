package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.AdCreateDTO;
import com.haitaotao.api.admin.dto.AdUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Ad;
import com.haitaotao.service.IAdService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 广告相关
 * @author yangyang
 * @date 2021/4/26 16:15
 */
@Slf4j
@RestController
@RequestMapping("/api/ad")
public class AdController {

    @DubboReference
    private IAdService adService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       String content) {
        PageInfo<Ad> pageInfo = adService.pageList(pageNum, pageSize, name, content);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody AdCreateDTO dto) {
        Ad ad = new Ad();
        BeanUtils.copyProperties(dto, ad);
        boolean success = adService.add(ad);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody AdUpdateDTO dto) {
        Ad ad = new Ad();
        BeanUtils.copyProperties(dto, ad);

        boolean success = adService.updateById(ad);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = adService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
