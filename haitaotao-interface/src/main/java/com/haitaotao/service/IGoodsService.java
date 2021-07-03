package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Goods;

/**
 * 商品基本信息表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IGoodsService {

    /**
     * 数量统计
     * @return
     */
    Long count();

    /**
     * 分页查询商品
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @param id 商品id
     * @param goodsNo 商品编号
     * @param name 商品名称
     * @return
     */
    PageInfo<Goods> pageList(Integer pageNum, Integer pageSize, Long id, String goodsNo, String name);

    /**
     * 添加商品
     * @param goods
     * @return
     */
    boolean add(Goods goods);

    /**
     * 更新商品
     * @param goods
     * @return
     */
    boolean updateById(Goods goods);

    /**
     * 删除商品
     * @param id
     * @return
     */
    boolean removeById(Long id);

    /**
     * 根据id获取单个商品
     * @param id 商品id
     * @return
     */
    Goods getById(Long id);
}
