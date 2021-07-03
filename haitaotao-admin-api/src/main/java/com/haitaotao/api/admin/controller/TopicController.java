package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.TopicCreateDTO;
import com.haitaotao.api.admin.dto.TopicUpdateDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Topic;
import com.haitaotao.service.ITopicService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author yangyang
 * @date 2021/4/28 11:05
 */
@Slf4j
@RestController
@RequestMapping("/api/topic")
public class TopicController {

    @DubboReference
    private ITopicService topicService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String title,
                       String subtitle) {
        PageInfo<Topic> pageInfo = topicService.pageList(pageNum, pageSize, title, subtitle);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/detail")
    public Object detail(@RequestParam Long id) {
        return ResponseUtil.ok(topicService.getById(id));
    }

    @PostMapping("/create")
    public Object create(@Valid @RequestBody TopicCreateDTO dto) {
        Topic topic = new Topic();
        BeanUtils.copyProperties(dto, topic);
        boolean success = topicService.add(topic);
        return success ? ResponseUtil.ok() : ResponseUtil.error("添加失败");
    }

    @PostMapping("/update")
    public Object update(@Valid @RequestBody TopicUpdateDTO dto) {
        Topic topic = new Topic();
        BeanUtils.copyProperties(dto, topic);

        boolean success = topicService.updateById(topic);
        return success ? ResponseUtil.ok() : ResponseUtil.error("更新失败");
    }

    @PostMapping("/remove/{id}")
    public Object removeById(@PathVariable Long id) {
        boolean success = topicService.removeById(id);
        return success ? ResponseUtil.ok() : ResponseUtil.error("删除失败");
    }
}
