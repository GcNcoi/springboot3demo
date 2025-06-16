package com.example.boot3.message.demos.web.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月03日 17:08
 */
@Configuration
public class AppKafkaConfiguration {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("thing")
                .partitions(1)
                .compact()
                .build();
    }

}
