package com.haitaotao.mapper;

import com.haitaotao.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品基本信息表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface GoodsMapper {

    /**
     * 根据id查询商品基本信息表
     *
     * @param id
     * @return
     */
    Goods getById(Long id);

    /**
     * 条件查询商品基本信息表列表
     *
     * @param id 商品id
     * @param goodsNo 商品编号
     * @param name 商品名称
     * @return
     */
    List<Goods> listByCondition(@Param("id") Long id,
                                @Param("goodsNo") String goodsNo,
                                @Param("name") String name);

    /**
     * 插入商品基本信息表
     *
     * @param goods
     * @return
     */
    boolean insert(Goods goods);

    /**
     * 更新商品基本信息表
     *
     * @param goods
     * @return
     */
    boolean updateById(Goods goods);

    /**
     * 根据id删除商品基本信息表
     *
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(Long id);

    /**
     * 数量统计
     *
     * @return
     */
    Long count();
}