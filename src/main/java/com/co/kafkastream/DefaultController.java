package com.co.kafkastream;

import com.co.kafkastream.producer.KafkaNumberProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @Autowired
    private KafkaNumberProducer kafkaNumberProducer;



    @RequestMapping("/sendMessages/")
        public void consum(){

        kafkaNumberProducer.produce();
        }

}
