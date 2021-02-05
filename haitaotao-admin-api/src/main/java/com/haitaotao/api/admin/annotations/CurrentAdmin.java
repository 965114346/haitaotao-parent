package com.haitaotao.api.admin.annotations;

import java.lang.annotation.*;

/**
 * @author yangyang
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentAdmin {
}
