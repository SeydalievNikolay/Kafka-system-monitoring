package com.seydaliev.kafkasystemmonitoring.service;

import com.seydaliev.kafkasystemmonitoring.model.Metric;
import com.seydaliev.kafkasystemmonitoring.repo.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MetricsService {

    @Autowired
    private MetricRepository repository;
    public void saveMetric(Metric metric) {
        repository.save(metric);
    }

    public List<Metric> getAllMetrics() {
        return repository.findAll();
    }

    public Metric getMetricById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Metric not found"));
    }
}
