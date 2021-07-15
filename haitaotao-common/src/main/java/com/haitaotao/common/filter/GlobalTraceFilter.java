package com.haitaotao.common.filter;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author yangyang
 * @date 2021/5/5 10:09
 */
@Slf4j
@Activate(group = {CommonConstants.CONSUMER, CommonConstants.PROVIDER}, order = -99)
public class GlobalTraceFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();
        String traceId = invocation.getAttachment("traceId");

        // 第一次发起调用
        traceId = StringUtils.isBlank(traceId) ? IdUtil.randomUUID() : traceId;

        log.info("traceId: {}", traceId);
        context.setAttachment("traceId", traceId);

        // 日志记录
        String name = invoker.getInterface().getName();
        Object[] args = invocation.getArguments();
        String method = invocation.getMethodName();

        log.info("==> 接口名称: {}", name);
        log.info("==> 方法名称: {}", method);
        log.info("==> 参数: {}", args);

        long now = System.currentTimeMillis();
        Result result = invoker.invoke(invocation);

        // 有异常，记录异常信息
        if (result.hasException()) {
            Throwable e = result.getException();
            log.error("<== dubbo 调用异常 {}", e.getMessage());
        }

        log.info("<== 耗时 {} ms", System.currentTimeMillis() - now);
        return result;
    }
}
