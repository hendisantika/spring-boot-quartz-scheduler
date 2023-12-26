package com.hendisantika.quartzscheduler.entity;

import com.hendisantika.quartzscheduler.model.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 10:08
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "demo_schedules")
@Table(name = "demo_schedules")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class ScheduleEntity {

    static TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
    @Id
    @Column(name = "uuid", updatable = false, nullable = false)
    protected UUID id;
    @CreatedBy
    @Column(name = "created_by", updatable = false, nullable = true)
    protected String createdBy;
    @CreatedBy
    @LastModifiedBy
    @Column(name = "updated_by", updatable = true, nullable = true)
    protected String updatedBy;
    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdDate;
    @Column(name = "updated_date", updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updatedDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", updatable = true)
    private Status status;
    @Column(name = "status_reason")
    private String statusReason;
    private String name;
    private String cron;

    public ScheduleEntity() {
        this.id = UUID.randomUUID();
    }

    @PrePersist
    public void ensurePrePersist() {
        if (this.createdDate == null) {
            this.createdDate = Calendar.getInstance(utcTimeZone);
        }
        if (this.updatedDate == null) {
            this.updatedDate = Calendar.getInstance(utcTimeZone);
        }
    }

    @PreUpdate
    public void ensurePreUpdate() {
        this.updatedDate = Calendar.getInstance(utcTimeZone);
    }
}
