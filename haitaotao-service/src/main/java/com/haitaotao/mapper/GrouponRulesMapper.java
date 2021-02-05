package com.haitaotao.mapper;

import com.haitaotao.entity.GrouponRules;

import java.util.List;

/**
 * 团购规则表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface GrouponRulesMapper {

    /**
    * 根据id查询团购规则表
    * @param id
    * @return
    */
    GrouponRules selectByPrimaryKey(Long id);

    /**
    * 条件查询团购规则表列表
    * @param grouponRules
    * @return
    */
    List<GrouponRules> selectByCondition(GrouponRules grouponRules);

    /**
    * 插入团购规则表
    * @param grouponRules
    * @return
    */
    boolean insertSelective(GrouponRules grouponRules);

    /**
    * 更新团购规则表
    * @param grouponRules
    * @return
    */
    boolean updateByPrimaryKey(GrouponRules grouponRules);

    /**
    * 根据id删除团购规则表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除团购规则表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}