package com.rideshare.request_service.riderequest;

import lombok.Data;

@Data
public class RideRequest {
    public String pickUpLongitude;
    public String pickUpLatitude;

    public RideRequest(String pickUpLongitude, String pickUpLatitude) {
        this.pickUpLongitude = pickUpLongitude;
        this.pickUpLatitude = pickUpLatitude;
    }
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
