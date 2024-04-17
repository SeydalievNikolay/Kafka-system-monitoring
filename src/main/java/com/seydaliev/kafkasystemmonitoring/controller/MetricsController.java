package com.seydaliev.kafkasystemmonitoring.controller;

import com.seydaliev.kafkasystemmonitoring.model.Metric;
import com.seydaliev.kafkasystemmonitoring.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    @GetMapping("/metrics")
    public List<Metric> getAllMetrics() {
        return metricsService.getAllMetrics();
    }

    @GetMapping("/metrics/{id}")
    public Metric getMetricById(@PathVariable Long id) {
        return metricsService.getMetricById(id);
    }
}
