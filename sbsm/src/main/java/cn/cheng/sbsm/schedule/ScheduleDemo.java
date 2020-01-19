package cn.cheng.sbsm.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 周刘成   2020-1-19
 */
//@Component
public class ScheduleDemo {

    /**
     * Cron 表达式是一个字符串，分为6 或7 个域，每一个域代表一个含义
     * (1) seconds minutes hours day month week year
     * (2) seconds minutes hours day month week
     *
     * 1.星号（*）：可用在所有的字段中，便是对应时间域的每一个时刻，例如：*在分钟字段时，表示”每分钟“
     * 2.问号（？）：该字符只在日期和星期字段中使用，它通常指定诶“无意义的值"，相当于占位符
     * 3.减号（-）：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12
     * 4.逗号（,）:表达一个列表值，如在星期字段中使用“MON,WED,FRI”,则表示星期一，时期三和星期五；
     * 5.斜杆（/）:x/y 表达一个等步长序列，x为起始值，y为增量步长值。如在分钟字段中使用 0/15，则表示为0，15,30,45，而5/15在分钟字段中表示5,20,35,50，* 你也可以使用 *(/)y ，它等同于0/y
     * 6.L： 该字符只在日期和星期字段中使用， 代表“Last”的意思， 但它在两个字段中意思不同。 L 在日期
     *      字段中， 表示这个月份的最后一天， 如一月的 31 号， 非闰年二月的 28 号； 如果 L 用在星期中， 则表示星
     *      期六， 等同于 7。 但是， 如果 L 出现在星期字段里， 而且在前面有一个数值 X， 则表示“这个月的最后 X 天”，
     *      例如， 6L 表示该月的最后星期五；
     * 7. W： 该字符只能出现在日期字段里， 是对前导日期的修饰， 表示离该日期最近的工作日。 例如 15W
     *      表示离该月 15 号最近的工作日， 如果该月 15 号是星期六， 则匹配 14 号星期五； 如果 15 日是星期日，
     *      则匹配 16 号星期一； 如果 15 号是星期二， 那结果就是 15 号星期二。 但必须注意关联的匹配日期不能够
     *      跨月， 如你指定 1W， 如果 1 号是星期六， 结果匹配的是 3 号星期一， 而非上个月最后的那天。 W 字符串
     *      只能指定单一日期， 而不能指定日期范围；
     * 8.LW 组合： 在日期字段可以组合使用 LW， 它的意思是当月的最后一个工作日；
     * 9.井号(#)： 该字符只能在星期字段中使用， 表示当月某个工作日。 如 6#3 表示当月的第三个星期五(6
     *      表示星期五， #3 表示当前的第三个)， 而 4#5 表示当月的第五个星期三， 假设当月没有第五个星期三，
     *      忽略不触发；
     * 10. C： 该字符只在日期和星期字段中使用， 代表“Calendar”的意思。 它的意思是计划所关联的日期，
     *      如果日期没有被关联， 则相当于日历中所有日期。 例如 5C 在日期字段中就相当于日历 5 日以后的第一天。
     *      1C 在星期字段中相当于星期日后的第一天。
     * Cron 表达式对特殊字符的大小写不敏感， 对代表星期的缩写英文大小写也不敏感。
     *
     * 例子:
     * @Scheduled(cron = "0 0 1 1 1 ?")//每年一月的一号的 1:00:00 执行一次
     * @Scheduled(cron = "0 0 1 1 1,6 ?") //一月和六月的一号的 1:00:00 执行一次
     * @Scheduled(cron = "0 0 1 1 1,4,7,10 ?") //每个季度的第一个月的一号的 1:00:00 执行一次
     * @Scheduled(cron = "0 0 1 1 * ?")//每月一号 1:00:00 执行一次
     * @Scheduled(cron="0 0 1 * * *") //每天凌晨 1 点执行一次
     */

    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduleMethod(){
        System.out.println("定时器被触发"+new Date());
    }


}