package com.haitaotao.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author yangyang
 * @date 2021/6/30 14:55
 */
public interface SystemConfigService {

    JSONObject get(Long merchantId, String configName);

    boolean updateById(JSONObject jsonObject, String configName);
}
