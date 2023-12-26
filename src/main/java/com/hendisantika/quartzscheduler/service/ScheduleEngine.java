package com.hendisantika.quartzscheduler.service;

import com.hendisantika.quartzscheduler.model.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.quartz.CronScheduleBuilder.cronSchedule;

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
@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleEngine {

    public static final String GROUP_ID = "JOB_PROCESS";
    public static final String PROCESS_ID_KEY = "JOB_PROCESS_ID";

    private final Scheduler scheduler;

    public void start(Schedule schedule) {
        Trigger logTrigger = createTrigger(schedule);
        JobDetail jobDetail = createJobDetail(schedule);
        try {
            scheduler.scheduleJobs(
                    Stream.of(
                                    new SimpleImmutableEntry<>(jobDetail, Collections.singleton(logTrigger))
                            )
                            .collect(Collectors.toMap(SimpleImmutableEntry::getKey, SimpleImmutableEntry::getValue)),
                    true
            );
        } catch (SchedulerException e) {
            log.error("Unable to schedule process {} for monitoring", schedule.getId());
        }
    }

    public void stop(Schedule schedule) {
        try {
            scheduler.unscheduleJob(TriggerKey.triggerKey(schedule.getId().toString(), GROUP_ID));
        } catch (SchedulerException e) {
            log.warn("Unable to unschedule job with id {}", schedule.getId());
        }
    }

    private Trigger createTrigger(Schedule schedule) {
        Instant now = Instant.now();
        return TriggerBuilder.newTrigger()
                .withIdentity(schedule.getId().toString(), GROUP_ID)
                .startAt(new Date(now.toEpochMilli()))
                .withSchedule(cronSchedule(schedule.getCron()))
                .build();
    }

    private JobDetail createJobDetail(Schedule schedule) {
        return JobBuilder.newJob()
                .ofType(ScheduleTask.class)
                .withIdentity(schedule.getId().toString(), GROUP_ID)
                .usingJobData(PROCESS_ID_KEY, schedule.getId().toString())
                .build();
    }
}
