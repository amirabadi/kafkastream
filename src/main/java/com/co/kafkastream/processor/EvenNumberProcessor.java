package com.co.kafkastream.processor;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EvenNumberProcessor {
    @Value(value = "${kafka.topic.even_output}")
    private String partitionedTopicName;

    public void process(KStream<String, Long> stream){
        stream
                .filter((k, v) -> v % 2 == 0)
                .mapValues(v -> {
                    System.out.println("Squaring Even :: " + v);
                    return v * v;
                })
                .to(partitionedTopicName);
    }
}
