package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Ad;

/**
 * 广告表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:12
 */
public interface IAdService {

    /**
    * 根据id查询广告表
    * @param id
    * @return
    */
    Ad selectByPrimaryKey(Long id);

    /**
    * 分页查询广告表
    * @param ad
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Ad> selectByPage(Ad ad, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询广告表
    * @param ad
    * @return
    */
    List<Ad> selectByCondition(Ad ad);

    /**
    * 添加广告表
    * @param ad
    * @return
    */
    boolean insert(Ad ad);

    /**
    * 根据id更新广告表
    * @param ad
    * @return
    */
    boolean updateByPrimaryKey(Ad ad);

    /**
    * 单个删除广告表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除广告表(也可单个删除广告表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
