package com.haitaotao.api.admin.advice;

import com.haitaotao.common.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yangyang
 * @date 2021/1/16 11:17
 */
@Slf4j
@RestControllerAdvice
public class ShiroExceptionHandler {

    /**
     * shiro未认证
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Object unauthenticatedHandler(AuthenticationException e) {
        log.warn(e.getMessage(), e);
        return ResponseUtil.unAuthorized();
    }

    /**
     * shiro未授权
     * @param e
     * @return
     */
    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    public Object unauthorizedHandler(AuthorizationException e) {
        log.warn(e.getMessage(), e);
        return ResponseUtil.forbidden();
    }
}
