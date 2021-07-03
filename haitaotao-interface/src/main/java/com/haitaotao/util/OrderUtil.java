package com.haitaotao.util;

import com.haitaotao.entity.Order;
import com.haitaotao.enums.OrderStatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 订单流程：下单成功－》支付订单－》发货－》收货
 * 订单状态：
 * 101 订单生成，未支付；102，下单未支付用户取消；103，下单未支付超期系统自动取消
 * 201 支付完成，商家未发货；202，订单生产，已付款未发货，用户申请退款；203，管理员执行退款操作，确认退款成功；
 * 301 商家发货，用户未确认；
 * 401 用户确认收货，订单结束； 402 用户没有确认收货，但是快递反馈已收货后，超过一定时间，系统自动确认收货，订单结束。
 *
 * 当101用户未付款时，此时用户可以进行的操作是取消或者付款
 * 当201支付完成而商家未发货时，此时用户可以退款
 * 当301商家已发货时，此时用户可以有确认收货
 * 当401用户确认收货以后，此时用户可以进行的操作是退货、删除、去评价或者再次购买
 * 当402系统自动确认收货以后，此时用户可以删除、去评价、或者再次购买
 * @author user
 */
public class OrderUtil {

    public static String orderStatusText(Order order) {
        int status = order.getOrderStatus();

        for (OrderStatusEnum value : OrderStatusEnum.values()) {
            if (Objects.equals(value.getValue(), status)) {
                return value.getDesc();
            }
        }

        throw new IllegalStateException("orderStatus不支持");
    }

    public static OrderHandleOption build(Order order) {
        int status = order.getOrderStatus();
        OrderHandleOption handleOption = new OrderHandleOption();

        if (OrderStatusEnum.STATUS_CREATE.isEquals(status)) {
            // 如果订单没有被取消，且没有支付，则可支付，可取消
            handleOption.setCancel(true);
            handleOption.setPay(true);
        } else if (OrderStatusEnum.STATUS_CANCEL.isEquals(status) || OrderStatusEnum.STATUS_AUTO_CANCEL.isEquals(status)) {
            // 如果订单已经取消或是已完成，则可删除
            handleOption.setDelete(true);
        } else if (OrderStatusEnum.STATUS_PAY.isEquals(status)) {
            // 如果订单已付款，没有发货，则可退款
            handleOption.setRefund(true);
        } else if (OrderStatusEnum.STATUS_REFUND.isEquals(status) || OrderStatusEnum.STATUS_REFUND_GROUPON.isEquals(status)) {
            // 如果订单申请退款中，没有相关操作
        } else if (OrderStatusEnum.STATUS_REFUND_CONFIRM.isEquals(status)) {
            // 如果订单已经退款，则可删除
            handleOption.setDelete(true);
        } else if (OrderStatusEnum.STATUS_SHIP.isEquals(status)) {
            // 如果订单已经发货，没有收货，则可收货操作,
            // 此时不能取消订单
            handleOption.setConfirm(true);
        } else if (OrderStatusEnum.STATUS_CONFIRM.isEquals(status) || OrderStatusEnum.STATUS_AUTO_CONFIRM.isEquals(status)) {
            // 如果订单已经支付，且已经收货，则可删除、去评论、申请售后和再次购买
            handleOption.setDelete(true);
            handleOption.setComment(true);
            handleOption.setReBuy(true);
            handleOption.setAfterSale(true);
        } else {
            throw new IllegalStateException("status不支持");
        }

        return handleOption;
    }

    public static List<Integer> orderStatus(Integer showType) {
        // 全部订单
        if (showType == 0) {
            return null;
        }

        List<Integer> status = new ArrayList<>(2);

        if (showType.equals(1)) {
            // 待付款订单
            status.add(OrderStatusEnum.STATUS_CREATE.getValue());
        } else if (showType.equals(2)) {
            // 待发货订单
            status.add(OrderStatusEnum.STATUS_PAY.getValue());
        } else if (showType.equals(3)) {
            // 待收货订单
            status.add(OrderStatusEnum.STATUS_SHIP.getValue());
        } else if (showType.equals(4)) {
            // 待评价订单
            status.add(OrderStatusEnum.STATUS_CONFIRM.getValue());
//            系统超时自动取消，此时应该不支持评价
//            status.add((short)402);
        } else {
            return null;
        }

        return status;
    }


    public static boolean isCreateStatus(Order order) {
        return OrderStatusEnum.STATUS_CREATE.isEquals(order.getOrderStatus());
    }

    public static boolean hasPayed(Order order) {
        return !OrderStatusEnum.STATUS_CREATE.isEquals(order.getOrderStatus())
                && !OrderStatusEnum.STATUS_CANCEL.isEquals(order.getOrderStatus())
                && !OrderStatusEnum.STATUS_AUTO_CANCEL.isEquals(order.getOrderStatus());
    }

    public static boolean isPayStatus(Order order) {
        return OrderStatusEnum.STATUS_PAY.isEquals(order.getOrderStatus());
    }

    public static boolean isShipStatus(Order order) {
        return OrderStatusEnum.STATUS_SHIP.isEquals(order.getOrderStatus());
    }

    public static boolean isConfirmStatus(Order order) {
        return OrderStatusEnum.STATUS_CONFIRM.isEquals(order.getOrderStatus());
    }

    public static boolean isCancelStatus(Order order) {
        return OrderStatusEnum.STATUS_CANCEL.isEquals(order.getOrderStatus());
    }

    public static boolean isAutoCancelStatus(Order order) {
        return OrderStatusEnum.STATUS_AUTO_CANCEL.isEquals(order.getOrderStatus());
    }

    public static boolean isRefundStatus(Order order) {
        return OrderStatusEnum.STATUS_REFUND.isEquals(order.getOrderStatus());
    }

    public static boolean isRefundConfirmStatus(Order order) {
        return OrderStatusEnum.STATUS_REFUND_CONFIRM.isEquals(order.getOrderStatus());
    }

    public static boolean isAutoConfirmStatus(Order order) {
        return OrderStatusEnum.STATUS_AUTO_CONFIRM.isEquals(order.getOrderStatus());
    }
}
