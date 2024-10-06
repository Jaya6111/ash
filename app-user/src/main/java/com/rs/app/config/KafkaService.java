package com.rs.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.rs.app.bean.EmailJSON;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void emailContent(EmailJSON details) {
        kafkaTemplate.send(Constants.EMAIL, details);
    }
}
