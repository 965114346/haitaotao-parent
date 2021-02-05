package com.haitaotao.mapper;

import com.haitaotao.entity.Notice;

import java.util.List;

/**
 * 通知表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
public interface NoticeMapper {

    /**
     * 管理后台
     * 条件查询列表
     * @return
     */
    List<Notice> listByCondition();
}