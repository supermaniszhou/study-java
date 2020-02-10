package cn.cheng.sbsm.service;

import cn.cheng.sbsm.pojo.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 周刘成   2020-2-10
 */
@Service
public class BookService {

    @RabbitListener(queues = {"atguigu.news"})
    public void getBook(Book book) {
        System.out.println("收到的消息：" + book.toString());
    }

    @RabbitListener(queues = {"atguigu.news"})
    public void getBook2(Message book) {
        System.out.println(book.getBody());
        System.out.println(book.getMessageProperties());
    }
}
