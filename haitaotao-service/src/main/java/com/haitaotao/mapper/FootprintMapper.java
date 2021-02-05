package com.haitaotao.mapper;

import com.haitaotao.entity.Footprint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户浏览足迹表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface FootprintMapper {

    /**
     * 条件查询用户浏览足迹表列表
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 用户浏览足迹表列表
     */
    List<Footprint> listByCondition(@Param("userId") Long userId, @Param("goodsId") Long goodsId);
}