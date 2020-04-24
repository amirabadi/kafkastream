package com.co.kafkastream.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSquareConsumer {

    @KafkaListener(topics = "${kafka.topic.even_output}",groupId = "partitions",containerFactory = "partitionsKafkaListenerContainerFactory")
    public void consumer(Long number) {
        System.out.println(String.format("Consumed :: %d", number));
    }
}
