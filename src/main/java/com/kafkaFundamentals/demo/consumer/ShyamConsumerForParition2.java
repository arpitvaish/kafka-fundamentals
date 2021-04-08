package com.kafkaFundamentals.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

@Slf4j
public class ShyamConsumerForParition2 {
    public static void main(String[] args) {
        //Consumer Properties
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "5000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        List<TopicPartition> partitions = new ArrayList<>();
        partitions.add(new TopicPartition("notification-topic", 2));

        consumer.assign(partitions);

        //Prints the topic subscription list
        Set<TopicPartition> assignments = consumer.assignment();
        for (TopicPartition partition : assignments) {
            System.out.printf("Partition: %s in Topic: %s", partition.partition(), partition.topic());
        }

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records)
                    System.out.println(String.format("Partition: %s in Topic: %s  and value : %s", record.partition(), record.topic(), record.value()));
            }
        } finally {
            consumer.close();
        }

    }
}
