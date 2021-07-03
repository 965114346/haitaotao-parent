package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.CommentReplyDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Comment;
import com.haitaotao.service.ICommentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author yangyang
 * @date 2021/4/26 14:49
 */
@Slf4j
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @DubboReference
    private ICommentService commentService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @RequestParam Integer type,
                       Long userId,
                       Long valueId) {
        PageInfo<Comment> pageInfo = commentService.pageList(pageNum, pageSize, userId, type, valueId);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping("/reply")
    public Object update(@Valid @RequestBody CommentReplyDTO dto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(dto, comment);

        boolean success = commentService.updateById(comment);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = commentService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
