package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Collect;
import com.haitaotao.mapper.CollectMapper;
import com.haitaotao.service.ICollectService;

/**
 * 收藏表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class CollectServiceImpl implements ICollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public PageInfo<Collect> pageList(Integer pageNum, Integer pageSize, Long userId, Long valueId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Collect> list = collectMapper.listByCondition(userId, valueId);
        return PageInfo.of(list);
    }
}
