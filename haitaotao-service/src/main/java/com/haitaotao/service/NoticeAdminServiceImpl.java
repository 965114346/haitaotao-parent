package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.NoticeAdmin;
import com.haitaotao.mapper.NoticeAdminMapper;
import com.haitaotao.service.INoticeAdminService;

/**
 * 通知管理员表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class NoticeAdminServiceImpl implements INoticeAdminService {

    @Autowired
    private NoticeAdminMapper noticeAdminMapper;

    @Override
    public int countUnread(Long adminId) {
        return noticeAdminMapper.countUnread(adminId);
    }
}
