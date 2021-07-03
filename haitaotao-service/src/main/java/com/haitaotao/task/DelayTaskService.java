package com.haitaotao.task;

import com.haitaotao.entity.GrouponRules;
import com.haitaotao.service.IGrouponRulesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;

/**
 * @author yangyang
 * @date 2021/5/7 15:57
 */
@Slf4j
@Component
public class DelayTaskService implements ApplicationListener<ContextRefreshedEvent> {

    private final DelayQueue<Task> delayQueue = new DelayQueue<>();

    @Autowired
    private IGrouponRulesService grouponRulesService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info(">>>>>>>>>>>>系统启动完成");
        log.info(">>>>>>>>>>>>加载延时任务");
        List<GrouponRules> ruleList = grouponRulesService.listStatusOn();

        if (CollectionUtils.isNotEmpty(ruleList)) {
            Date now = new Date();
            for (GrouponRules rules : ruleList) {
                Date expireTime = rules.getExpireTime();

                if(expireTime.before(now)) {
                    // 已经过期，则加入延迟队列
                    addTask(new GrouponRuleExpiredTask(rules.getId(), 0));
                } else{
                    // 还没过期，计算剩余过期时间，则加入延迟队列
                    long delay = expireTime.getTime() - now.getTime();
                    addTask(new GrouponRuleExpiredTask(rules.getId(), delay));
                }
            }
        }
    }

    @PostConstruct
    private void init() {
        log.info(">>>>>>>>>>>>开启单线程延时任务处理");
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                try {
                    Task task = delayQueue.take();
                    task.run();
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        });
    }

    public void addTask(Task task){
        if(delayQueue.contains(task)){
            return;
        }
        delayQueue.add(task);
    }

    public void removeTask(Task task){
        delayQueue.remove(task);
    }
}
