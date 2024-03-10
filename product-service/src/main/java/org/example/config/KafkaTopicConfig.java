package org.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.example.constant.KafkaConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic booksTopic() {
        return TopicBuilder.name(KafkaConstant.BOOKS_TOPIC)
                .build();
    }
}
