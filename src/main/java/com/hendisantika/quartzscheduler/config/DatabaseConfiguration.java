package com.hendisantika.quartzscheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 10:09
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class DatabaseConfiguration {

    @Bean
    AuditorAware<String> auditorProvider() {
        return new SecurityAuditorAware();
    }
}
