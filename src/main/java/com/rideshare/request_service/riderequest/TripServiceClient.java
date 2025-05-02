package com.rideshare.request_service.riderequest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TripServiceClient {

    private final RestTemplate restTemplate;

    public TripServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String requestTrip(RideRequest rideRequest) {
        String tripServiceUrl = "http://localhost:8083/trip/request-trip"; // Replace with actual URL
        return restTemplate.postForObject(tripServiceUrl, rideRequest, String.class); // Send RideRequest in the API call
    }
}
