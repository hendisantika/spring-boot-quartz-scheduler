package com.hendisantika.quartzscheduler.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 10:05
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@DisallowConcurrentExecution // avoids overlapping executions of the same task (job)
@PersistJobDataAfterExecution
public class ScheduleTask implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();

        Object counterObj = jobDetail.getJobDataMap().get("counter");
        int counter = 1;
        if (counterObj != null) {
            counter = (Integer) counterObj + 1;
        }
        jobDetail.getJobDataMap().put("counter", counter);
        log.info("scheduled task called {} - count {}", jobDetail.getKey(), counter);
    }
}
