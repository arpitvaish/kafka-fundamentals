package com.kafkaFundamentals.demo.service.impl;

import com.kafkaFundamentals.demo.dao.RamDao;
import com.kafkaFundamentals.demo.service.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RamImpl implements RamService {

    @Autowired
    RamDao ramDao;

    @Override
    public void produce(String topicName, String key, String value) throws IOException {
        ramDao.producer(topicName, key, value);
    }
}
