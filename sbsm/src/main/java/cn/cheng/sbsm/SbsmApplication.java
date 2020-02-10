package cn.cheng.sbsm;

import cn.cheng.sbsm.schedule.QuartzDemo;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//在springBoot启动时会扫描@WebServlet，并将该类实例化
@ServletComponentScan
//用于mybatis 扫描mapper 接口
@MapperScan({"cn.cheng.sbsm.mapper"})
//激活缓存
@EnableCaching
//激活定时任务,这个是schedule框架的使用，使用quartz也要这个注解
//@EnableScheduling
@EnableRabbit//激活消息队列注解
public class SbsmApplication {

    public static void main(String[] args) throws SchedulerException {
        SpringApplication.run(SbsmApplication.class, args);


        //第一种写法
        // 1.创建Job对象：你要做什么事？
//        JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();
//        /**
//         * 简单的trigger触发时间：通过Quartz提供一个方法来完成简单的重复调用 cron
//         * Trigger：按照Cron的表达式来给定触发的时间
//         */
//        // 2.创建Trigger对象：在什么时间做？
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
//        // 3.创建Scheduler对象：在什么时间做什么事？
//        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//        scheduler.scheduleJob(job, trigger);
//
//        //启动
//        scheduler.start();
    }

//    第二种方式：启动注册的方法  去除@ServletComponentScan注解 以及在servlet类上的@@WebServlet注解
    /*@Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }*/

}
