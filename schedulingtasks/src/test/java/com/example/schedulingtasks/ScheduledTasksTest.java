package com.example.schedulingtasks;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.*;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
class ScheduledTasksTest {

    @SpyBean
    private ScheduledTasks scheduledTasks;
    @Test
    void reportCurrentTime() {
        await()
            .atMost(10000, TimeUnit.MILLISECONDS)
            .untilAsserted(
                () -> verify(scheduledTasks, atLeast(2)).reportCurrentTime()
            );
    }
}