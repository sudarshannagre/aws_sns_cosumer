package com.sud.aws_sns_cosumer.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudAwsConfig {

	BasicAWSCredentials basicAwsCredentials = new BasicAWSCredentials("AccessKey",
			"SecretAccessKey");

	@Bean
	public NotificationMessagingTemplate notificationMessagingTemplate(AmazonSNS amazonSNS) {
		return new NotificationMessagingTemplate(amazonSNS);
	}

	@Bean
	public AmazonSNS createSNSClient() {
		return AmazonSNSClientBuilder.standard().withRegion("region")
				.withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials)).build();
	}

	/*
	 * BasicAWSCredentials basicAwsCredentials = new
	 * BasicAWSCredentials(AccessKey,SecretAccessKey); AmazonSNS snsClient =
	 * AmazonSNSClient .builder() .withRegion("us-east-1") .withCredentials(new
	 * AWSStaticCredentialsProvider(basicAwsCredentials)) .build();
	 */

}