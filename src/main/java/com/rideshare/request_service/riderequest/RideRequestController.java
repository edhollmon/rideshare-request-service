package com.rideshare.request_service.riderequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/ride-request")
public class RideRequestController {

    private static final Logger logger = LoggerFactory.getLogger(RideRequestController.class);

    private final SqsClient sqsClient;
    private final TripServiceClient tripServiceClient;

    @Value("${aws.sqs.ride-request-queue-url}")
    private String queueUrl;

    public RideRequestController(SqsClient sqsClient, TripServiceClient tripServiceClient) {
        this.sqsClient = sqsClient;
        this.tripServiceClient = tripServiceClient;
    }

    @GetMapping("/test")
    public String getMethodName() {
        RideRequest rideRequest = new RideRequest("-118.491191", "34.019455");
        logger.info("Sending RideRequest: " + rideRequest);

        try {
            // Call the Trip Service's request-trip route
            String tripServiceResponse = tripServiceClient.requestTrip();
            logger.info("Trip Service response: " + tripServiceResponse);

            // Serialize the RideRequest object to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String messageBody = objectMapper.writeValueAsString(rideRequest);

            SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(messageBody)
                .build();
            sqsClient.sendMessage(sendMessageRequest);
            logger.info("RideRequest sent to SQS queue successfully.");
        } catch (Exception e) {
            logger.error("Failed to process RideRequest", e);
        }

        return "Hello World";
    }
}
