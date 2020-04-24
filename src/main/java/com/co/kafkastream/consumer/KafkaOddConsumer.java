package com.co.kafkastream.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaOddConsumer {
    @KafkaListener(topics = "${kafka.topic.odd_output}",groupId = "bar",containerFactory = "barKafkaListenerContainerFactory")
    public void consumer(Long number) {
        System.out.println(String.format("Consumed :: %d", number));
    }
}
