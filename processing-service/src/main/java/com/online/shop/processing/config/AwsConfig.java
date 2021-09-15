/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.processing.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:aws-properties.yml")
@ConfigurationProperties(prefix = "aws")
public class AwsConfig {
    @Value("${access.key}")
    private String awsAccessKey;

    @Value("${secret.key}")
    private String awsSecretKey;

    @Value("${region}")
    private String awsRegion;

    @Bean
    public AWSCredentialsProvider credentialsProvider() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
    }

    @Bean
    public AmazonS3 amazonS3Client() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(awsRegion)
                .withCredentials(credentialsProvider())
                .build();
    }
}
