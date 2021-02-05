package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Aftersale;

/**
 * 售后表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:12
 */
public interface IAftersaleService {

    /**
    * 根据id查询售后表
    * @param id
    * @return
    */
    Aftersale selectByPrimaryKey(Long id);

    /**
    * 分页查询售后表
    * @param aftersale
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Aftersale> selectByPage(Aftersale aftersale, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询售后表
    * @param aftersale
    * @return
    */
    List<Aftersale> selectByCondition(Aftersale aftersale);

    /**
    * 添加售后表
    * @param aftersale
    * @return
    */
    boolean insert(Aftersale aftersale);

    /**
    * 根据id更新售后表
    * @param aftersale
    * @return
    */
    boolean updateByPrimaryKey(Aftersale aftersale);

    /**
    * 单个删除售后表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除售后表(也可单个删除售后表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
