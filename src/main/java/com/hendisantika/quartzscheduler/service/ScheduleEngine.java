package com.hendisantika.quartzscheduler.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;

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
}
