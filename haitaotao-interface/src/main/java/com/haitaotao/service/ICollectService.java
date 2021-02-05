package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Collect;

/**
 * 收藏表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface ICollectService {

    /**
     * 分页查询用户收藏
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @param userId 用户id
     * @param valueId 如果type=0，则是商品ID；如果type=1，则是专题ID
     * @return 用户收藏列表
     */
    PageInfo<Collect> pageList(Integer pageNum, Integer pageSize, Long userId, Long valueId);
}
