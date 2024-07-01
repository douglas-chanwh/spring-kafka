/*
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KafkaHealthIndicatorTest {

    @Mock
    private AdminClient adminClient;

    @Mock
    private ListTopicsResult listTopicsResult;

    @InjectMocks
    private KafkaHealthIndicator kafkaHealthIndicator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHealthUp() throws Exception {
        Mockito.when(adminClient.listTopics()).thenReturn(listTopicsResult);
        Mockito.when(listTopicsResult.names()).thenReturn(CompletableFuture.completedFuture(Collections.emptySet()));

        Health health = kafkaHealthIndicator.health();
        Assertions.assertEquals(Status.UP, health.getStatus());
    }

    @Test
    void testHealthDown() throws Exception {
        Mockito.when(adminClient.listTopics()).thenThrow(new RuntimeException("Kafka unavailable"));

        Health health = kafkaHealthIndicator.health();
        Assertions.assertEquals(Status.DOWN, health.getStatus());
    }
}*/