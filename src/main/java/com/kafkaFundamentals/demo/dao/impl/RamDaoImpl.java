package com.kafkaFundamentals.demo.dao.impl;

import com.kafkaFundamentals.demo.dao.RamDao;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class RamDaoImpl implements RamDao {

    @Override
    public void producer(String topic, String key, String value) throws IOException {

        //Server Properties definition
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("linger.ms", 0);
        properties.put("partitioner.class", "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("request.timeout.ms", 30000);
        properties.put("timeout.ms", 30000);
        properties.put("max.in.flight.requests.per.connection", 5);
        properties.put("retry.backoff.ms", 5);

        //Instantiate Producer Object
        Producer<String, String> producer = new KafkaProducer<>(properties);

        //Send Single message
        producer.send(new ProducerRecord<String, String>(topic, key, value));

        /*

            //Produce batch of data
            for(int i = 0; i<10000; i++){
             producer.send(new ProducerRecord<String, String>(topic, String.valueOf(i), value ));
            }
         */

        //Close the producer object
        producer.close();
    }


}
