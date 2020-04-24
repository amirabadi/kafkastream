package com.co.kafkastream.config;

import com.co.kafkastream.processor.EvenNumberProcessor;
import com.co.kafkastream.processor.OddNumberProcessor;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Configuration
@EnableKafka
@EnableKafkaStreams
public class KafkaStreamConfig {
    @Value("${kafka.topic.input}")
    private String inputTopic;

    @Value("${kafka.topic.even_output}")
    private String outputTopic;

@Autowired
private OddNumberProcessor oddNumberProcessor;
@Autowired
private EvenNumberProcessor evenNumberProcessor;
    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamsConfigs(){
        Map<String,Object> config=new HashMap<>();
       // Properties config = new Properties();
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(StreamsConfig.APPLICATION_ID_CONFIG,"kafkastream");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.Long().getClass());
        return new KafkaStreamsConfiguration(config);
    }

    /*    Map<String, Object> config = new HashMap<>();
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(StreamsConfig.APPLICATION_ID_CONFIG,"kafkastream");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.Long().getClass());
        return new StreamsBuilderFactoryBean(config);
*/


    @Bean
    public KStream<String, Long> kStream(StreamsBuilder kStreamBuilder) {
        KStream<String, Long> stream = kStreamBuilder.stream(inputTopic);
        this.oddNumberProcessor.process(stream);
        this.evenNumberProcessor.process(stream);
        return stream;
    }
}

