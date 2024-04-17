package com.seydaliev.kafkasystemmonitoring.config;

import com.seydaliev.kafkasystemmonitoring.service.MetricSerializer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import com.seydaliev.kafkasystemmonitoring.model.Metric;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        return new KafkaAdmin(producerFactory().getConfigurationProperties());
    }

    @Bean
    public ProducerFactory<String, Metric> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MetricSerializer.class);
        return props;
    }

    @Bean
    public KafkaTemplate<String, Metric> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic metricsTopic() {
        return TopicBuilder.name("metricsTopic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
