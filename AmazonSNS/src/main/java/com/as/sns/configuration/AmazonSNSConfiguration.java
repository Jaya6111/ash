package com.as.sns.configuration;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonSNSConfiguration {
    public AmazonSNSClient amazonSNSClient(){
        return (AmazonSNSClient) AmazonSNSClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        "AKIAUKBG4J2M2NVEE745",
                                        "b+H0HD7eHPlL2jx/WiTUOYXdGMaiISWieNHF66UE"
                                )
                        )
                )
                .withClientConfiguration(new ClientConfiguration()
                        .withConnectionTimeout(5000)  // 5 seconds
                        .withSocketTimeout(5000))
                .build();
    }
}
