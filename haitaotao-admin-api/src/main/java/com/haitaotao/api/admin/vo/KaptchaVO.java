package com.haitaotao.api.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yangyang
 * @date 2021/1/19 11:48
 */
@Data
@AllArgsConstructor
public class KaptchaVO {

    private String kaptchaKey;

    private String kaptcha;
}
