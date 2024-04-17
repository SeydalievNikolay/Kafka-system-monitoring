package com.seydaliev.kafkasystemmonitoring.service;

import com.seydaliev.kafkasystemmonitoring.model.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MetricsConsumerService {

    @Autowired
    private MetricsService metricsService;

    @KafkaListener(topics = "metricsTopic", groupId = "metrics-consumer-group")
    public void listen(Metric metrics) {
        try {
            metricsService.saveMetric(metrics);
            System.out.println("Metric saved: " + metrics);
        } catch (Exception e) {
            System.err.println("Error processing metric: " + e.getMessage());
        }
    }
}
