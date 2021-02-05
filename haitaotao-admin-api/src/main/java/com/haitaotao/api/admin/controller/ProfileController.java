package com.haitaotao.api.admin.controller;

import com.haitaotao.api.admin.annotations.CurrentAdmin;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Admin;
import com.haitaotao.service.INoticeAdminService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyang
 * @date 2021/1/24 10:09
 */
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @DubboReference
    private INoticeAdminService noticeAdminService;

    @GetMapping("/notice")
    public Object notice(@CurrentAdmin Admin admin) {
        int count = noticeAdminService.countUnread(admin.getId());
        return ResponseUtil.ok(count);
    }
}
