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
import com.haitaotao.service.IIssueService;

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
    private IssueMapper mapper;

    @Override
    public Issue selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Issue> selectByPage(Issue issue, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Issue> list = mapper.selectByCondition(issue);
        return new PageInfo<>(list);
    }

    @Override
    public List<Issue> selectByCondition(Issue issue){
        return mapper.selectByCondition(issue);
    }

    @Override
    public boolean insert(Issue issue){
        return mapper.insertSelective(issue);
    }

    @Override
    public boolean updateByPrimaryKey(Issue issue){
        return mapper.updateByPrimaryKey(issue);
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean batchDeleteByPrimaryKey(List<Long> ids) {
        return mapper.batchDeleteByPrimaryKey(ids);
    }

}
