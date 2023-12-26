package com.hendisantika.quartzscheduler.repository;

import com.hendisantika.quartzscheduler.entity.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 10:10
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface SchedulerRepository extends CrudRepository<ScheduleEntity, UUID> {
}
