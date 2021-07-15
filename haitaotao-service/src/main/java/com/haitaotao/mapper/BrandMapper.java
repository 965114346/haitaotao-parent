package com.haitaotao.mapper;

import com.haitaotao.entity.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 品牌商表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
@Repository
public interface BrandMapper {

    /**
     * 条件查询品牌商表列表
     * @param id 品牌id
     * @param name 品牌名称
     * @return 品牌商列表
     */
    List<Brand> listByCondition(@Param("id") Long id, @Param("name") String name);

    /**
     * 添加品牌商
     * @param brand 品牌商数据
     * @return 添加结果
     */
    boolean insert(Brand brand);

    /**
     * 更新品牌商
     * @param brand 品牌商数据
     * @return 更新结果
     */
    boolean updateById(Brand brand);

    /**
     * 商城品牌商
     * @param id 品牌商id
     * @return 移除结果
     */
    boolean removeById(Long id);
}