package com.kafkaFundamentals.demo.controller;

import com.kafkaFundamentals.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/kafka-fundamentals/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping(value = "/addTopic", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> produceData(@RequestParam("topicNames") List<String> topicNames,
                                         @RequestParam("numberOfPartition") int numberOfPartition,
                                         @RequestParam("replicationFactor") short replicationFactor) throws IOException {
        adminService.addTopic(topicNames, numberOfPartition, replicationFactor);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
