package com.haitaotao.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangyang
 */
@Component
@DubboService
public class RedisClientPool implements RedisClient {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(key, value);
        jedis.close();
        return result;
    }

    @Override
    public String setex(String key, int seconds, String value) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.setex(key, seconds, value);
        jedis.close();
        return result;
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    @Override
    public Boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        Boolean exists = jedis.exists(key);
        jedis.close();
        return exists;
    }

    @Override
    public Long del(String... keys) {
        Jedis jedis = jedisPool.getResource();
        Long count = jedis.del(keys);
        jedis.close();
        return count;
    }

    @Override
    public Long expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        Long expire = jedis.expire(key, seconds);
        jedis.close();
        return expire;
    }

    @Override
    public Long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long ttl = jedis.ttl(key);
        jedis.close();
        return ttl;
    }

    @Override
    public Long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long incr = jedis.incr(key);
        jedis.close();
        return incr;
    }

    @Override
    public Long hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        Long hset = jedis.hset(key, field, value);
        jedis.close();
        return hset;
    }

    @Override
    public String hget(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.hget(key, field);
        jedis.close();
        return result;
    }

    @Override
    public Long hdel(String key, String... field) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hdel(key, field);
        jedis.close();
        return result;
    }

    @Override
    public Set<String> scan(String key, Integer count) {
        Set<String> set = new HashSet<>();

        Jedis jedis = jedisPool.getResource();
        // 游标初始值为0
        String cursor = ScanParams.SCAN_POINTER_START;
        ScanParams scanParams = new ScanParams();
        scanParams.match(key);
        scanParams.count(count);

        do {
            ScanResult<String> scan = jedis.scan(cursor, scanParams);
            cursor = scan.getCursor();
            set.addAll(scan.getResult());

            // 返回0 说明遍历完成
        } while (!StringUtils.equals(cursor, "0"));

        return set;
    }
}
