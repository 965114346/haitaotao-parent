package com.haitaotao.mapper;

import com.haitaotao.entity.Keyword;

import java.util.List;

/**
 * 关键字表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface KeywordMapper {

    /**
    * 根据id查询关键字表
    * @param id
    * @return
    */
    Keyword selectByPrimaryKey(Long id);

    /**
    * 条件查询关键字表列表
    * @param keyword
    * @return
    */
    List<Keyword> selectByCondition(Keyword keyword);

    /**
    * 插入关键字表
    * @param keyword
    * @return
    */
    boolean insertSelective(Keyword keyword);

    /**
    * 更新关键字表
    * @param keyword
    * @return
    */
    boolean updateByPrimaryKey(Keyword keyword);

    /**
    * 根据id删除关键字表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除关键字表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}