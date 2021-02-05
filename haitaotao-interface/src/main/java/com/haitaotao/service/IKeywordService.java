package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Keyword;

/**
 * 关键字表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IKeywordService {

    /**
    * 根据id查询关键字表
    * @param id
    * @return
    */
    Keyword selectByPrimaryKey(Long id);

    /**
    * 分页查询关键字表
    * @param keyword
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Keyword> selectByPage(Keyword keyword, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询关键字表
    * @param keyword
    * @return
    */
    List<Keyword> selectByCondition(Keyword keyword);

    /**
    * 添加关键字表
    * @param keyword
    * @return
    */
    boolean insert(Keyword keyword);

    /**
    * 根据id更新关键字表
    * @param keyword
    * @return
    */
    boolean updateByPrimaryKey(Keyword keyword);

    /**
    * 单个删除关键字表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除关键字表(也可单个删除关键字表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
