package com.haitaotao.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * @author yangyang
 * @date 2021/5/12 9:24
 */
@Getter
public enum GrouponEnum {

    STATUS_NONE(0, "开团未支付"),
    STATUS_ON(1, "开团中"),

    STATUS_SUCCEED(2, "拼团成功"),
    STATUS_FAIL(3, "开团失败");

    private Integer value;

    private String desc;

    GrouponEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public boolean isEquals(Integer status) {
        return Objects.equals(status, value);
    }
}
