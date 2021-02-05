package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Footprint;

/**
 * 用户浏览足迹表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IFootprintService {

    /**
     * 分页查询用户浏览足迹列表
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 用户浏览足迹列表
     */
    PageInfo<Footprint> pageList(Integer pageNum, Integer pageSize, Long userId, Long goodsId);
}
