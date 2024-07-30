package com.rs.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void emailContent(String content) {
        kafkaTemplate.send(Constants.EMAIL, content);
    }
}
