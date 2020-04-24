package com.co.kafkastream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public KafkaProducerConfig initProducer() {
                return new KafkaProducerConfig();
            }
}
