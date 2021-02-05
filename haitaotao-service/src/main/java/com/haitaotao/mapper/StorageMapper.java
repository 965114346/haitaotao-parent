package com.haitaotao.mapper;

import com.haitaotao.entity.Storage;

import java.util.List;

/**
 * 文件存储表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface StorageMapper {

    /**
    * 根据id查询文件存储表
    * @param id
    * @return
    */
    Storage selectByPrimaryKey(Long id);

    /**
    * 条件查询文件存储表列表
    * @param storage
    * @return
    */
    List<Storage> selectByCondition(Storage storage);

    /**
    * 插入文件存储表
    * @param storage
    * @return
    */
    boolean insertSelective(Storage storage);

    /**
    * 更新文件存储表
    * @param storage
    * @return
    */
    boolean updateByPrimaryKey(Storage storage);

    /**
    * 根据id删除文件存储表
    * @param id
    * @return
    */
    boolean deleteByPrimaryKey(Long id);

    /**
    * 根据id批量删除文件存储表
    * @param ids
    * @return
    */
    boolean batchDeleteByPrimaryKey(List<Long> ids);
}