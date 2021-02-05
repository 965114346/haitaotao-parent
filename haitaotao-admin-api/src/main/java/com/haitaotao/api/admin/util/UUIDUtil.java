package com.haitaotao.api.admin.util;

import java.util.UUID;

/**
 * @author yangyang
 * @date 2021/1/19 11:03
 */
public class UUIDUtil {

    public static String randomUUID() {
        return UUID.randomUUID().toString().substring(24);
    }
}
