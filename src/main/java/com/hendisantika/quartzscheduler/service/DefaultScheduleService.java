package com.hendisantika.quartzscheduler.service;

import com.hendisantika.quartzscheduler.entity.ScheduleEntity;
import com.hendisantika.quartzscheduler.model.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.impl.SchedulerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 10:02
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultScheduleService implements ScheduleService {

    private final ScheduleEngine scheduleEngine;

    private final SchedulerRepository schedulerRepository;

    @Override
    @Transactional
    public Schedule create(Schedule schedule) {

        ScheduleEntity entity = toEntity(schedule);
        entity = schedulerRepository.save(entity);
        startSchedule(entity.getId());

        return schedule;
    }
}
