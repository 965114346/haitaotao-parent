package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Groupon;

/**
 * 团购活动表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IGrouponService {

    /**
    * 根据id查询团购活动表
    * @param id
    * @return
    */
    Groupon selectByPrimaryKey(Long id);

    /**
    * 分页查询团购活动表
    * @param groupon
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Groupon> selectByPage(Groupon groupon, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询团购活动表
    * @param groupon
    * @return
    */
    List<Groupon> selectByCondition(Groupon groupon);

    /**
    * 添加团购活动表
    * @param groupon
    * @return
    */
    boolean insert(Groupon groupon);

    /**
    * 根据id更新团购活动表
    * @param groupon
    * @return
    */
    boolean updateByPrimaryKey(Groupon groupon);

    /**
    * 单个删除团购活动表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除团购活动表(也可单个删除团购活动表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
