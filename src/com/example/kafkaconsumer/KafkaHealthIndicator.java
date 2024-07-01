package com.example.kafkaconsumer;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class KafkaHealthIndicator implements HealthIndicator {

    @Autowired
    private AdminClient adminClient;

    @Override
    public Health health() {
        try {
            ListTopicsResult topics = adminClient.listTopics();
            topics.names().get(); // This will throw an exception if Kafka is not reachable
            return Health.up().build();
        } catch (InterruptedException | ExecutionException e) {
            return Health.down().withDetail("Error", e.getMessage()).build();
        }
    }
}