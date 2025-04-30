package com.rideshare.request_service.riderequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RideRequest {
    private String pickUpLongitude;
    private String pickUpLatitude;

    // Default constructor for Jackson
    public RideRequest() {
    }

    @JsonCreator
    public RideRequest(
        @JsonProperty("pickUpLongitude") String pickUpLongitude,
        @JsonProperty("pickUpLatitude") String pickUpLatitude
    ) {
        this.pickUpLongitude = pickUpLongitude;
        this.pickUpLatitude = pickUpLatitude;
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
}
