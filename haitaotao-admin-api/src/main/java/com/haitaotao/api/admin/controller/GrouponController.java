package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.GrouponCreateDTO;
import com.haitaotao.api.admin.dto.GrouponUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Groupon;
import com.haitaotao.service.IGrouponService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 团购活动
 * @author yangyang
 * @date 2021/4/29 16:14
 */
@RestController
@RequestMapping("/api/groupon")
public class GrouponController {

    @DubboReference
    private IGrouponService grouponService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Long grouponRuleId) {
        PageInfo<Groupon> pageInfo = grouponService.pageList(pageNum, pageSize, grouponRuleId);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody GrouponCreateDTO dto) {
        Groupon groupon = new Groupon();
        BeanUtils.copyProperties(dto, groupon);
        boolean success = grouponService.add(groupon);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody GrouponUpdateDTO dto) {
        Groupon groupon = new Groupon();
        BeanUtils.copyProperties(dto, groupon);

        boolean success = grouponService.updateById(groupon);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = grouponService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
