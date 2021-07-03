package com.haitaotao.api.admin.controller;

import com.haitaotao.service.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyang
 * @date 2021/5/13 11:45
 */
@Slf4j
@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @DubboReference
    private IPermissionService permissionService;


}
