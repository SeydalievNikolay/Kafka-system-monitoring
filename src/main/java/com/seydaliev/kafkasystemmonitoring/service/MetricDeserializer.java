package com.seydaliev.kafkasystemmonitoring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seydaliev.kafkasystemmonitoring.model.Metric;
import org.apache.kafka.common.serialization.Deserializer;

public class MetricDeserializer implements Deserializer<Metric> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Metric deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, Metric.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing metric", e);
        }
    }
}
