package com.haitaotao.mapper;

import com.haitaotao.entity.AfterSale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 售后表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface AfterSaleMapper {

    /**
     * 条件查询售后表列表
     * @param afterSaleNo 售后单号
     * @param orderNo 订单号
     * @param status 审核状态
     * @return 售后列表
     */
    List<AfterSale> listByCondition(@Param("afterSaleNo") String afterSaleNo,
                                    @Param("orderNo") String orderNo,
                                    @Param("status") Integer status);

    /**
     * 更新售后单状态
     * @param afterSaleNo 售后单号
     * @param status 售后状态
     * @return 更新结果
     */
    boolean updateStatusByNo(@Param("afterSaleNo") String afterSaleNo,
                             @Param("status") Integer status);
}