package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.NoticeAdmin;

/**
 * 通知管理员表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface INoticeAdminService {

    /**
     * 查询通知管理员未读数
     * @param adminId 管理员id
     * @return
     */
    int countUnread(Long adminId);
}
