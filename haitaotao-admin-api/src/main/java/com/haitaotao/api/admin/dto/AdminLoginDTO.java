package com.haitaotao.api.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yangyang
 * @date 2021/1/20 9:57
 */
@Data
@ApiModel(description = "登录参数")
public class AdminLoginDTO {

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotBlank(message = "请输入用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotBlank(message = "请输入密码")
    private String password;

    /**
     * 由于禁用session，导致验证码无法在session中缓存，所以使用缓存对象用于代替
     */
    @ApiModelProperty("验证码Key")
    @NotBlank(message = "codeKey不能为空")
    private String codeKey;

    /**
     * 验证码
     */
    @ApiModelProperty("验证码")
    @NotBlank(message = "请输入验证码")
    private String code;
}
