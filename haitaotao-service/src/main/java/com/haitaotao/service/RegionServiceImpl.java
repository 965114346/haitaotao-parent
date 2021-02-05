package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Region;
import com.haitaotao.mapper.RegionMapper;
import com.haitaotao.service.IRegionService;

/**
 * 行政区域表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:06
 */
@Slf4j
@Service
@DubboService
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<Region> listByParentId(Long parentId) {
        return regionMapper.listByParentId(parentId);
    }

}
