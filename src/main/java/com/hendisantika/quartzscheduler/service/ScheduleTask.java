package com.hendisantika.quartzscheduler.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.PersistJobDataAfterExecution;

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

}
