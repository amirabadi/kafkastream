package com.co.kafkastream.processor;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OddNumberProcessor {

    @Value(value = "${kafka.topic.odd_output}")
    private String oddTopicName;
    public void process(KStream<String,Long> kStream){
        kStream.filter((k,v)->v%2!=0).
                mapValues(v->{
                    System.out.println("Doubling Odd :: " + v);
                    return v * 2;
                }).to(oddTopicName);
    }
}
