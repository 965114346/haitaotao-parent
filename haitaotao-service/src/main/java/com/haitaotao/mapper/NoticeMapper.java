package com.haitaotao.mapper;

import com.haitaotao.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 通知表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
@Repository
public interface NoticeMapper {

    /**
     * 管理后台
     * 条件查询列表
     * @return
     */
    List<Notice> listByCondition();
}