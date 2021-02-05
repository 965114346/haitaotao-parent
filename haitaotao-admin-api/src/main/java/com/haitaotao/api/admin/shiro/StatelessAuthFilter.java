package com.haitaotao.api.admin.shiro;

import com.alibaba.fastjson.JSONObject;
import com.haitaotao.common.constant.Constants;
import com.haitaotao.common.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 无状态认证过滤
 * 这里不使用{@Component}注解
 * 不向 Spring容器中注册 StatelessAuthFilter Bean，防止 Spring 将 StatelessAuthFilter 注册为全局过滤器
 * @author yangyang
 * @date 2021/1/9 13:34
 */
@Slf4j
public class StatelessAuthFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        HttpServletRequest request = WebUtils.toHttp(servletRequest);
        String token = request.getHeader(Constants.TOKEN_ADMIN_KEY);

        if (StringUtils.isBlank(token)) {
            return false;
        }

        Subject subject = getSubject(servletRequest, servletResponse);
        try {
            subject.login(new StatelessToken(token));
        } catch (AuthenticationException e) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletResponse response = WebUtils.toHttp(servletResponse);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(JSONObject.toJSONString(ResponseUtil.unAuthorized()));
        return false;
    }
}
