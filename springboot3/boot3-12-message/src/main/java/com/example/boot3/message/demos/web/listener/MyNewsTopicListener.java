package com.example.boot3.message.demos.web.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月03日 17:12
 */
@Component
public class MyNewsTopicListener {

    @KafkaListener(topics = "news", groupId = "my-group")
    public void listen(ConsumerRecord consumerRecord) {
        Object key = consumerRecord.key();
        Object value = consumerRecord.value();
        System.out.println("key:" + key + ",value:" + value);
    }

    @KafkaListener(groupId = "my-group1", topicPartitions = {
            @TopicPartition(topic = "news", partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0")})})
    public void listen1(ConsumerRecord consumerRecord) {
        Object key = consumerRecord.key();
        Object value = consumerRecord.value();
        System.out.println("=========key:" + key + ",value:" + value);
    }

}
