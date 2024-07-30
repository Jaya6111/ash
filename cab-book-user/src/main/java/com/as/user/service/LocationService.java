package com.as.user.service;

import com.as.user.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "cab-location",groupId = "user-group")
    public void cabLocation(String location) {
        //System.out.println(location);
        boolean isSend = false;
        if(location.equalsIgnoreCase("return")){
           isSend = updateLocation("got the return object");
        }
        System.out.println((isSend? "Received and returned the message" : "not returned"));
    }


    public boolean updateLocation(String location) {
        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
        return true;
    }
}
