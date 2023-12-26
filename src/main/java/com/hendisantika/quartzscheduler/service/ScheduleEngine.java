package com.hendisantika.quartzscheduler.service;

import com.hendisantika.quartzscheduler.model.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
}
