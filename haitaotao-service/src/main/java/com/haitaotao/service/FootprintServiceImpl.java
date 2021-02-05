package com.haitaotao.service;

import java.util.List;

import com.haitaotao.entity.Feedback;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Footprint;
import com.haitaotao.mapper.FootprintMapper;
import com.haitaotao.service.IFootprintService;

/**
 * 用户浏览足迹表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class FootprintServiceImpl implements IFootprintService {

    @Autowired
    private FootprintMapper footprintMapper;

    @Override
    public PageInfo<Footprint> pageList(Integer pageNum, Integer pageSize, Long userId, Long goodsId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Footprint> list = footprintMapper.listByCondition(userId, goodsId);
        return PageInfo.of(list);
    }

}
