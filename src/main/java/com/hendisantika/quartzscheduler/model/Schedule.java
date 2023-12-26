package com.hendisantika.quartzscheduler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
public class Schedule {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    private String name;

    private String statusReason;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Status status = Status.UNKNOWN;

    private String cron;
}
