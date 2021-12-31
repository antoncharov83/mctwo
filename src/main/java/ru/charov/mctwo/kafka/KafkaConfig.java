package ru.charov.mctwo.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topicMC3")
                .partitions(10)
                .replicas(1)
                .build();
    }
}
