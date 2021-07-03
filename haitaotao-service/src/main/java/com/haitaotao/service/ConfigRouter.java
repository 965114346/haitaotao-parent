package com.haitaotao.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author yangyang
 * @date 2021/6/30 16:09
 */
public interface ConfigRouter {

    JSONObject get(Long merchantId);

    boolean updateById(JSONObject jsonObject);
}
