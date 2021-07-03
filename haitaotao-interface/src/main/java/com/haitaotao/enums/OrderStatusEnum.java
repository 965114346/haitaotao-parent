package com.haitaotao.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * @author yangyang
 * @date 2021/5/12 11:34
 */
@Getter
public enum OrderStatusEnum {

    STATUS_CREATE(101, "未付款"),
    STATUS_PAY(201, "已付款"),
    STATUS_SHIP(301, "已发货"),
    STATUS_CONFIRM(401, "已收货"),
    STATUS_CANCEL(102, "已取消"),
    STATUS_AUTO_CANCEL(103, "已取消(系统)"),
    STATUS_ADMIN_CANCEL(104, "拼团成功"),
    STATUS_REFUND(202, "订单取消，退款中"),
    STATUS_REFUND_CONFIRM(203, "已退款"),
    STATUS_REFUND_GROUPON(204, "已超时团购"),
    STATUS_AUTO_CONFIRM(402, "已收货(系统)");

    private Integer value;

    private String desc;

    OrderStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public boolean isEquals(Integer status) {
        return Objects.equals(this.value, status);
    }
}
