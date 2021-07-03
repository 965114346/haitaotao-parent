package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yangyang
 * @date 2021/4/27 15:30
 */
@Data
public class CouponUpdateDTO {

    @NotNull
    private Long id;
}
