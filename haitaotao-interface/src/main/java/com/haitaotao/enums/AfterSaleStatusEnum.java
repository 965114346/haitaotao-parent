package com.haitaotao.enums;

import lombok.Getter;

/**
 * @author yangyang
 */
@Getter
public enum AfterSaleStatusEnum {

    STATUS_INIT(0, "初始状态"),
    STATUS_REQUEST(1, "已申请,待审核"),
    STATUS_RECEIPT(2, "审核通过,待退款"),
    STATUS_REFUND(3, "退款成功"),
    STATUS_REJECT(4, "审核不通过,已拒绝"),
    STATUS_CANCEL(5, "已取消");

    private Integer value;

    private String desc;

    AfterSaleStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
