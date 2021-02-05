package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Notice;

/**
 * 通知表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:13
 */
public interface INoticeService {

    /**
     * 通知分页列表
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageInfo<Notice> pageList(Integer pageNum, Integer pageSize);
}
