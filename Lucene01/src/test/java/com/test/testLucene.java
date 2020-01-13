package com.test;

import com.lucene.bean.Article;
import com.lucene.dao.LuceneDao;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * 周刘成   2020-1-6
 */
public class testLucene {

    private LuceneDao dao = new LuceneDao();

    @Test
    public void update() throws IOException {
        Article article = new Article();
        article.setId(99);
        article.setAuther("李胜利");
        article.setTitle("这是测试的索引的");
        article.setContent("学习lucene,好好学习天天向上");
        article.setUrl("https://www.qq.com/");
        dao.updateIndex("title", "引", article);
    }

    @Test
    public void delete() throws Exception {
        dao.delIndex("author", "李胜利");
    }

    @Test
    public void test1() throws IOException {
        for (int i = 1; i < 25; i++) {
            Article article = new Article();
            article.setId(i);
            article.setAuther("李胜利");
            article.setTitle("亚洲");
            article.setContent("七大洲之一");
            article.setUrl("https://www.qq.com/");
            dao.createIndex(article);
        }

    }

    @Test
    public void queryIndex() throws IOException {
        List<Article> list = dao.queryIndex("content", "测");
        System.out.println(list.size());
        list.forEach(s -> {
            System.out.println(s.toString());
        });
    }

    @Test
    public void multiQuery() throws Exception {
        List<Article> list = dao.queryIndex("引", 1, 10);
        list.forEach(s -> {
            System.out.println(s.toString());
        });
    }
}
