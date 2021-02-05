package com.haitaotao.api.admin.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.springframework.stereotype.Component;

/**
 * 无状态主体工厂
 * @author yangyang
 * @date 2021/1/9 12:00
 */
@Component
public class StatelessDefaultSubjectFactory extends DefaultWebSubjectFactory {

    @Override
    public Subject createSubject(SubjectContext context) {
        // 不创建session, 如果之后调用Subject.getSession()将抛出DisabledSessionException异常
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
