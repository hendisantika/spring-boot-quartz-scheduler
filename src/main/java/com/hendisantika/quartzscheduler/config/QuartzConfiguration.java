package com.hendisantika.quartzscheduler.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@RequiredArgsConstructor
public class QuartzConfiguration {

//  @Autowired
//  QuartzProperties quartzProperties;

    private final QuartzProperties quartzProperties;

}
