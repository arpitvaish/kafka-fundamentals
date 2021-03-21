package com.LetUsKafka.demo.service.impl;

import com.LetUsKafka.demo.dao.AdminDao;
import com.LetUsKafka.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public void addTopic(List<String> topicNames, int numberOfPartition, short replicationFactor) throws IOException {
        adminDao.addTopic(topicNames, numberOfPartition, replicationFactor);
    }
}
