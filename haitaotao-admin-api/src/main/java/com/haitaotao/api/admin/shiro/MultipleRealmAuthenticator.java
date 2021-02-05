package com.haitaotao.api.admin.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authc.pam.ShortCircuitIterationException;
import org.apache.shiro.realm.Realm;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 自定义多realm认证器
 * 多realm认证的时候抛出的异常时有问题的，并不能拿到原异常的信息
 * @author yangyang
 * @date 2021/1/19 17:42
 */
@Slf4j
@Component
public class MultipleRealmAuthenticator extends ModularRealmAuthenticator {

    @Override
    protected AuthenticationInfo doMultiRealmAuthentication(Collection<Realm> realms, AuthenticationToken token) {

        AuthenticationStrategy strategy = getAuthenticationStrategy();

        AuthenticationInfo aggregate = strategy.beforeAllAttempts(realms, token);

        if (log.isTraceEnabled()) {
            log.trace("Iterating through {} realms for PAM authentication", realms.size());
        }

        for (Realm realm : realms) {

            try {
                aggregate = strategy.beforeAttempt(realm, token, aggregate);
            } catch (ShortCircuitIterationException shortCircuitSignal) {
                // Break from continuing with subsequnet realms on receiving
                // short circuit signal from strategy
                break;
            }

            if (realm.supports(token)) {

                log.trace("Attempting to authenticate token [{}] using realm [{}]", token, realm);

                AuthenticationInfo info = null;
                Throwable t = null;
                info = realm.getAuthenticationInfo(token);

                aggregate = strategy.afterAttempt(realm, token, info, aggregate, t);

            }
        }

        aggregate = strategy.afterAllAttempts(token, aggregate);

        return aggregate;
    }
}
