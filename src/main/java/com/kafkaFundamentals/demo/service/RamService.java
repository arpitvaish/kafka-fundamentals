package com.kafkaFundamentals.demo.service;

import java.io.IOException;

public interface RamService {
    public void produce(String topicName, String key, String value) throws IOException;
}
