package com.LetUsKafka.demo.service.impl;

import com.LetUsKafka.demo.dao.ProducerDao;
import com.LetUsKafka.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProducerImpl implements ProducerService {

    @Autowired
    ProducerDao producerDao;

    @Override
    public void produce(String topicName, String key, String value) throws IOException {
        producerDao.producer(topicName, key, value);
    }
}
