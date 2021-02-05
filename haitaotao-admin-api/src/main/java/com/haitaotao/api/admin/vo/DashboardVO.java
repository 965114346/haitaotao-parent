package com.haitaotao.api.admin.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yangyang
 * @date 2021/1/21 9:48
 */
@Data
@Accessors(chain = true)
public class DashboardVO {

    private Long userTotal;

    private Long goodsTotal;

    private Long productTotal;

    private Long orderTotal;
}
