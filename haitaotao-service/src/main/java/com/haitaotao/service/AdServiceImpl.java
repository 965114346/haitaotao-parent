package com.haitaotao.service;

import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Ad;
import com.haitaotao.mapper.AdMapper;

/**
 * 广告表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class AdServiceImpl implements IAdService {

    @Autowired
    private AdMapper adMapper;

    @Override
    public PageInfo<Ad> pageList(Integer pageNum, Integer pageSize, String name, String content) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> adMapper.listByCondition(name, content));
    }

    @Override
    public boolean add(Ad ad) {
        return adMapper.insert(ad);
    }

    @Override
    public boolean updateById(Ad ad) {
        return adMapper.updateById(ad);
    }

    @Override
    public boolean removeById(Long id) {
        return adMapper.removeById(id);
    }
}
