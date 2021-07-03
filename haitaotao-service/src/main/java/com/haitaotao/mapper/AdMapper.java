package com.haitaotao.mapper;

import com.haitaotao.entity.Ad;
import org.apache.ibatis.annotations.Param;

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
     *
     * @param id
     * @return
     */
    Ad getById(Long id);

    /**
     * 条件查询广告表列表
     *
     * @param name   标题
     * @param content 内容
     * @return
     */
    List<Ad> listByCondition(@Param("name") String name, @Param("content") String content);

    /**
     * 插入广告表
     *
     * @param ad
     * @return
     */
    boolean insert(Ad ad);

    /**
     * 更新广告表
     *
     * @param ad
     * @return
     */
    boolean updateById(Ad ad);

    /**
     * 根据id删除广告表
     *
     * @param id
     * @return
     */
    boolean removeById(Long id);
}