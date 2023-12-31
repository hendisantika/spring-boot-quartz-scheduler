package com.hendisantika.quartzscheduler.controller;

import com.hendisantika.quartzscheduler.model.Schedule;
import com.hendisantika.quartzscheduler.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 10:14
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequestMapping(path = "/v1/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Schedule>> list() {
        return ResponseEntity.ok().body(scheduleService.getSchedules());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Schedule> create(@PathVariable("id") UUID id) {
        Schedule schedule = scheduleService.getSchedule(id);
        if (schedule != null) {
            return ResponseEntity.ok().body(schedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Schedule> create(@RequestBody Schedule schedule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                scheduleService.create(schedule)
        );
    }

    @PostMapping(value = "/{id}/$stop", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Schedule> stop(@PathVariable("id") UUID id) {
        Schedule schedule = scheduleService.stopSchedule(id);
        if (schedule != null) {
            return ResponseEntity.ok().body(schedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/{id}/$start", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Schedule> start(@PathVariable("id") UUID id) {
        Schedule schedule = scheduleService.startSchedule(id);
        if (schedule != null) {
            return ResponseEntity.ok().body(schedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
