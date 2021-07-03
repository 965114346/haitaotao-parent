package com.haitaotao.common.filter;

import com.alibaba.nacos.common.utils.UuidUtils;
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
        traceId = StringUtils.isBlank(traceId) ? UuidUtils.generateUuid() : traceId;

        log.info("traceId: {}", traceId);
        context.setAttachment("traceId", traceId);
        return invoker.invoke(invocation);
    }
}
