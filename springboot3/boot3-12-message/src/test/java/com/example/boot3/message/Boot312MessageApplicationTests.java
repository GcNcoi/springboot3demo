package com.example.boot3.message;

import com.example.boot3.message.demos.web.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
class Boot312MessageApplicationTests {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Test
    void contextLoads() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompletableFuture[] futures = new CompletableFuture[10000];
        for (int i = 0; i < 10000; i++) {
            CompletableFuture future = kafkaTemplate.send("news", "key-" + i, "value-" + i);
            futures[i] = future;
        }

        CompletableFuture.allOf(futures)
                .join();
        stopWatch.stop();
        System.out.println("消息发送完成:时间为" + stopWatch.getTotalTimeMillis() + "毫秒");
    }

    @Test
    void sendMessage() {
        CompletableFuture future = kafkaTemplate.send("news", "person-", new Person("Gxf", 18));
        future.join();
        System.out.println("消息发送完成");
    }

}
