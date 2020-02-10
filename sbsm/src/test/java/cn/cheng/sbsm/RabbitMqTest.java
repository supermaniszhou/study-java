package cn.cheng.sbsm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 周刘成   2020-2-10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SbsmApplication.class)
public class RabbitMqTest {
    @Autowired
    RabbitTemplate template;

    /**
     * 单播（点对点）
     */
    @Test
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "hello world");
        map.put("data", Arrays.asList("test", 123, true));
        //发送的消息序列化默认是采用的jdk的序列化方式，可以添加配置文件以json方式发送数据。
        template.convertAndSend("exchange.direct", "atguigu.news", map);
    }

    @Test
    public void receiver() {
        Object o = template.receiveAndConvert("atguigu");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播方式
     */
    @Test
    public void testFanout() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "hello world");
        map.put("data", Arrays.asList("test", 123, true));
        template.convertAndSend("exchange.fanout", "", map);
    }
}
