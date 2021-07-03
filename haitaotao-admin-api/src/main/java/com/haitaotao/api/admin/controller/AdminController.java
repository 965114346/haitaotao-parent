package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.AdminCreateDTO;
import com.haitaotao.api.admin.dto.AdminUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Admin;
import com.haitaotao.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author yangyang
 * @date 2021/5/13 9:44
 */
@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @DubboReference
    private IAdminService adminService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String username) {
        PageInfo<Admin> pageInfo = adminService.pageList(pageNum, pageSize, username);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody AdminCreateDTO dto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(dto, admin);
        boolean success = adminService.add(admin);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody AdminUpdateDTO dto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(dto, admin);

        boolean success = adminService.updateById(admin);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = adminService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
