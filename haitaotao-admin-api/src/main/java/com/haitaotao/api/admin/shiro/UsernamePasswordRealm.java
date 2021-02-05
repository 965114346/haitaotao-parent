package com.haitaotao.api.admin.shiro;

import com.haitaotao.common.bcrypt.BCryptPasswordEncoder;
import com.haitaotao.common.util.JwtUtil;
import com.haitaotao.entity.Admin;
import com.haitaotao.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 用户名密码认证
 * @author yangyang
 * @date 2021/1/9 14:25
 */
@Slf4j
@Component
public class UsernamePasswordRealm extends AuthorizingRealm {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @DubboReference
    private IAdminService adminService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());


        Admin admin = adminService.getByUsername(username);

        if (Objects.nonNull(admin)) {

            // 匹配密码
            if (!bCryptPasswordEncoder.matches(password, admin.getPassword())) {
                throw new IncorrectCredentialsException();
            }

            String tokenString = JwtUtil.sign(JwtUtil.TOKEN_SECRET, admin);
            admin.setToken(tokenString);
            return new SimpleAuthenticationInfo(admin, password, getName());
        }

        // 用户不存在
        throw new UnknownAccountException();
    }
}
