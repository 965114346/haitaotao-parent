package com.haitaotao.api.admin.controller;

import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Region;
import com.haitaotao.service.IRegionService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangyang
 * @date 2021/1/25 16:36
 */
@RestController
@RequestMapping("/api/region")
public class RegionController {

    @DubboReference
    private IRegionService regionService;

    @GetMapping("/listByParentId")
    public Object listByParentId(@RequestParam Long parentId) {
        List<Region> list = regionService.listByParentId(parentId);
        return ResponseUtil.ok(list);
    }
}
