package com.haitaotao.service;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.GrouponRules;

import java.util.List;

/**
 * 团购规则表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IGrouponRulesService {

    /**
     * 根据规则id获取团购规则
     * @param id 团购规则id
     * @return {@link GrouponRules}
     */
    GrouponRules getById(Long id);

    /**
     * 分页查询团购规则
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param goodsId 商品Id
     * @return {@link GrouponRules}
     */
    PageInfo<GrouponRules> pageList(Integer pageNum, Integer pageSize, Long goodsId);

    /**
     * 新增团购规则
     * @param grouponRules {@link GrouponRules}
     * @return
     */
    boolean add(GrouponRules grouponRules);

    /**
     * 更新团购规则
     * @param grouponRules
     * @return
     */
    boolean updateById(GrouponRules grouponRules);

    /**
     * 更新团购规则状态
     * @param id 团购规则id
     * @param status 需要更新的团购状态
     * @return
     */
    boolean updateStatusById(Long id, Integer status);

    /**
     * 删除团购规则
     * @param id
     * @return
     */
    boolean removeById(Long id);

    /**
     * 正常上线的团购规则
     * @return {@link GrouponRules}
     */
    List<GrouponRules> listStatusOn();
}
