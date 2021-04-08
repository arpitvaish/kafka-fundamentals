package com.kafkaFundamentals.demo.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface RamDao {
    void producer(String topic, String key, String value) throws IOException;
}
