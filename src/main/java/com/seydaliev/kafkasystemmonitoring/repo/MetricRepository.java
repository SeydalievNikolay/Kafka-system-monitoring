package com.seydaliev.kafkasystemmonitoring.repo;

import com.seydaliev.kafkasystemmonitoring.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {
}
