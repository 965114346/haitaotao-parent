package com.haitaotao.api.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author yangyang
 * @date 2021/1/20 11:56
 */
@Data
@AllArgsConstructor
public class UserInfoVO {

    private String name;

    private String avatar;

    private Set<String> roles;

    /**
     * 这里需要转换perms结构，因为对于前端而已API形式的权限更容易理解
     */
    private Set<String> perms;
}
