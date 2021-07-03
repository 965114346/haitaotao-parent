package com.haitaotao.api.admin.advice;

import com.haitaotao.api.admin.util.IpUtil;
import com.haitaotao.common.constant.Constants;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Request日志记录
 *
 * @author yangyang.zhang
 * @date 2018年11月11日23:36:17
 */
@Slf4j
@Aspect
@Component
public class RequestLogHandlerAdvice {

    @Pointcut("execution(* com.haitaotao.api.admin.controller.*.*(..))")
    public void requestLog(){}

    @Around("requestLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        logRequest(joinPoint);
        Object proceed = joinPoint.proceed();

        log.info("result ==> {}", proceed);
        log.info("本次请求耗时: {}ms", System.currentTimeMillis() - start);

        return proceed;
    }

    private void logRequest(JoinPoint joinPoint) {
        // 获取参数
        Object[] args = joinPoint.getArgs();
        // 获取方法签名
        Signature signature = joinPoint.getSignature();
        String signatureName = signature.getDeclaringTypeName().concat(".").concat(signature.getName());

        try {
            // 非web环境获取request会抛出异常，不能使用 @Autowried 注入, 手动捕获异常
            HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
            log.info("before <== {}", new RequestLog(request, signatureName, args));
        } catch (IllegalStateException e) {
            log.warn("can not get HttpServletRequest Object");
        }
    }

    @Data
    private static class RequestLog{

        /**
         * 请求方式:GET,POST,PUT,DELETE...
         */
        private String method;

        /**
         * URL
         */
        private String url;

        /**
         * 请求参数
         */
        private Object[] args;

        /**
         * 方法签名
         */
        private String signatureName;

        /**
         * 请求ip
         */
        private String ip;

        private String token;

        public RequestLog(HttpServletRequest request, String signatureName, Object[] args) {
            this.method = request.getMethod();
            this.url = request.getRequestURL().toString();
            this.ip = IpUtil.getIpAddress(request);
            this.method = request.getMethod();
            this.token = request.getHeader(Constants.TOKEN_ADMIN_KEY);
            this.signatureName = signatureName;
            this.args = args;
        }
    }
}
