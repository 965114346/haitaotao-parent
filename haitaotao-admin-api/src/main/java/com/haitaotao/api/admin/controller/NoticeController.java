package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Notice;
import com.haitaotao.service.INoticeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyang
 * @date 2021/1/24 10:07
 */
@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    @DubboReference
    private INoticeService noticeService;

    @RequiresPermissions("admin:notice:list")
    @GetMapping("/list")
    private Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                        @RequestParam(defaultValue = "10") Integer pageSize){
        PageInfo<Notice> pageInfo = noticeService.pageList(pageNum, pageSize);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }
}
