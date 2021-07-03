package com.haitaotao.service;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

import java.util.Set;

/**
 * @author yangyang
 */
public class RedisClientCluster implements RedisClient {

    @Autowired
    private JedisCluster cluster;

    @Override
    public String set(String key, String value) {
        return cluster.set(key, value);
    }

    @Override
    public String setex(String key, int seconds, String value) {
        return cluster.setex(key, seconds, value);
    }

    @Override
    public String get(String key) {
        return cluster.get(key);
    }

    @Override
    public Boolean exists(String key) {
        return cluster.exists(key);
    }

    @Override
    public Long del(String... keys) {
        return cluster.del(keys);
    }

    @Override
    public Long expire(String key, int seconds) {
        return cluster.expire(key, seconds);
    }

    @Override
    public Long ttl(String key) {
        return cluster.ttl(key);
    }

    @Override
    public Long incr(String key) {
        return cluster.incr(key);
    }

    @Override
    public Long hset(String key, String field, String value) {
        return cluster.hset(key, field, value);
    }

    @Override
    public String hget(String key, String field) {
        return cluster.hget(key, field);
    }

    @Override
    public Long hdel(String key, String... field) {
        return cluster.hdel(key, field);
    }

    @Override
    public Set<String> scan(String key, Integer count) {
        return null;
    }
}
