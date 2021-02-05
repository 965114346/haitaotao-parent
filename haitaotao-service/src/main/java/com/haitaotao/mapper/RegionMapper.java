package com.haitaotao.mapper;

import com.haitaotao.entity.Region;

import java.util.List;

/**
 * 行政区域表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface RegionMapper {

    /**
     * 根据父级区域id查询行政区域列表， parent_id等于0则查询顶级行政区域列表
     * @param parentId 父级id
     * @return 行政区域列表
     */
    List<Region> listByParentId(Long parentId);
}