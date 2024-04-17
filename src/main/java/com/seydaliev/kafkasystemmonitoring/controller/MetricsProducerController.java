package com.seydaliev.kafkasystemmonitoring.controller;

import com.seydaliev.kafkasystemmonitoring.model.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsProducerController {

    @Autowired
    private KafkaTemplate<String, Metric> kafkaTemplate;

    @PostMapping("/metrics")
    public void sendMetrics(@RequestBody Metric metrics) {
        kafkaTemplate.send("metricsTopic", metrics);
    }
}
