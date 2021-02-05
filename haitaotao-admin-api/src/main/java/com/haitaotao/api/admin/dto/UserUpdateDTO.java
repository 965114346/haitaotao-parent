package com.haitaotao.api.admin.dto;

import com.haitaotao.common.util.PatternUtil;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author yangyang
 * @date 2021/1/24 17:02
 */
@Data
public class UserUpdateDTO {

    @NotNull
    private Long id;

    /**
     * 用户昵称或网络名称
     */
    private String nickname;

    /**
     * 性别：0 未知， 1男， 2 女
     */
    @Range(min = 0, max = 2, message = "性别：0 未知， 1男， 2 女")
    private Integer gender;

    /**
     * 0 普通用户，1 VIP用户，2 高级VIP用户
     */
    @Range(min = 0, max = 2, message = "0 普通用户，1 VIP用户，2 高级VIP用户")
    private Integer userLevel;

    /**
     * 用户手机号码
     */
    @Pattern(regexp = PatternUtil.PHONE_REGEX, message = "手机号码格式不正确")
    private String mobile;

    /**
     * 0 可用, 1 禁用, 2 注销
     */
    @Range(min = 0, max = 2, message = "0 可用, 1 禁用, 2 注销")
    private Integer status;
}
