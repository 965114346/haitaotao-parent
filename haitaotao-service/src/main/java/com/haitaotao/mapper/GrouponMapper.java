package com.haitaotao.mapper;

import com.haitaotao.entity.Groupon;

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
    * @param id
    * @return
    */
    Groupon selectByPrimaryKey(Long id);

    /**
    * 条件查询团购活动表列表
    * @param groupon
    * @return
    */
    List<Groupon> selectByCondition(Groupon groupon);

    /**
    * 插入团购活动表
    * @param groupon
    * @return
    */
    boolean insertSelective(Groupon groupon);

    /**
    * 更新团购活动表
    * @param groupon
    * @return
    */
    boolean updateByPrimaryKey(Groupon groupon);

    /**
    * 根据id删除团购活动表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除团购活动表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}