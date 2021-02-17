package com.haitaotao.service;

import java.util.List;

import com.haitaotao.enums.AfterSaleStatusEnum;
import com.haitaotao.mapper.OrderMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.AfterSale;
import com.haitaotao.mapper.AfterSaleMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 售后表
 *
 * @author yangyang
 * @date 2021-1-6 17:04:05
 */
@Slf4j
@Service
@DubboService
public class AfterSaleServiceImpl implements IAfterSaleService {

    @Autowired
    private AfterSaleMapper afterSaleMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageInfo<AfterSale> pageList(Integer pageNum, Integer pageSize, String afterSaleNo, String orderNo, Integer status) {
        PageHelper.startPage(pageNum, pageSize);
        List<AfterSale> list = afterSaleMapper.listByCondition(afterSaleNo, orderNo, status);
        return PageInfo.of(list);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean receiptByNo(String afterSaleNo) {
        boolean success = afterSaleMapper.updateStatusByNo(afterSaleNo, AfterSaleStatusEnum.STATUS_RECEIPT.getValue());
        if (success) {

        }
        return false;
    }
}
