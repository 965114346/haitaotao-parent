package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.KeywordCreateDTO;
import com.haitaotao.api.admin.dto.KeywordUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Keyword;
import com.haitaotao.service.IKeywordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author yangyang
 * @date 2021/4/10 9:24
 */
@Slf4j
@RestController
@RequestMapping("/api/keyword")
public class KeywordController {

    @DubboReference
    private IKeywordService keywordService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String keyword,
                       String url) {
        PageInfo<Keyword> pageInfo = keywordService.pageList(pageNum, pageSize, keyword, url);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody KeywordCreateDTO dto) {
        Keyword keyword = new Keyword();
        BeanUtils.copyProperties(dto, keyword);
        boolean success = keywordService.add(keyword);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody KeywordUpdateDTO dto) {
        Keyword keyword = new Keyword();
        BeanUtils.copyProperties(dto, keyword);

        boolean success = keywordService.updateById(keyword);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = keywordService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
