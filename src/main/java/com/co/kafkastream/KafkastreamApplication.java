package com.co.kafkastream;

//import com.co.kafkastream.config.MessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class KafkastreamApplication {
    Long counter=0L;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KafkastreamApplication.class, args);

   //   MessageProducer.MessagesProducer123 producer = context.getBean(MessageProducer.MessagesProducer123.class);
     /*   MessageListener.MessagesListener listener = context.getBean(MessageListener.MessagesListener.class);*/
     //   producer.sendMessage();
    }
  /*  @Scheduled(fixedRate = 1000)
    public void produce() {
        System.out.println("Produced :: " + counter);
       // MessageProducer.MessagesProducer messagesProducer = new MessageProducer.MessagesProducer();
        producer.sendMessage(counter++);
    }*/
}
