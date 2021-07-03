package com.haitaotao.service;

import com.haitaotao.enums.GrouponEnum;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Groupon;
import com.haitaotao.mapper.GrouponMapper;

import java.util.List;

/**
 * 团购活动表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class GrouponServiceImpl implements IGrouponService {

    @Autowired
    private GrouponMapper grouponMapper;

    @Override
    public PageInfo<Groupon> pageList(Integer pageNum, Integer pageSize, Long ruleId) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> grouponMapper.listByCondition(ruleId));
    }

    @Override
    public List<Groupon> listByRulesId(Long grouponRuleId) {
        return grouponMapper.listByCondition(grouponRuleId);
    }

    @Override
    public boolean updateStatusFail(Long id) {
        Groupon update = new Groupon().setId(id).setStatus(GrouponEnum.STATUS_FAIL.getValue());
        return grouponMapper.updateById(update);
    }

    @Override
    public boolean add(Groupon groupon) {
        return grouponMapper.insert(groupon);
    }

    @Override
    public boolean updateById(Groupon groupon) {
        return grouponMapper.updateById(groupon);
    }

    @Override
    public boolean removeById(Long id) {
        return grouponMapper.removeById(id);
    }
}
