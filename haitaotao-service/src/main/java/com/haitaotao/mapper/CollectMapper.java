package com.haitaotao.mapper;

import com.haitaotao.entity.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 收藏表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
@Repository
public interface CollectMapper {

    /**
     * 条件查询用户收藏列表
     * @param userId 用户id
     * @param valueId 如果type=0，则是商品ID；如果type=1，则是专题ID
     * @return
     */
    List<Collect> listByCondition(@Param("userId") Long userId, @Param("valueId") Long valueId);
}