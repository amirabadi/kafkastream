package com.co.kafkastream.producer;

import com.co.kafkastream.config.KafkaProducerConfig;
//import com.co.kafkastream.config.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class KafkaNumberProducer {
    private long counter=0;

@Autowired
KafkaProducerConfig kafkaProducerConfig;



    public void produce() {
        System.out.println("Produced :: " + counter);
     /*   MessageProducer.MessagesProducer messagesProducer=new MessageProducer.MessagesProducer();
        messagesProducer.sendMessage(counter++);*/
        for (; counter < 1000000; ) {
            try {
                this.kafkaProducerConfig.send(counter++);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
