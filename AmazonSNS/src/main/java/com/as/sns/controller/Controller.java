package com.as.sns.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private AmazonSNSClient amazonSNSClient;

    private String TOPIC_ARN = "arn:aws:sns:eu-north-1:296434290329:my-sns-topic";

    @GetMapping("/subscribe/{email}")
    public String subscribeToSNSTopic(@PathVariable("email") String email) {
        SubscribeRequest subscribeRequest =
                new SubscribeRequest(TOPIC_ARN, "email", email);

        amazonSNSClient.subscribe(subscribeRequest);
        return "Check your Email";
    }

    @GetMapping("/subscribe/{msg}")
    public String publishToTopic(@PathVariable("msg") String msg) {
        PublishRequest publishRequest =
                new PublishRequest(TOPIC_ARN, msg, "SNS SprigBoot");

        amazonSNSClient.publish(publishRequest);
        return "Message Published!";
    }
}
