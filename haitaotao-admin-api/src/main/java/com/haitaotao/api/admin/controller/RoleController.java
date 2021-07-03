package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.RoleCreateDTO;
import com.haitaotao.api.admin.dto.RoleUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Role;
import com.haitaotao.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author yangyang
 * @date 2021/5/13 11:08
 */
@Slf4j
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @DubboReference
    private IRoleService roleService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name) {
        PageInfo<Role> pageInfo = roleService.pageList(pageNum, pageSize, name);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody RoleCreateDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        boolean success = roleService.add(role);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody RoleUpdateDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);

        boolean success = roleService.updateById(role);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = roleService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
