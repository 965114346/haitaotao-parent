package com.haitaotao.mapper;

import com.haitaotao.entity.NoticeAdmin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 通知管理员表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
@Repository
public interface NoticeAdminMapper {

    /**
     * 查询通知管理员未读数
     * @param adminId 管理员id
     * @return
     */
    int countUnread(Long adminId);
}