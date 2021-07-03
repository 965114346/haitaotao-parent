package com.haitaotao.mapper;

import com.haitaotao.entity.GrouponRules;
import org.apache.ibatis.annotations.Param;

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
     *
     * @param id
     * @return
     */
    GrouponRules getById(Long id);

    /**
     * 根据商品id查询团购规则表
     * @param goodsId 商品id
     * @return
     */
    GrouponRules getByGoodsId(@Param("goodsId") Long goodsId);

    /**
     * 条件查询团购规则表列表
     *
     * @param goodsNo 商品编码
     * @return
     */
    List<GrouponRules> listByCondition(@Param("goodsId") Long goodsNo);

    /**
     * 插入团购规则表
     *
     * @param grouponRules
     * @return
     */
    boolean insert(GrouponRules grouponRules);

    /**
     * 更新团购规则表
     *
     * @param grouponRules
     * @return
     */
    boolean updateById(GrouponRules grouponRules);

    /**
     * 根据id删除团购规则表
     *
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