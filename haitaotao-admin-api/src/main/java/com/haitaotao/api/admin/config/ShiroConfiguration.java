package com.haitaotao.api.admin.config;

import com.haitaotao.api.admin.shiro.MultipleRealmAuthenticator;
import com.haitaotao.api.admin.shiro.StatelessAuthFilter;
import com.haitaotao.api.admin.shiro.StatelessRealm;
import com.haitaotao.api.admin.shiro.UsernamePasswordRealm;
import com.haitaotao.common.bcrypt.BCryptPasswordEncoder;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置
 * @author yangyang
 * @date 2021/1/11 10:56
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        // 添加 jwt 专用过滤器，拦截除 /login 和 /logout 外的请求
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("statelessFilter", new StatelessAuthFilter());
        factoryBean.setFilters(filterMap);

        LinkedHashMap<String, String> filterChain = new LinkedHashMap<>();
        // 可匿名访问
        filterChain.put("/api/login", "anon");
        filterChain.put("/api/kaptcha", "anon");
        // 退出登录
        filterChain.put("/logout", "logout");
        // swagger-ui
        filterChain.put("/swagger-ui.html", "anon");
        filterChain.put("/swagger-resources/**", "anon");
        filterChain.put("/swagger/**", "anon");
        filterChain.put("/webjars/**", "anon");
        filterChain.put("/v2/api-docs", "anon");
        // 需登录才能访问
        filterChain.put("/**", "statelessFilter");
        factoryBean.setFilterChainDefinitionMap(filterChain);
        return factoryBean;
    }

    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 交由 Spring 来自动地管理 Shiro-Bean 的生命周期
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * shiro注释需要用，简单说就是保证为shiro创建代理对象，使用aop
     * DefaultAdvisorAutoProxyCreator是用来扫描上下文，寻找所有的Advistor(通知器），将这些Advisor应用到所有符合切入点的Bean中。
     * 所以必须在lifecycleBeanPostProcessor创建之后创建
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 直接代理目标类
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }

    /**
     * 启用Shiro注解
     * 为 Spring-Bean 开启对 Shiro 注解的支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
     * shiro安全管理器
     */
    @Bean
    public SecurityManager securityManager(SubjectFactory subjectFactory,
                                           UsernamePasswordRealm usernamePasswordRealm,
                                           StatelessRealm statelessRealm,
                                           MultipleRealmAuthenticator authenticator) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 配置 ModularRealmAuthenticator
        // FirstSuccessfulStrategy 只要有一个Realm验证成功即可，只返回第一个Realm身份验证成功的认证信息，其他的忽略；
        // AtLeastOneSuccessfulStrategy 只要有一个Realm验证成功即可，和FirstSuccessfulStrategy不同，返回所有Realm身份验证成功的认证信息；(默认)
        // AllSuccessfulStrategy 所有Realm验证成功才算成功，且返回所有Realm身份验证成功的认证信息，如果有一个失败就失败了。
        authenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());
        securityManager.setAuthenticator(authenticator);

        // 无状态主体工厂
        securityManager.setSubjectFactory(subjectFactory);

        // Realm
        ArrayList<Realm> list = new ArrayList<>(4);
        list.add(usernamePasswordRealm);
        list.add(statelessRealm);
        securityManager.setRealms(list);

        // 禁用session, 不保存用户登录状态。保证每次请求都重新认证
        DefaultSessionStorageEvaluator storageEvaluator = new DefaultSessionStorageEvaluator();
        storageEvaluator.setSessionStorageEnabled(false);
        // 关闭shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        subjectDAO.setSessionStorageEvaluator(storageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        // 会话管理器
        // 禁用掉会话调度器，因为我们禁用掉了会话，所以没必要再定期过期会话了
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(false);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }
}
