package cn.cheng.sbsm.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 周刘成   2020-1-13
 */
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("在服务启动时初始化，只会执行一次");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
