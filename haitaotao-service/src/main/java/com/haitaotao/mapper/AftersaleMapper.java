package com.haitaotao.mapper;

import com.haitaotao.entity.Aftersale;

import java.util.List;

/**
 * 售后表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface AftersaleMapper {

    /**
    * 根据id查询售后表
    * @param id
    * @return
    */
    Aftersale selectByPrimaryKey(Long id);

    /**
    * 条件查询售后表列表
    * @param aftersale
    * @return
    */
    List<Aftersale> selectByCondition(Aftersale aftersale);

    /**
    * 插入售后表
    * @param aftersale
    * @return
    */
    boolean insertSelective(Aftersale aftersale);

    /**
    * 更新售后表
    * @param aftersale
    * @return
    */
    boolean updateByPrimaryKey(Aftersale aftersale);

    /**
    * 根据id删除售后表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除售后表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}