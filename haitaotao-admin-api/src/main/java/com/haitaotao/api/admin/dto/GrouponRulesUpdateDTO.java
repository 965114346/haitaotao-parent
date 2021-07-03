package com.haitaotao.api.admin.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yangyang
 * @date 2021/5/4 15:25
 */
@Data
public class GrouponRulesUpdateDTO {

    /**
     * 团购规则id
     */
    @NotNull
    private Long id;

    /**
     * 商品表的商品ID
     */
    @NotNull
    private Long goodsId;

    /**
     * 优惠金额
     */
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal discount;

    /**
     * 达到优惠条件的人数
     */
    @NotNull
    private Integer discountMember;

    /**
     * 团购过期时间
     */
    @NotNull
    @Future
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expireTime;
}
