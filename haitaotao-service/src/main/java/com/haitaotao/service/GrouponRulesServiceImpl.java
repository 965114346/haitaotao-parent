package com.haitaotao.service;

import java.util.List;
import java.util.Objects;

import com.haitaotao.entity.Goods;
import com.haitaotao.mapper.GoodsMapper;
import com.haitaotao.task.DelayTaskService;
import com.haitaotao.task.GrouponRuleExpiredTask;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.GrouponRules;
import com.haitaotao.mapper.GrouponRulesMapper;

/**
 * 团购规则表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class GrouponRulesServiceImpl implements IGrouponRulesService {

    @Autowired
    private GrouponRulesMapper grouponRulesMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private DelayTaskService delayTaskService;

    @Override
    public GrouponRules getById(Long id) {
        return grouponRulesMapper.getById(id);
    }

    @Override
    public PageInfo<GrouponRules> pageList(Integer pageNum, Integer pageSize, Long goodsId) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> grouponRulesMapper.listByCondition(goodsId));
    }

    @Override
    public List<GrouponRules> listStatusOn() {
        return grouponRulesMapper.listStatusOn();
    }

    @Override
    public boolean add(GrouponRules grouponRules) {
        // 检查商品是否存在
        Goods goods = checkAndGetGoods(grouponRules.getGoodsId());

        GrouponRules rules = grouponRulesMapper.getByGoodsId(grouponRules.getGoodsId());
        if (Objects.nonNull(rules)) {
            throw new RuntimeException("团购商品已经存在");
        }

        grouponRules.setGoodsName(goods.getName());
        grouponRules.setPicUrl(goods.getPicUrl());

        boolean success = grouponRulesMapper.insert(grouponRules);

        if (success) {
            // 团购过期任务
            long delay = grouponRules.getExpireTime().getTime() - System.currentTimeMillis();
            delayTaskService.addTask(new GrouponRuleExpiredTask(grouponRules.getId(), delay));
        }
        return success;
    }

    @Override
    public boolean updateById(GrouponRules grouponRules) {
        // 检查商品是否存在
        Goods goods = checkAndGetGoods(grouponRules.getGoodsId());

        GrouponRules rules = grouponRulesMapper.getByGoodsId(grouponRules.getGoodsId());
        if (Objects.nonNull(rules) && !Objects.equals(rules.getId(), grouponRules.getId())) {
            throw new RuntimeException("团购商品已经存在");
        }

        grouponRules.setGoodsName(goods.getName());
        grouponRules.setPicUrl(goods.getPicUrl());
        return grouponRulesMapper.updateById(grouponRules);
    }

    @Override
    public boolean updateStatusById(Long id, Integer status) {
        GrouponRules updated = new GrouponRules().setId(id).setStatus(status);
        return grouponRulesMapper.updateById(updated);
    }

    @Override
    public boolean removeById(Long id) {
        return grouponRulesMapper.removeById(id);
    }

    /**
     * 检查商品是否存在
     * @param goodsId 商品id
     */
    private Goods checkAndGetGoods(Long goodsId) throws RuntimeException {
        Goods goods = goodsMapper.getById(goodsId);
        if (Objects.isNull(goods)) {
            throw new RuntimeException("团购商品不存在");
        }

        return goods;
    }
}
