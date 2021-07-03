package com.haitaotao.api.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.service.SystemConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * 配置管理
 * @author yangyang
 * @date 2021/6/29 11:15
 */
@Slf4j
@RestController
@RequestMapping("/api/system/config")
public class SystemConfigController {

    @DubboReference
    private SystemConfigService systemConfigService;

    @GetMapping("/{configName}")
    public Object getByConfigName(@PathVariable String configName) {
        return ResponseUtil.ok(systemConfigService.get(null, configName));
    }

    @PostMapping("/{configName}/update")
    public Object update(@PathVariable String configName, @RequestBody JSONObject jsonObject) {
        return ResponseUtil.ok(systemConfigService.updateById(jsonObject, configName));
    }
}
