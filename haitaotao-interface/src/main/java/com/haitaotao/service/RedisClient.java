package com.haitaotao.service;

import java.util.Set;

/**
 * @author yangyang
 */
public interface RedisClient {

    /**
     * 用于设置给定 key 的值。如果 key 已经存储其他值, SET 就覆写旧值,且无视类型
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);

    /**
     * 为指定的 key 设置值及其过期时间。如果 key 已经存在， SETEX 命令将会替换旧的值。
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    String setex(String key, int seconds, String value);

    /**
     * 用于获取指定 key 的值。如果 key 不存在，返回 nil 。如果key 储存的值不是字符串类型，返回一个错误
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 用于检查给定 key 是否存在
     * @param key
     * @return
     */
    Boolean exists(String key);

    /**
     * 用于删除已存在的键。不存在的 key 会被忽略
     * @param keys
     * @return
     */
    Long del(String... keys);

    /**
     * 用于设置 key 的过期时间,key 过期后将不再可用。单位以秒计
     * @param key
     * @param seconds
     * @return
     */
    Long expire(String key, int seconds);

    /**
     * 以秒为单位返回 key 的剩余过期时间
     * @param key
     * @return
     */
    Long ttl(String key);

    /**
     * 将 key 中储存的数字值增一。 如果 key 不存在,那么 key 的值会先被初始化为 0 ,然后再执行
     * @param key
     * @return
     */
    Long incr(String key);

    /**
     * 用于为哈希表中的字段赋值 。
     * 如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。
     * 如果字段已经存在于哈希表中，旧值将被覆盖。
     * @param key
     * @param field
     * @param value
     * @return
     */
    Long hset(String key, String field, String value);

    /**
     * 用于返回哈希表中指定字段的值。
     * @param key
     * @param field
     * @return
     */
    String hget(String key, String field);

    /**
     * 用于删除哈希表 key 中的一个或多个指定字段,不存在的字段将被忽略
     * @param key
     * @param field
     * @return
     */
    Long hdel(String key, String... field);

    Set<String> scan(String key, Integer count);

}
