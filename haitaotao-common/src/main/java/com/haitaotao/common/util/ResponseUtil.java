package com.haitaotao.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 响应操作结果
 * @author yangyang
 */
public class ResponseUtil {

    /**
     * 成功
     */
    private static final Integer OK = 200;

    /**
     * 未认证
     */
    private static final Integer UNAUTHORIZED = 401;

    /**
     * 拒绝访问
     */
    private static final Integer FORBIDDEN = 403;

    /**
     * 服务异常
     */
    private static final Integer ERROR = 500;

    /**
     * 更新数据已经失效
     */
    private static final Integer UPDATE_DATE_EXPIRED = 501;

    /**
     * 更新失败
     */
    private static final Integer UPDATE_FAIL = 502;


    public static Response ok() {
        return success(null);
    }

    public static Response ok(Object data) {
        return success(data);
    }

    public static Response okList(Number total, List<?> list) {
        return success(new ResponseList(total, list));
    }

    public static Response error() {
        return fail("服务异常");
    }

    public static Response error(String message) {
        return fail(message);
    }

    public static Response updateFail() {
        return build(UPDATE_FAIL, false, "更新失败");
    }

    public static Response updateDateExpired() {
        return build(UPDATE_DATE_EXPIRED, false, "更新失败");
    }

    public static Response unAuthorized() {
        return unAuthorized("无效的凭证");
    }

    public static Response unAuthorized(String message) {
        return build(UNAUTHORIZED, false, message);
    }

    public static Response forbidden() {
        return build(FORBIDDEN, false, "拒绝访问");
    }

    private static Response success(Object data) {
        return new Response(OK, true, "成功", data);
    }

    private static Response fail(String message) {
        return build(ERROR, false, message);
    }

    private static Response build(Integer code, boolean success, String message) {
        return new Response(code, success, message, null);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Response {

        /**
         * 状态码
         */
        private Integer code;

        /**
         * 成功/失败
         */
        private boolean success;

        /**
         * 响应消息
         */
        private String message;

        /**
         * 响应数据
         */
        private Object data;
    }

    @Data
    @AllArgsConstructor
    private static class ResponseList {
        private Number total;
        private List<?> list;
    }
}
