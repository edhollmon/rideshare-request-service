package com.rideshare.request_service.riderequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class RideRequest {
    private String pickUpLongitude;
    private String pickUpLatitude;
    private String riderId;

    // Default constructor for Jackson
    public RideRequest() {
        this.riderId = UUID.randomUUID().toString(); // Generate a random ID by default
    }

    @JsonCreator
    public RideRequest(
        @JsonProperty("pickUpLongitude") String pickUpLongitude,
        @JsonProperty("pickUpLatitude") String pickUpLatitude
    ) {
        this.pickUpLongitude = pickUpLongitude;
        this.pickUpLatitude = pickUpLatitude;
        this.riderId = UUID.randomUUID().toString(); // Always generate a random ID
    }

    // Getters and setters
    public String getPickUpLongitude() {
        return pickUpLongitude;
    }

    public void setPickUpLongitude(String pickUpLongitude) {
        this.pickUpLongitude = pickUpLongitude;
    }

    public String getPickUpLatitude() {
        return pickUpLatitude;
    }

    public void setPickUpLatitude(String pickUpLatitude) {
        this.pickUpLatitude = pickUpLatitude;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }
}
