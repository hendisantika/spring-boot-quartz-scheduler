package com.hendisantika.quartzscheduler.service;

import com.hendisantika.quartzscheduler.entity.ScheduleEntity;
import com.hendisantika.quartzscheduler.model.Schedule;
import com.hendisantika.quartzscheduler.model.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.impl.SchedulerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public Schedule getSchedule(UUID id) {
        Optional<ScheduleEntity> result = schedulerRepository.findById(id);
        return result.map(this::toResource).orElse(null);
    }

    @Override
    @Transactional
    public Schedule stopSchedule(UUID id) {
        return changeStatus(id, Status.DISABLED);
    }

    @Override
    public List<Schedule> getSchedules() {
        Iterable<ScheduleEntity> entities = schedulerRepository.findAll();

        List<Schedule> result = StreamSupport.stream(entities.spliterator(), false)
                .map(this::toResource)
                .collect(Collectors.toList());

        return result;

    }
}
