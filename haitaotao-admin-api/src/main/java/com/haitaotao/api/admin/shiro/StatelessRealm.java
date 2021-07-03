package com.haitaotao.api.admin.shiro;

import com.haitaotao.common.util.JwtUtil;
import com.haitaotao.entity.Admin;
import com.haitaotao.entity.Permission;
import com.haitaotao.entity.Role;
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
import java.util.stream.Collectors;

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
        List<Role> roleList = roleService.listRoleByAdminId(admin.getId());

        Set<String> roleNames = roleList.stream().map(Role::getName).collect(Collectors.toSet());
        List<Long> roleIdList = roleList.stream().map(Role::getId).collect(Collectors.toList());
        List<Permission> permissionList = permissionService.listPermissionByRoleIdList(roleIdList);

        Set<String> permissionNames = permissionList.stream().map(Permission::getPermission).collect(Collectors.toSet());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleNames);
        info.setStringPermissions(permissionNames);
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
