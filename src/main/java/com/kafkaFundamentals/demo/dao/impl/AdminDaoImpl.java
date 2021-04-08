package com.kafkaFundamentals.demo.dao.impl;

import com.kafkaFundamentals.demo.dao.AdminDao;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Component
public class AdminDaoImpl implements AdminDao {
    @Override
    public void addTopic(List<String> topicNames, int numberOfPartition, short replicationFactor) throws IOException {

        //Admin Properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        //properties.put("group.id", "test");
        // properties.put("enable.auto.commit", true);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //Instantiate Admin client
        AdminClient adminClient = AdminClient.create(properties);

        //Topic creation configuration
        List<NewTopic> newTopics = new ArrayList<>();
        newTopics = topicNames.stream().map(i -> new NewTopic(i, numberOfPartition, replicationFactor)).collect(Collectors.toList());

        //Create topic
        adminClient.createTopics(newTopics);

        //Close connection
        adminClient.close();
    }
}
