package com.LetUsKafka.demo.service;

import java.io.IOException;

public interface ProducerService {
    public void produce(String topicName, String key, String value) throws IOException;
}
