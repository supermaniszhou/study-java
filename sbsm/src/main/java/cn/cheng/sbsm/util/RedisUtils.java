package cn.cheng.sbsm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;

/**
 * 周刘成   2020-1-16
 */
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    public static RedisUtils redisUtils = null;

    public static RedisUtils getInstance() {
        if (redisUtils == null) {
            redisUtils = new RedisUtils();
        }
        return redisUtils;
    }

    /**
     * 写入缓存
     *
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
