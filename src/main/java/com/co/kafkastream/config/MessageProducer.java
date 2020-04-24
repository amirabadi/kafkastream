/*
package com.co.kafkastream.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;


public class MessageProducer {
    public static class  MessagesProducer123{
        @Autowired
        private KafkaTemplate<String,Long> kafkaTemplate;


        @Value("${kafka.topic.input}")
        private String topicName;

        @Value("${kafka.topic.even_output}")
        private String partionedTopicName;

        public void sendMessage(Long message){
           */
/* WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
            context.getBean("")*//*

            ListenableFuture<SendResult<String,Long>> future=kafkaTemplate.send(topicName,message);
            future.addCallback(new ListenableFutureCallback<SendResult<String, Long>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println("Unable to send message=[" + message + "] due to : " + throwable.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, Long> result) {
                    System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata()
                            .offset() + "]");
                }
            });
        }

    }
}

*/
