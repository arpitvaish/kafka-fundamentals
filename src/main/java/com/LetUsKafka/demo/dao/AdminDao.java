package com.LetUsKafka.demo.dao;

import java.io.IOException;
import java.util.List;

public interface AdminDao {

    void addTopic(List<String> topicNames, int numberOfPartition, short replicationFactor) throws IOException;
}
