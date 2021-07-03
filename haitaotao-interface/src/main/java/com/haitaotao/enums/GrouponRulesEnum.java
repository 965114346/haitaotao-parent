package com.haitaotao.enums;

import lombok.Getter;

/**
 * 团购规则枚举
 * @author yangyang
 * @date 2021/5/11 10:45
 */
@Getter
public enum GrouponRulesEnum {

    RULE_STATUS_ON(0, "正常上线"),
    RULE_STATUS_DOWN_EXPIRE(1, "到期自动下线"),
    RULE_STATUS_DOWN_ADMIN(2, "管理手动下线");

    private Integer value;

    private String desc;

    GrouponRulesEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
