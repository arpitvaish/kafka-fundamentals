package com.LetUsKafka.demo.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ProducerDao {
    void producer(String topic, String key, String value) throws IOException;
}
