package com.haitaotao.mapper;

import com.haitaotao.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 订单表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:28
 */
@Repository
public interface OrderMapper {

    /**
     * 数量统计
     * @return
     */
    Long count();

    /**
     * 条件查询订单列表
     * @param userIdList 用户id列表
     * @param orderStatusList 订单状态列表
     * @param consignee 收货人
     * @param orderNo 订单编号
     * @param start 开始时间
     * @param end 结束时间
     * @return {@link Order}订单列表
     */
    List<Order> listByCondition(@Param("userIdList") List<Long> userIdList,
                                @Param("orderStatusList") List<Integer> orderStatusList,
                                @Param("consignee") String consignee,
                                @Param("orderNo") String orderNo,
                                @Param("start") Date start,
                                @Param("end") Date end);

    /**
     * 根据订单编号获取订单信息
     * @param orderNo 订单编号
     * @return {@link Order}订单信息
     */
    Order getByOrderNo(String orderNo);

    /**
     * 根据订单编号和版本号更新订单状态
     * @param orderStatus 更新后的订单状态
     * @param orderNo 订单编号
     * @param version 版本号
     * @return
     */
    boolean updateStatusByOrderNoAndVersion(@Param("orderStatus") Integer orderStatus,
                                            @Param("orderNo") String orderNo,
                                            @Param("version") Integer version);
}