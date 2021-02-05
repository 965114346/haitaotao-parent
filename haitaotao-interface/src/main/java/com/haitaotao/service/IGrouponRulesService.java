package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.GrouponRules;

/**
 * 团购规则表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IGrouponRulesService {

    /**
    * 根据id查询团购规则表
    * @param id
    * @return
    */
    GrouponRules selectByPrimaryKey(Long id);

    /**
    * 分页查询团购规则表
    * @param grouponRules
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<GrouponRules> selectByPage(GrouponRules grouponRules, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询团购规则表
    * @param grouponRules
    * @return
    */
    List<GrouponRules> selectByCondition(GrouponRules grouponRules);

    /**
    * 添加团购规则表
    * @param grouponRules
    * @return
    */
    boolean insert(GrouponRules grouponRules);

    /**
    * 根据id更新团购规则表
    * @param grouponRules
    * @return
    */
    boolean updateByPrimaryKey(GrouponRules grouponRules);

    /**
    * 单个删除团购规则表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除团购规则表(也可单个删除团购规则表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
