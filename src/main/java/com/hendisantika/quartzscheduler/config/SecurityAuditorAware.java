package com.hendisantika.quartzscheduler.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

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
public class SecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("someone@tomtom.com");
    }
}
