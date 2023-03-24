package com.sud.aws_sns_cosumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationSubject;
import org.springframework.cloud.aws.messaging.endpoint.NotificationStatus;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationMessageMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic/subscriber")
public class SnsEndpointController {

    private static final Logger logger = LoggerFactory.getLogger(SnsEndpointController.class);

    @NotificationMessageMapping
    public void receiveNotification(@NotificationMessage String message, @NotificationSubject String subject) {
    	logger.info("************************");
    	logger.info(" Subject : "+subject);
    	logger.info(" Message : "+message);
    	logger.info("Received message '{}' with subject '{}'", message, subject);
    	logger.info("************************");
    }

	/*
	 * @NotificationUnsubscribeConfirmationMapping public void
	 * confirmUnsubscriptionMessage(NotificationStatus notificationStatus) {
	 * logger.info("Unsubscribed from Topic");
	 * notificationStatus.confirmSubscription(); }
	 */

    @NotificationSubscriptionMapping
    public void confirmSubscriptionMessage(NotificationStatus notificationStatus) {
    	logger.info("************************");
        logger.info("Subscribed to Topic");
        notificationStatus.confirmSubscription();
        logger.info("************************");
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<?> testSnsEndpointController()throws Exception
	{
		return ResponseEntity.ok("Test SnsEndpointController api is working fine");
	}
    
}