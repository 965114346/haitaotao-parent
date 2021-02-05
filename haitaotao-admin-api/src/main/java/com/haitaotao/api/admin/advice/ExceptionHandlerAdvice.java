package com.haitaotao.api.admin.advice;

import com.haitaotao.common.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yangyang
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 未知异常处理
     */
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e) {
        log.error("==============异常开始=============");
        log.error("", e);
        log.error("==============异常结束=============");
        return ResponseUtil.error(e.getMessage());
    }

    /**
     * 服务调用异常处理
     */
    @ExceptionHandler(RpcException.class)
    public Object rpcExceptionHandler(RpcException e) {
        log.error(e.getMessage(), e);
        return ResponseUtil.error("远程服务异常");
    }

    /**
     * 验证框架异常捕获处理
     */
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public Object validateExceptionHandler(Exception e) {
        // 校验不通过会被捕获异常，获取绑定结果
        BindingResult bindingResult = null;
        if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        } else if (e instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        }

        // 判断绑定结果错误返回给前端
        if (Objects.nonNull(bindingResult) && bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            String defaultMessage = allErrors.get(allErrors.size() - 1).getDefaultMessage();
            List<String> allMessage = allErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());

            log.warn("validation exception returnMessage ==> {}", defaultMessage);
            log.warn("  all validation exception Message ==> {}", allMessage);
            return ResponseUtil.error(defaultMessage);
        }

        return ResponseUtil.error(e.getMessage());
    }
}

