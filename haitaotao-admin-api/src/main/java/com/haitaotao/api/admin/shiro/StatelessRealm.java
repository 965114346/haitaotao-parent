package com.haitaotao.api.admin.shiro;

import com.alibaba.fastjson.JSONObject;
import com.haitaotao.common.util.JwtUtil;
import com.haitaotao.entity.Admin;
import com.haitaotao.service.IPermissionService;
import com.haitaotao.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 无状态Realm
 * @author yangyang
 * @date 2021/1/9 13:41
 */
@Slf4j
@Component
public class StatelessRealm extends AuthorizingRealm {

    @DubboReference
    private IRoleService roleService;

    @DubboReference
    private IPermissionService permissionService;

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持StatelessToken类型的Token
        return token instanceof StatelessToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        Admin admin = (Admin) getAvailablePrincipal(principals);
        List<Integer> roleIds = JSONObject.parseArray(admin.getRoleIds(), Integer.class);
        Set<String> roles = roleService.listNameByIds(roleIds);
        Set<String> permissions = permissionService.listNameByRoleIds(roleIds);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        StatelessToken statelessToken = (StatelessToken) authenticationToken;
        String token = statelessToken.getToken();

        if (StringUtils.isBlank(token)) {
            throw new AuthenticationException();
        }

        try {
            Admin admin = JwtUtil.verify(JwtUtil.TOKEN_SECRET, token, Admin.class);
            admin.setToken(token);
            return new SimpleAuthenticationInfo(admin, token, getName());
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw e;
        }
    }
}
