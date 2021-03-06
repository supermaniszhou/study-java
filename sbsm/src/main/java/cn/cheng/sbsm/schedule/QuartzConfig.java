package cn.cheng.sbsm.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 周刘成   2020-1-19
 */
//@Configuration
public class QuartzConfig {

    //这个非常重要，如果没有这一句就会报空指针，在job中无法注入service,  就是把MyAdaptableJobFactory注入,
    //在schedulerFactoryBean方法中  factory.setJobFactory(jobFactory);
    @Autowired
    private MyAdaptableJobFactory jobFactory;

    /**
     * 1.创建Job对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        //关联我们自己的job类
        factoryBean.setJobClass(QuartzDemo.class);
        return factoryBean;
    }

    /**
     * Cron Trigger
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //设置触发时间
        factoryBean.setCronExpression("0/5 * * * * ?");
        return factoryBean;
    }

    /**
     * 3.创建Scheduler对象
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(jobFactory);
        //关联trigger
        factory.setTriggers(cronTriggerFactoryBean.getObject());
        return factory;
    }


}
