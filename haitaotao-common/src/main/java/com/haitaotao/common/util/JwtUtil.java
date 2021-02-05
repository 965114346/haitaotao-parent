package com.haitaotao.common.util;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangyang
 * @date 2020/12/11 21:24
 */
public class JwtUtil {

    /**
     * 过期时间(24小时 * 7)
     */
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;

    /**
     * 私钥
     */
    public static final String TOKEN_SECRET = "privateKey";

    private static final String CLAIM_KEY = "account";

    /**
     * 生成签名
     * @param tokenSecret 私钥
     * @param obj 签名对象
     * @return
     */
    public static String sign(String tokenSecret, Object obj) {
        // 私钥和加密算法
        Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
        // 设置头部信息
        Map<String, Object> header = new HashMap<>(4);
        header.put("Type", "Jwt");
        header.put("alg", "HS256");
        // 返回token字符串
        return JWT.create()
                .withHeader(header)
                .withClaim(CLAIM_KEY, JSONObject.toJSONString(obj))
                // 设置过期时间
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .sign(algorithm);
    }

    /**
     * 检验token是否正确
     * @param tokenSecret 私钥
     * @param token token签名
     * @param clazz 用户信息类
     * @param <T> 用户信息类类型
     * @return 用户信息
     */
    public static <T> T verify(String tokenSecret, String token, Class<T> clazz){
        Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String json = jwt.getClaim(CLAIM_KEY).asString();
        return JSONObject.parseObject(json, clazz);
    }
}
