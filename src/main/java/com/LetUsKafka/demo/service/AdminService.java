package com.LetUsKafka.demo.service;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    void addTopic(List<String> topicNames, int numberOfPartition, short replicationFactor) throws IOException;

}
