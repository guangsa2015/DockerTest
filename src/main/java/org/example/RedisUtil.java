package org.example;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
       public static final String TEST_NAME = "redis_2025_07";
       @Resource
       private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置值
     * @param key
     * @param value
     */
       public void set(String key, Object value) {
           redisTemplate.opsForValue().set(key, value);
       }

    /**
     * 获取值
     * @param key
     * @return
     */
       public Object get(String key) {
           return redisTemplate.opsForValue().get(key);
       }
}
