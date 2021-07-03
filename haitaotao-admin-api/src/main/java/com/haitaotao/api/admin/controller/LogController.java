package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Log;
import com.haitaotao.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyang
 * @date 2021/5/13 16:16
 */
@Slf4j
@RestController
@RequestMapping("/api/log")
public class LogController {

    @DubboReference
    private ILogService logService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String username) {
        PageInfo<Log> pageInfo = logService.pageList(pageNum, pageSize, username);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }
}
