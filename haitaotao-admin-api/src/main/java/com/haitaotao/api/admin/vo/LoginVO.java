package com.haitaotao.api.admin.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yangyang
 * @date 2021/1/18 16:37
 */
@Data
@AllArgsConstructor
@ApiModel(description = "登录返回")
public class LoginVO {

    private String token;
}
