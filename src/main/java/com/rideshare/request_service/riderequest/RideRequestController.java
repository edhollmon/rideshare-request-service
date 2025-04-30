package com.rideshare.request_service.riderequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@RestController
@RequestMapping("/ride-request")
public class RideRequestController {

    private static final Logger logger = LoggerFactory.getLogger(RideRequestController.class);

    private final SqsClient sqsClient;

    @Value("${aws.sqs.queue-url}")
    private String queueUrl;

    public RideRequestController(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    @GetMapping("/test")
    public String getMethodName() {
        // Santa Monica, 
        // lat: 34.019455, lon: -118.491191
        RideRequest rideRequest = new RideRequest("34.019455", "-118.491191");
        logger.info("Sending RideRequest: " + rideRequest);

        try {
            SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(rideRequest.toString())
                .build();
            sqsClient.sendMessage(sendMessageRequest);
            logger.info("RideRequest sent to SQS queue successfully.");
        } catch (Exception e) {
            logger.error("Failed to send RideRequest to SQS queue", e);
        }

        return "Hello World";
    }
    
}
