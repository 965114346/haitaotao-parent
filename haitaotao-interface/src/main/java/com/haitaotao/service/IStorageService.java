package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Storage;

/**
 * 文件存储表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface IStorageService {

    /**
    * 根据id查询文件存储表
    * @param id
    * @return
    */
    Storage selectByPrimaryKey(Long id);

    /**
    * 分页查询文件存储表
    * @param storage
    * @param pageNo
    * @param pageSize
    * @return
    */
    PageInfo<Storage> selectByPage(Storage storage, Integer pageNo, Integer pageSize);

    /**
    * 不分页查询文件存储表
    * @param storage
    * @return
    */
    List<Storage> selectByCondition(Storage storage);

    /**
    * 添加文件存储表
    * @param storage
    * @return
    */
    boolean insert(Storage storage);

    /**
    * 根据id更新文件存储表
    * @param storage
    * @return
    */
    boolean updateByPrimaryKey(Storage storage);

    /**
    * 单个删除文件存储表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 批量删除文件存储表(也可单个删除文件存储表)
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}
