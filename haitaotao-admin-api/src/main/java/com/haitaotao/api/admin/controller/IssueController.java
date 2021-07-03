package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.IssueCreateDTO;
import com.haitaotao.api.admin.dto.IssueUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Issue;
import com.haitaotao.service.IIssueService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author yangyang
 * @date 2021/4/9 16:11
 */
@Slf4j
@RestController
@RequestMapping("/api/issue")
public class IssueController {

    @DubboReference
    private IIssueService issueService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String question) {
        PageInfo<Issue> pageInfo = issueService.pageList(pageNum, pageSize, question);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody IssueCreateDTO dto) {
        Issue issue = new Issue();
        BeanUtils.copyProperties(dto, issue);
        boolean success = issueService.add(issue);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody IssueUpdateDTO dto) {
        Issue issue = new Issue();
        BeanUtils.copyProperties(dto, issue);

        boolean success = issueService.updateById(issue);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = issueService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
