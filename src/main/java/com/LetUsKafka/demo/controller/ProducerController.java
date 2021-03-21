package com.LetUsKafka.demo.controller;

import com.LetUsKafka.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/kafka-fundamentals/")
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @PostMapping(value = "/produce", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> produceData(@RequestParam("topicName") String topicName,
                                         @RequestParam("key") String key, @RequestParam("value") String value) throws IOException {
        producerService.produce(topicName, key, value);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
