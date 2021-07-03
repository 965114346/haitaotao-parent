package com.haitaotao.service;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Groupon;

import java.util.List;

/**
 * 团购活动表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IGrouponService {

    /**
     * 分页查询团购活动
     *
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param grouponRuleId 团购规则id
     * @return {@link Groupon}
     */
    PageInfo<Groupon> pageList(Integer pageNum, Integer pageSize, Long grouponRuleId);

    /**
     * 根据团购规则查询团购活动列表
     * @param grouponRuleId 团购规则id
     * @return {@link Groupon}
     */
    List<Groupon> listByRulesId(Long grouponRuleId);

    /**
     * 更新团购活动状态失败
     * @param id 团购活动id
     * @return
     */
    boolean updateStatusFail(Long id);

    /**
     * 新增团购活动
     * @param groupon
     * @return
     */
    boolean add(Groupon groupon);

    /**
     * 更新团购活动
     * @param groupon
     * @return
     */
    boolean updateById(Groupon groupon);

    /**
     * 删除团购活动
     * @param id 团购活动id
     * @return
     */
    boolean removeById(Long id);
}
