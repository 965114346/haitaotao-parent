package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Issue;
import com.haitaotao.mapper.IssueMapper;

/**
 * 常见问题表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class IssueServiceImpl implements IIssueService {

    @Autowired
    private IssueMapper issueMapper;

    @Override
    public Issue selectById(Long id) {
        return issueMapper.selectById(id);
    }

    @Override
    public PageInfo<Issue> pageList(Integer pageNum, Integer pageSize, String question) {
        PageHelper.startPage(pageNum, pageSize);
        List<Issue> list = issueMapper.listByCondition(question);
        return PageInfo.of(list);
    }

    @Override
    public boolean add(Issue issue){
        return issueMapper.insert(issue);
    }

    @Override
    public boolean updateById(Issue issue){
        return issueMapper.updateById(issue);
    }

    @Override
    public boolean removeById(Long id) {
        return issueMapper.removeById(id);
    }

}
