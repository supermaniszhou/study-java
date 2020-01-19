package cn.cheng.sbsm.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 周刘成   2020-1-19
 */
public class QuartzDemo implements Job {
    /**
     * 任务被触发时所执行的方法
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("这是quartz任务调度：" + new Date());
    }
}
