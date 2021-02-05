package com.haitaotao.common.enums;

import lombok.Getter;

/**
 * 状态枚举
 * @author yangyang
 * @date 2021/1/9 14:53
 */
public enum EnumStatus {

    USABLE(0, "可用"),
    DISABLE(1, "禁用");

    @Getter
    private Integer value;

    @Getter
    private String name;

    EnumStatus(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
