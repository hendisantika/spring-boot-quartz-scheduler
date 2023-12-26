package com.hendisantika.quartzscheduler.service;

import com.hendisantika.quartzscheduler.model.Schedule;

import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
public interface ScheduleService {
    Schedule create(Schedule schedule);

    Schedule getSchedule(UUID id);

    Schedule stopSchedule(UUID id);

    Schedule startSchedule(UUID id);

    List<Schedule> getSchedules();
}
