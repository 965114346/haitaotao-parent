package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Region;

/**
 * 行政区域表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IRegionService {

    /**
     * 根据父级查询列表
     * @param parentId 父级id
     * @return 子集行政区域列表
     */
    List<Region> listByParentId(Long parentId);
}
