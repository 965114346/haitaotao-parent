package com.haitaotao.api.admin.shiro;

import lombok.Getter;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * 无状态token
 * @author yangyang
 * @date 2021/1/9 13:42
 */
public class StatelessToken implements AuthenticationToken {

    /**
     * 凭证
     */
    @Getter
    private String token;

    public StatelessToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
