package com.haitaotao.task;

import com.haitaotao.common.util.BeanUtil;
import com.haitaotao.entity.Groupon;
import com.haitaotao.entity.GrouponRules;
import com.haitaotao.entity.Order;
import com.haitaotao.enums.GrouponEnum;
import com.haitaotao.enums.GrouponRulesEnum;
import com.haitaotao.enums.OrderStatusEnum;
import com.haitaotao.service.IGrouponRulesService;
import com.haitaotao.service.IGrouponService;
import com.haitaotao.service.IOrderService;
import com.haitaotao.util.OrderUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

/**
 * @author yangyang
 * @date 2021/5/8 9:47
 */
@Slf4j
public class GrouponRuleExpiredTask extends Task {

    private final Long grouponRuleId;

    public GrouponRuleExpiredTask(Long grouponRuleId, long delayInMilliseconds) {
        super(String.format("grouponRule-%d", grouponRuleId), delayInMilliseconds);
        this.grouponRuleId = grouponRuleId;
    }

    @Override
    public void run() {
        log.info(">>>>>>>>>>>>>系统开始处理延时任务---团购规则过期--- {}", grouponRuleId);

        IGrouponRulesService rulesService = BeanUtil.getBean(IGrouponRulesService.class);
        IGrouponService grouponService = BeanUtil.getBean(IGrouponService.class);

        GrouponRules rules = rulesService.getById(grouponRuleId);

        if (Objects.isNull(rules) || !Objects.equals(rules.getStatus(), GrouponRulesEnum.RULE_STATUS_ON.getValue())) {
            return;
        }

        // 团购活动取消
        rulesService.updateStatusById(grouponRuleId, GrouponRulesEnum.RULE_STATUS_DOWN_EXPIRE.getValue());

        // 用户团购处理
        List<Groupon> grouponList = grouponService.listByRulesId(grouponRuleId);
        for (Groupon groupon : grouponList) {
            Integer status = groupon.getStatus();

            // 如果团购进行中
            // (1) 团购设置团购失败等待退款状态
            boolean isStatusFail = GrouponEnum.STATUS_NONE.isEquals(status) || GrouponEnum.STATUS_ON.isEquals(status);
            if(isStatusFail){
                grouponService.updateStatusFail(groupon.getId());
            }

            if (GrouponEnum.STATUS_ON.isEquals(status)) {
                IOrderService orderService = BeanUtil.getBean(IOrderService.class);

                // (2) 团购订单申请退款
                boolean success = orderService.grouponExpiredRefund(groupon.getOrderNo());
            }
        }
        log.info("<<<<<<<<<<<<<系统结束处理延时任务---团购规则过期--- {}", grouponRuleId);
    }
}
