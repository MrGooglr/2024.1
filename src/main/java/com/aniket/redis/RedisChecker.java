package com.aniket.redis;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.RedisClient;
import org.redisson.config.Config;


public class RedisChecker {

    public static void main(String[] args) {
        checkRedis();
    }


    private static void checkRedis() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://slnxsbsdaliipce15.marc.fr.ssg:6379")
                .setDatabase(1);
        RedissonClient redisClient = Redisson.create(config);

        RKeys keys = redisClient.getKeys();
        Iterable<String> allKeys = keys.getKeys();
        long totalSize = 0;

        for (String key : allKeys) {
            RType type = keys.getType(key);
            if (type == RType.OBJECT) {
                RBucket<Object> bucket = redisClient.getBucket(key);
                String value = bucket.get().toString();
                totalSize += value.length();
            } else if (type == RType.LIST) {
                RList<Object> list = redisClient.getList(key);
                totalSize += list.size();
            } else if (type == RType.SET) {
                RSet<Object> set = redisClient.getSet(key);
                totalSize += set.size();
            } else if (type == RType.MAP) {
                RMap<Object, Object> map = redisClient.getMap(key);
                totalSize += map.size();
            }
        }

        long totalKeys = keys.count();
        double averageSize = (double) totalSize / totalKeys;

        System.out.println("Average size of keys in Redis: " + averageSize);

    }

}

