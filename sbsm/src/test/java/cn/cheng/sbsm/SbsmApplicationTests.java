package cn.cheng.sbsm;

import cn.cheng.sbsm.jpa.UserRepository;
import cn.cheng.sbsm.pojo.User;
import cn.cheng.sbsm.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * SpringBoot测试类
 *
 * @RunWith:启动器 SpringJUnit4ClassRunner.class：让junit与spring环境进行整合
 * @SpringBootTest(classes={App.class}) 1, 当前类为springBoot的测试类
 * @SpringBootTest(classes={App.class}) 2, 加载SpringBoot启动类。启动springBoot
 * <p>
 * junit与spring整合 @Contextconfiguartion("classpath:applicationContext.xml")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SbsmApplicationTests {

    @Autowired
    @Qualifier("objectRedisTemplate")
    private RedisTemplate<String, Object> rts;

    @Test
    void contextLoads() {
        //向redis中写入缓存
        User user = new User();
        user.setId(100);
        user.setUsername("zhangsan");
        user.setPassword("111111");
        user.setRole("admin");
        rts.opsForValue().set("user", user);
//        System.out.println(rts.opsForValue().get(user.getUsername()));
    }

    @Test
    void tetCreateString() {
        rts.opsForValue().set("name", "tom");
    }

    @Test
    void get() {
        LinkedHashMap map = (LinkedHashMap) rts.opsForValue().get("user");
        System.out.println(map.toString());
    }

    @Test
    void testSetUserJson() {
        User user = new User();
        user.setId(100);
        user.setUsername("zhangsan");
        user.setPassword("111111");
        user.setRole("admin");
        rts.opsForValue().set("user_json", user);
    }

    @Autowired
    private UserRepository userRepository;

    /**
     * test jpa
     */
    @Test
    void testJpa() {
        User user = new User();
        user.setId(7);
        user.setUsername("titi");
        user.setPassword("1111111");
        user.setRole("yu");
        this.userRepository.save(user);
    }


//    @Autowired
//    private UserService userService;

//    @Autowired
//    private StringRedisTemplate redisTemplate;

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate2;
//
//    @Test
//    void contextLoads() {
//        User user = new User();
//        user.setId(100);
//        user.setUsername("zhangsan");
//        user.setPassword("111111");
//        user.setRole("admin");
//        redisTemplate2.opsForValue().set(user.getUsername(), user);
//        System.out.println(redisTemplate2.opsForValue().get(user.getUsername()));
//
//
//    }

//    @Test
//    void contextLoads() {
//        List<User> list = userService.selectAllUser();
//        list.stream().forEach(u -> {
//            System.out.println(u.toString());
//        });
//    }
//
//    @Test
//    void testCache() {
////        第一次查询
//        List<User> list = userService.selectAllUser();
////        list.stream().forEach(u -> {
////            System.out.println(u.toString());
////        });
////        第er次查询
//        List<User> list2 = userService.selectAllUser();
//        list2.stream().forEach(u -> {
//            System.out.println(u.toString());
//        });
//    }
//
//    @Test
//    void testRedis() {
//        redisTemplate.opsForValue().set("a", "test");
//    }
//
//    @Test
//    void testRedisget() {
//        String s = redisTemplate.opsForValue().get("a");
//        System.out.println(s);
//    }
//
//    @Test
//    void testRedisUtil() {
//        User user = new User();
//        user.setId(100);
//        user.setUsername("zhangsan");
//        user.setPassword("111111");
//        user.setRole("admin");
//        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.opsForValue().set("users", String.valueOf(user));
//    }


}
