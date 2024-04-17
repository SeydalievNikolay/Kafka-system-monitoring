package com.seydaliev.kafkasystemmonitoring.service;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seydaliev.kafkasystemmonitoring.model.Metric;
import org.springframework.core.serializer.Serializer;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.io.OutputStream;

public class MetricSerializer implements Serializer<Metric> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void serialize(@NonNull Metric data, @NonNull OutputStream outputStream) throws IOException {
        if (data == null) {
            return;
        }
        objectMapper.writeValue(outputStream, data);
    }
}
