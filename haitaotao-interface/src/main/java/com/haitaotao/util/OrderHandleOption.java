package com.haitaotao.util;

import lombok.Data;

/**
 * @author user
 */
@Data
public class OrderHandleOption {

    /**
     * 取消操作
     */
    private boolean cancel;

    /**
     * 删除操作
     */
    private boolean delete;
    /**
     * 支付操作
     */
    private boolean pay;
    /**
     * 评论操作
     */
    private boolean comment;
    /**
     * 确认收货操作
     */
    private boolean confirm;

    /**
     * 取消订单并退款操作
     */
    private boolean refund;
    /**
     * 再次购买
     */
    private boolean reBuy;

    /**
     * 售后操作
     */
    private boolean afterSale;
}
