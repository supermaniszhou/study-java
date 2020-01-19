package cn.cheng.sbsm.schedule;

import cn.cheng.sbsm.service.DemoServic;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.Date;

/**
 * 周刘成   2020-1-19
 */
public class QuartzDemo implements Job {

    @Autowired
    private DemoServic demoServic;

    /**
     * 任务被触发时所执行的方法
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("这是quartz任务调度：" + new Date());
        this.demoServic.addUsers();
    }
}
