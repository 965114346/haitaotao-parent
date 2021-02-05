package com.haitaotao.mapper;

import com.haitaotao.entity.Ad;

import java.util.List;

/**
 * 广告表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface AdMapper {

    /**
    * 根据id查询广告表
    * @param id
    * @return
    */
    Ad selectByPrimaryKey(Long id);

    /**
    * 条件查询广告表列表
    * @param ad
    * @return
    */
    List<Ad> selectByCondition(Ad ad);

    /**
    * 插入广告表
    * @param ad
    * @return
    */
    boolean insertSelective(Ad ad);

    /**
    * 更新广告表
    * @param ad
    * @return
    */
    boolean updateByPrimaryKey(Ad ad);

    /**
    * 根据id删除广告表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除广告表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}