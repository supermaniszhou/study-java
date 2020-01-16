package cn.cheng.sbsm;

import cn.cheng.sbsm.pojo.User;
import cn.cheng.sbsm.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    private UserService userService;

    @Test
    void contextLoads() {
        List<User> list = userService.selectAllUser();
        list.stream().forEach(u -> {
            System.out.println(u.toString());
        });
    }

    @Test
    void testCache() {
//        第一次查询
        List<User> list = userService.selectAllUser();
//        list.stream().forEach(u -> {
//            System.out.println(u.toString());
//        });
//        第er次查询
        List<User> list2 = userService.selectAllUser();
        list2.stream().forEach(u -> {
            System.out.println(u.toString());
        });
    }

}
