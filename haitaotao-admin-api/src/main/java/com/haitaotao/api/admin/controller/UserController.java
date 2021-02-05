package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.UserUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.*;
import com.haitaotao.service.*;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author yangyang
 * @date 2021/1/24 16:03
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @DubboReference
    private IUserService userService;

    @DubboReference
    private ICollectService collectService;

    @DubboReference
    private IAddressService addressService;

    @DubboReference
    private IFeedbackService feedbackService;

    @DubboReference
    private IFootprintService footprintService;

    @DubboReference
    private ISearchHistoryService searchHistoryService;

    @RequiresPermissions("admin:user:list")
    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @RequestParam(required = false) String username,
                       @RequestParam(required = false) Long userId,
                       @RequestParam(required = false) String mobile) {
        PageInfo<User> pageInfo = userService.pageList(pageNum, pageSize, username, userId, mobile);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequiresPermissions("admin:user:update")
    @PostMapping("/update")
    public Object update(@Valid @RequestBody UserUpdateDTO dto) {
        User updateObject = new User();
        BeanUtils.copyProperties(dto, updateObject);
        boolean success = userService.updateById(updateObject);
        return success ? ResponseUtil.ok() : ResponseUtil.updateFail();
    }

    @GetMapping("/collect/list")
    public Object collectList(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(required = false) Long userId,
                              @RequestParam(required = false) Long valueId) {
        PageInfo<Collect> pageInfo = collectService.pageList(pageNum, pageSize, userId, valueId);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/address/list")
    public Object addressList(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(required = false) Long userId,
                              @RequestParam(required = false) String name) {
        PageInfo<Address> pageInfo = addressService.pageList(pageNum, pageSize, userId, name);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/feedback/list")
    public Object feedbackList(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(required = false) String username,
                               @RequestParam(required = false) Long id) {
        PageInfo<Feedback> pageInfo = feedbackService.pageList(pageNum, pageSize, username, id);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/footprint/list")
    public Object footprintList(@RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(required = false) Long userId,
                                @RequestParam(required = false) Long goodsId) {
        PageInfo<Footprint> pageInfo = footprintService.pageList(pageNum, pageSize, userId, goodsId);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/searchHistory/list")
    public Object searchHistoryList(@RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(required = false) Long userId,
                                @RequestParam(required = false) String keyword) {
        PageInfo<SearchHistory> pageInfo = searchHistoryService.pageList(pageNum, pageSize, userId, keyword);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }
}
