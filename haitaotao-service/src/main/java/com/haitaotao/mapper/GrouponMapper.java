package com.haitaotao.mapper;

import com.haitaotao.entity.Groupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 团购活动表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface GrouponMapper {

    /**
     * 根据id查询团购活动表
     *
     * @param id
     * @return
     */
    Groupon getById(Long id);

    /**
     * 条件查询团购活动表列表
     *
     * @param rulesId 团购规则id
     * @return
     */
    List<Groupon> listByCondition(@Param("rulesId") Long rulesId);

    /**
     * 插入团购活动表
     *
     * @param groupon
     * @return
     */
    boolean insert(Groupon groupon);

    /**
     * 更新团购活动表
     *
     * @param groupon
     * @return
     */
    boolean updateById(Groupon groupon);

    /**
     * 根据id删除团购活动表
     *
     * @param id
     * @return
     */
    boolean removeById(Long id);
}