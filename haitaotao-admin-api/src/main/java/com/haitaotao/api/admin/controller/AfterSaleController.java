package com.haitaotao.api.admin.controller;

import com.github.pagehelper.PageInfo;
import com.haitaotao.api.admin.dto.AfterSaleReceiptDTO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.AfterSale;
import com.haitaotao.service.IAfterSaleService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * 售后管理
 * @author yangyang
 * @date 2021年02月11日17:30:32
 */
@RestController
@RequestMapping("/api/afterSale")
public class AfterSaleController {

    @DubboReference
    private IAfterSaleService afterSaleService;

    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String afterSaleNo,
                       String orderNo,
                       Integer status) {
        PageInfo<AfterSale> pageInfo = afterSaleService.pageList(pageNum, pageSize, afterSaleNo, orderNo, status);
        return ResponseUtil.okList(pageInfo.getTotal(), pageInfo.getList());
    }

    @PostMapping("/receipt")
    public Object receipt(@RequestBody AfterSaleReceiptDTO afterSaleReceiptDTO) {
        boolean success = afterSaleService.receiptByNo(afterSaleReceiptDTO.getAfterSaleNo());
        return success ? ResponseUtil.ok() : ResponseUtil.updateFail();
    }
}
