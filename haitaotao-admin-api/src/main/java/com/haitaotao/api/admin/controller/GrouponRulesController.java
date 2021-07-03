package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.GrouponRulesCreateDTO;
import com.haitaotao.api.admin.dto.GrouponRulesUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.GrouponRules;
import com.haitaotao.service.IGrouponRulesService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 团购规则
 * @author yangyang
 * @date 2021/4/29 16:17
 */
@RestController
@RequestMapping("/api/groupon/rules")
public class GrouponRulesController {

    @DubboReference
    private IGrouponRulesService grouponRulesService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Long goodsId) {
        PageInfo<GrouponRules> pageInfo = grouponRulesService.pageList(pageNum, pageSize, goodsId);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody GrouponRulesCreateDTO dto) {
        GrouponRules grouponRules = new GrouponRules();
        BeanUtils.copyProperties(dto, grouponRules);
        boolean success = grouponRulesService.add(grouponRules);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody GrouponRulesUpdateDTO dto) {
        GrouponRules grouponRules = new GrouponRules();
        BeanUtils.copyProperties(dto, grouponRules);

        boolean success = grouponRulesService.updateById(grouponRules);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = grouponRulesService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
