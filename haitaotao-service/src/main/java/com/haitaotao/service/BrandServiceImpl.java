package com.haitaotao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.Brand;
import com.haitaotao.mapper.BrandMapper;
import com.haitaotao.service.IBrandService;

/**
 * 品牌商表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageInfo<Brand> pageList(Integer pageNum, Integer pageSize, Long id, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Brand> list = brandMapper.listByCondition(id, name);
        return PageInfo.of(list);
    }

    @Override
    public boolean add(Brand brand) {
        return brandMapper.insert(brand);
    }

    @Override
    public boolean updateById(Brand brand) {
        return brandMapper.updateById(brand);
    }

    @Override
    public boolean removeById(Long id) {
        return brandMapper.removeById(id);
    }
}
