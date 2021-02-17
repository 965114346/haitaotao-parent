package com.haitaotao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haitaotao.entity.AfterSale;

/**
 * 售后表
 *
 * @author yangyang
 * @date 2021-1-5 17:36:12
 */
public interface IAfterSaleService {

    /**
     * 售后列表分页
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @param afterSaleNo 售后单号
     * @param orderNo 订单号
     * @param status 审核状态
     * @return 售后列表
     */
    PageInfo<AfterSale> pageList(Integer pageNum, Integer pageSize, String afterSaleNo, String orderNo, Integer status);

    /**
     * 售后通过
     * @param afterSaleNo 售后单号
     * @return 更新结果
     */
    boolean receiptByNo(String afterSaleNo);
}
